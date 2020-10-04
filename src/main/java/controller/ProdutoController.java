package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Produto;
import model.Usuario;
import util.DBUtil;

public class ProdutoController {

	public static void InserirProduto(Produto p) {
		p.setId(null);
		EntityManager em = DBUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		DBUtil.closeEntityManager(em);
	}
	public static List<Produto> getProdutoList(){
		EntityManager em=DBUtil.getEntityManager();
		TypedQuery<Produto> q=em.createQuery("FROM Produto",Produto.class);
		List<Produto> ps=q.getResultList();
		DBUtil.closeEntityManager(em);
		return ps;
	}
	public static void atualizarProduto(Produto p) {
		EntityManager em=DBUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		DBUtil.closeEntityManager(em);
	}
}
