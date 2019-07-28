package com.login.dao;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;



public class loginDao {
	
		
		
		public boolean check(String name, String pass) throws SQLException, ClassNotFoundException {
			
			EntityManager em = null;
			
			try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("project");
			
			em = emf.createEntityManager();
			em.getTransaction().begin();
				
		Query q = em.createQuery("select u from check u where u.uname=?1 and u.pass=?2");
				
			q.setParameter(1, name);
			q.setParameter(2, pass);
				
			List l = q.getResultList();
			
			int list = l.size();
				if(list!=0) {
					return true;
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
				return false;
	
		}
}
