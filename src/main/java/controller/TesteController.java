package controller;

import javax.persistence.EntityManager;

import model.Tipo;
import model.Usuario;
import util.DBUtil;

public class TesteController {
	public static void main(String... args) {
		//cria usuário
		Usuario User= new Usuario();
		User.setLogin("Admin");
		User.setNome("Dj Cleiton Rasta");
		User.setSenha("admin");
		User.setTipo(Tipo.ADMINISTRADOR);
		
		//COloca no banco
		EntityManager em=DBUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(User);
		em.getTransaction().commit();
		DBUtil.closeEntityManager(em);
		DBUtil.closeEntityManagerFactory();
	}
}
