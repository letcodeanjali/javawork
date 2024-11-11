package com.java.Curd;

public class SessionHelper {

	public static SessionFactory getConnection() {
		return new AnnotationConfiguration().configure().buildSessionFactory();
	}
}
