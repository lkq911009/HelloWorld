package dlValidate;

public class Singleton {

	
	
	
	private static Singleton myInstance;
	int counter=0;
	private Singleton(){
		
	}
	public static Singleton getInstance(){
		if(myInstance==null)
			myInstance= new Singleton();
		return myInstance;
	}

}
