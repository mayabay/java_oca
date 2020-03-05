/*
 * OfficeSession
 * v0.1
 * encapsulates all running sessions
 * 
 * Customer -> Session ( customer at a specific location )
 * login 	-> check for existing session and return last Site
 * logout 	-> return Site 0
 * 
 * */
package au.carrental;
import au.carrental.assets.Site;
import au.carrental.crm.Customer;
import java.util.*;
public class OfficeSession {
	
	private static OfficeSession 		instance;
	
	private			List<Session> 	sessions;

	// ----------------------------------------	
	
	private  OfficeSession() {
		super();
		this.sessions = new ArrayList<>();
	}
	
	public  static OfficeSession buildInstance( ) {
		if ( instance == null ) {
			instance = new OfficeSession();
			return instance;
		} else {
			throw new IllegalStateException("This method can only be called once!");
		}
	}	
	
	// ----------------------------------------
	
	public static OfficeSession getInstance() {
		return instance;
	}	
	
	public Session getSession( Customer customer ) {
		Session session = null;
		sessloop: for ( Session s : this.sessions ) {
			Customer cu = s.getCustomer();
			if ( cu.equals(customer) ) {
				session = s;
				break sessloop;
			}
		}		
		return session;
	}
	
	public Session addSession( Customer customer, Site site ) {
		Session session = new Session( customer, site );
		this.sessions.add( session );
		return session;
	}
	
	public void removeSession( Customer customer ) {
		// need to remove a session
		sessloop: for ( Session s : this.sessions ) {
			Customer cu = s.getCustomer();
			if ( cu.equals(customer) ) { 
				this.sessions.remove(s);
				break sessloop;
			}
		}
	}
	
	public void removeAll() {
		this.sessions.clear();
	}
}
