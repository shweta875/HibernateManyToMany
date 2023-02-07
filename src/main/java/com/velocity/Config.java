package com.velocity;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class Config {
	public static SessionFactory getSessionFactory() {
		Configuration cfg=new Configuration();
		Properties setting =new Properties();
		
		setting.put(Environment.DRIVER,"com.mysql.cj.jdbc.Driver");
		setting.put(Environment.URL,"jdbc:mysql://localhost:3306/association");
		setting.put(Environment.USER,"root");
		setting.put(Environment.PASS, "root");
		setting.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
		setting.put(Environment.SHOW_SQL, "true");
		setting.put(Environment.HBM2DDL_AUTO,"update");
		
		cfg.setProperties(setting);
		cfg.addPackage("com.velocity");
		cfg.addAnnotatedClass(Employee.class);
		cfg.addAnnotatedClass(Project.class);
	      ServiceRegistry  serviceRegistry= new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
		SessionFactory factory=cfg.buildSessionFactory(serviceRegistry);
		return factory;
		
	}

}