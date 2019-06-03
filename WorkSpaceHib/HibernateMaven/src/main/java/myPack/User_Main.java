package myPack;

//import javax.security.auth.login.Configuration;

//import javax.imageio.spi.ServiceRegistry;

import java.sql.SQLException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class User_Main {
	 static User UObj;
	 static Session session;
	 static SessionFactory sf;
	 
	 private static SessionFactory buildSessionFactory(){
		 Configuration configObj = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class);
		 ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(configObj.getProperties()).buildServiceRegistry();
		 sf = configObj.buildSessionFactory(sr);
		 
		return sf;		 
	 }
	 public static void main(String args[]){
		 System.out.println("1st step");
		 try {
		 session = buildSessionFactory().openSession();
		 session.beginTransaction();
		 for (int i = 101;i<105;i++){
			 UObj = new User();
			 UObj.setUserId(i);
			 UObj.setUserName("abc"+i);
			 UObj.setCreatedBy(new Date());
			 UObj.setCreatedDate(new Date());
			 
			 session.save(UObj);
		 }
		 System.out.println("record saved");
		 session.getTransaction().commit();
		 }catch(Exception e){
			 e.printStackTrace();
			 if(null != session.getTransaction()){
				 //System.err.println("rollback");
				 System.out.println("rollback");
				 session.getTransaction().rollback();
			 }
				
		 }finally{
			 if(session !=null)
				 session.close();
		 }
	 }

}
