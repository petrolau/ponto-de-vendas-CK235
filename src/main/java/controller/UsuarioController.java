package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Tipo;
import model.Usuario;
import util.DBUtil;
import view.Login;

public class UsuarioController {
	private Usuario loggedUser;
	private static UsuarioController Controller;

	private UsuarioController() {
	}

	public boolean logar(String usuario, String password) {

		EntityManager em = DBUtil.getEntityManager();
		TypedQuery<Long> lQuery = em
				.createQuery("SELECT COUNT(*) FROM Usuario u WHERE u.login=:login and u.senha=:senha", Long.class);
		lQuery.setParameter("login", usuario);
		lQuery.setParameter("senha", password);
		if (lQuery.getSingleResult() == 1) {
			TypedQuery<Usuario> UserQ = em.createQuery("FROM Usuario u WHERE u.login=:login and u.senha=:senha",
					Usuario.class);
			UserQ.setParameter("login", usuario);
			UserQ.setParameter("senha", password);
			try {
				loggedUser = UserQ.getSingleResult();
			
			} catch (Exception e) {
				System.out.println("Falha ao logar");
				e.printStackTrace();
			}
			DBUtil.closeEntityManager(em);
			return true;
		}
		DBUtil.closeEntityManager(em);
		return false;
	}
	public static void deslogar() {
		UsuarioController.getInstance().loggedUser=null;
		UsuarioController.destroyInstance();
		
	}

	public Usuario getLoggedUser() {
		return loggedUser;
	}

	public void cadastraAdmin() {
		EntityManager em = DBUtil.getEntityManager();
		em.getTransaction().begin();
		String hql = "SELECT COUNT(*) FROM Usuario WHERE tipo=0";
		Query q = em.createQuery(hql);
		Number n = (Number) q.getSingleResult();
		long results = n.longValue();
		if (results == 0) {
			Usuario User = new Usuario();
			User.setLogin("Admin");
			User.setNome("Administrador Padrão");
			User.setSenha("admin");
			User.setCPF("000.000.000-00");
			User.setTipo(Tipo.ADMINISTRADOR);
			em.persist(User);
			em.getTransaction().commit();
		}
		DBUtil.closeEntityManager(em);

	}
	public void cadastrarUsuario(Usuario u) {
		u.setId(null);
		EntityManager em = DBUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();
		DBUtil.closeEntityManager(em);
	}
	public void atualizarUsuario(Usuario u) {
		EntityManager em=DBUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();
		DBUtil.closeEntityManager(em);
	}
	public List<Usuario> getUsuarioList(){
		EntityManager em=DBUtil.getEntityManager();
		TypedQuery<Usuario> q=em.createQuery("FROM Usuario",Usuario.class);
		List<Usuario> u=q.getResultList();
		DBUtil.closeEntityManager(em);
		return u;
	}
	public void deleteUsuario(Usuario u) {
		EntityManager em=DBUtil.getEntityManager();
		em.remove(u);
		DBUtil.closeEntityManager(em);
		
	}

	public static UsuarioController getInstance() {
		if (Controller == null) {
			Controller = new UsuarioController();
		}
		return Controller;
	}

	private static void destroyInstance() {
		Controller = null;
		System.gc();
	}
}
