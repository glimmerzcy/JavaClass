package edu.tju.singleton;

// ����ʽ
public class Singleton {
	final private static Singleton instance = new Singleton();
    
    // some attributes and methods
    
	private Singleton() {
		// do something
	}
	
	public static synchronized Singleton getInstance() {
		return instance;
	}
}

// ����ʽ
public class Singleton {
	private static Singleton instance = null;
	
	// some attributes and methods
	
	private Singleton() {
		if (instance != null) {
			throw new RuntimeException("instantiate more than one time");
		}
		// do something
	}
	
	public static  Singleton getInstance() {
		if (instance == null)
		{
			synchronized(Singleton.class)
			{
				// judge again if instance is instantiated
				if (instance == null)
				instance = new Singleton();
			}
		}
		return instance;
	}
}

