package main;

import db.DBConnection;
import singleton.Singleton;

public class MainClass {
	public static void main(String[] args) {
		DBConnection.initConnection();
		
		Singleton s = Singleton.getInstance();
		s.cfMemberC.login();
	}
}
