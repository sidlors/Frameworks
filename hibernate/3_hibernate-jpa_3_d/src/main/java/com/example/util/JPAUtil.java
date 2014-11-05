package com.example.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static final EntityManagerFactory emf1;

	static {
		try {
			emf1 = Persistence.createEntityManagerFactory("3_hibernate-jpa_3_i");
		} catch (Exception ex) {
            // Log the exception. 
            System.err.println("Initial EntityManagerFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
		}
	}

	public static EntityManagerFactory getEMF1() {
		return emf1;
	}

	private JPAUtil() {
		// ...
	}


}
