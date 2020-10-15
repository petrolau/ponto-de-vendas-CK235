package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Usuario;
import model.Venda;
import util.DBUtil;

public class VendaController {
	public static void InserirVenda(Venda v) {
		v.setId(null);
		EntityManager em = DBUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(v);
		em.getTransaction().commit();
		DBUtil.closeEntityManager(em);
	}
	public static void Vender(List<Venda> v) {
		
	}
	public static List<Venda> getVendasList(){
		EntityManager em=DBUtil.getEntityManager();
		TypedQuery<Venda> q=em.createQuery("FROM Venda",Venda.class);
		List<Venda> vs=q.getResultList();
		DBUtil.closeEntityManager(em);
		return vs;
	}
	public static List<Venda> getVendasListByUsuario(Usuario u){
		EntityManager em=DBUtil.getEntityManager();
		TypedQuery<Venda> q=em.createQuery("FROM Venda",Venda.class);
		List<Venda> vs=q.getResultList();
		DBUtil.closeEntityManager(em);
		return vs;
	}
	public static void deletarVenda(Venda v) {
		EntityManager em = DBUtil.getEntityManager();
		em.getTransaction().begin();
		em.remove(v);
		em.getTransaction().commit();
		DBUtil.closeEntityManager(em);
	}
}
