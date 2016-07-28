package com.mz.probin.constants;

public interface Constants {
	
	
	 //Office M-Files
	/*public static final String AUTHENTICATION_URL = "http://192.168.1.101/M-Files/REST/server/authenticationtokens.aspx";
	public static final String USERNAME = "bmistura";
	public static final String PASSWORD = "Passw0rd";
	public static final String VAULTGUID = "{5AA2C725-D0FD-41A2-BF77-13DB9CA7B01E}"; // OFFICE
	public static final String VAULTGUID = "{DC7C04CA-C4AE-4256-9295-C8094D063EB8}"; // LOCAL
	
	public static final String USER_ROLE = "ROLE_USER";*/
	
	// New Document creation url, properties

	//public static final String CREAT_DOC_URL = "http://192.168.1.101/M-Files/REST/objects/9.aspx";
	
	
	// Home M-Files
	  public static final String HOST = "http://192.168.1.101/M-Files/REST";
	 //public static final String HOST = "http://192.168.2.139/REST";

	  public static final String USERNAME = "bmistura";
	  public static final String PASSWORD = "Passw0rd";
	 //public static final String USERNAME = "testuser2";
	// public static final String PASSWORD = "password";
	 //public static final String VAULTGUID = "{78CED0A4-44A0-41A6-94F9-B4D7978A168C}"; // My Vault
	  public static final String VAULTGUID = "{5AA2C725-D0FD-41A2-BF77-13DB9CA7B01E}"; // Office Vault


	
	public static final String USER_ROLE = "ROLE_USER";
	
	  // New Document creation url, properties

	public static final String AUTHENTICATION_URL = /*"/session/authenticationtoken"*/"/server/authenticationtokens";
	public static final String OBJECT_TYPES_URL = "/structure/objecttypes";
	String OBJECT_CLASSES_URL = "/structure/classes";
	String OBJECT_CREATION_URL = "/objects/";
	String OBJECT_LIST_URL = "/objects";
	//public static final String CREAT_DOC_URL = "/objects/0.aspx";
	public static final String CREAT_DOC_URL = "/objects/0";
	public static final String UPLOAD_URL = "/files";
	public static final String TEMP_FILE = "/home/redsofts/tmp/";


	//HTTP related constants
	public static final String X_AUTHENTICATION_HEADER = "X-AuthenticationUtils";
	
	
	
	// ! BASED ON M-FILES
	public static final int Uninitialized = 0;

			// !
	public static final int Text = 1;

			// !
	public static final int Integer = 2;

			// !
	public static final int Floating = 3;

			// !
	public static final int Date = 5;

			// !
	public static final int Time = 6;

			// !
	public static final int Timestamp = 7;

			// !
	public static final int Boolean = 8;

			// !
	public static final int Lookup = 9;

			// !
	public static final int MultiSelectLookup = 10;

			// !
	public static final int Integer64 = 11;

			// !
	public static final int FILETIME = 12;

			// !
	public static final int MultiLineText = 13;

			// !
	public static final int ACL = 14;
}
