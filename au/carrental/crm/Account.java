/*
 * Account
 * v0.1
 * represents an identity to login into carrental
 * 
 * */
package au.carrental.crm;

import java.util.*;

import java.security.SecureRandom;
import java.security.NoSuchAlgorithmException;

import java.security.spec.KeySpec;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.spec.PBEKeySpec;

import au.carrental.CarRental;
import au.carrental.test.Test;

import javax.crypto.SecretKeyFactory;

public class Account {

	
	
	private static final 	int 	ITERATION_COUNT = 32;	//  65536
	private static final 	int 	KEY_LENGTH = 128;
	
	private static 			int 	accountIdPool = 1001;
	private 				String	user;
	//private 				String	passw;
	private 				String	eMail;
	private 				byte[] 	salt;
	private 				byte[]	passwHash_PBKDF2;
	private 				String  saltedHashedPassword;
	
	// ----------------------------------------
	
	public  Account(String user, String passw, String eMail) {
		super();
		this.user = user;
		this.saltedHashedPassword = Account.createPasswHash(passw, this);
		this.eMail = eMail;
	}
	
	public String getUser() {
		return this.user;
	}
	
	protected byte[] getSalt() {
		return this.salt;
	}
	
	/*
	 * steps learnded here:
	 * https://www.baeldung.com/java-password-hashing
	 * https://stackoverflow.com/questions/11667480/why-pbe-generates-same-key-with-different-salt-and-iteration-count/28646410
	 * */
	private static String createPasswHash( String password, Account account ) {
		
		// the hashed passw as byte[], we store
		byte[] passwHash_PBKDF2 = null;
		
		// use PBKDF2
		
		// 1) create salt:  use salt to increse entropy and protection against rainbow attacks against the db
		SecureRandom random = new SecureRandom();
		byte[] salt = new byte[16];
		random.nextBytes(salt);
		
		// remember the salt as byte[]
		account.salt = salt;
		
		// 2) choose Key cipher
		// KeySpec interface: A (transparent) specification of the key material that constitutes a cryptographic key
		KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, ITERATION_COUNT, KEY_LENGTH);
		
		// 3) class represents a factory for secret keys
		SecretKeyFactory factory = null;
		try {
			factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		}
		catch( NoSuchAlgorithmException nsae ) {
			throw new RuntimeException("NoSuchAlgorithmException: ");
		}
		// 4) generate the hash
		try {
			passwHash_PBKDF2 = factory.generateSecret(spec).getEncoded();
		}
		catch( InvalidKeySpecException ikse ) {
			throw new RuntimeException("InvalidKeySpecException: key specification is inappropriate for this secret-key factory");
		}
		
		// remember the hash as byte[]
		account.passwHash_PBKDF2 = passwHash_PBKDF2;
		
		// build the string representation for salt and passw
		String saltStr = new String(salt);
		String hashStr = new String(passwHash_PBKDF2);
		
		StringBuilder sb = new StringBuilder(  );
		sb.append(saltStr).append(":").append(hashStr);
		
		//System.out.println("Account.createPasswHash() : str = " + sb.toString());
		if ( Test.debug ) {
			System.out.println( "\t\taccount hash bytes = " + Arrays.toString(account.passwHash_PBKDF2) );
			System.out.println( "\t\t\\tsalt bytes = " + Arrays.toString(account.salt) );	
		}
		
		
		return sb.toString();
	}
	
	public static Account validateCredentials( String user, String password ) {
		
		if ( Test.debug )
			System.out.println("Account.validateCredentials( "+ user +", " + password + " )");
		
		Account account = null;
		
		// 1) find the account
		// user john_doe 
		CarRental cr = CarRental.getInstance();
		List<Customer> customers = cr.getCustomers();
		
		customer_loop: for( Customer c : customers ) {
			Account a = c.getAccount();
			if ( a.getUser().equals(user) ) {
				account = a;
				break customer_loop;
			}
		}
		
		if (account == null) {
			if(Test.debug)
				System.out.println( "\t\t [Login failed] no account found"  );
			return null;
		}
		
		// 2) ok we have found an account
		byte[] passwHash_PBKDF2 = null;
		
		KeySpec spec = new PBEKeySpec(password.toCharArray(), account.getSalt(), ITERATION_COUNT, KEY_LENGTH);
		
		SecretKeyFactory factory = null;
		
		try {
			factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		}
		catch( NoSuchAlgorithmException nsae ) {
			throw new RuntimeException("NoSuchAlgorithmException: ");
		}		
		
		try {
			passwHash_PBKDF2 = factory.generateSecret(spec).getEncoded();
		}
		catch( InvalidKeySpecException ikse ) {
			throw new RuntimeException("InvalidKeySpecException: key specification is inappropriate for this secret-key factory");
		}		
		
		if ( Test.debug ) {
			System.out.println( "\t\tcomputed hash bytes = " + Arrays.toString(passwHash_PBKDF2) );
			System.out.println( "\t\taccount hash bytes = " + Arrays.toString(account.passwHash_PBKDF2) );
			System.out.println( "\t\tsalt bytes = " + Arrays.toString(account.salt) );			
		}

		// build the string representation for salt and passw
		String saltStr = new String(account.getSalt());
		String hashStr = new String(passwHash_PBKDF2);
		
		StringBuilder sb = new StringBuilder(  );
		sb.append(saltStr).append(":").append(hashStr);		
		
		if ( account.saltedHashedPassword.equals( sb.toString() ) ) {
			if ( Test.debug )
				System.out.println( "\t\t[Login sucessfull]"  );
			return account;
		}
		
		// ok no match
		System.out.println( "\t\t [Login failed] account found, but password invalid!"  );
		return null;	// return null here!!!!
	}

	// ----------------------------------------	
	
	@Override
	public String toString() {
		return "Account [user=" + user + "]";
	}
	
	
	
}
