package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBUtil {
	static EntityManagerFactory entityManagerFactory ;
	private DBUtil() {}
	public static EntityManager getEntityManager() {
		entityManagerFactory 
        = Persistence.createEntityManagerFactory("LivrariaPapiro-PU");
		return entityManagerFactory.createEntityManager();
	}
	public static void closeEntityManager(EntityManager em) {
		em.close();
	}
	public static void closeEntityManagerFactory() {
		entityManagerFactory.close();
	}
}
