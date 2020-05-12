package pkg_2;
class Return {

	public static void main(String[] args){

		new Return().nix();

	}


	void nix(){ 
		//return;			// OK
		//return null;		// DNC incompat

	}


}
