package controller;

import java.util.List;

import javax.persistence.EntityManager;


import model.Tipo;
import model.Usuario;
import util.DBUtil;

public class TesteController {
	public static void main(String... args) {
	UsuarioController.getInstance().cadastraAdmin();
	System.out.println(UsuarioController.getInstance().logar("Admin", "admin"));
	System.out.println(UsuarioController.getInstance().getLoggedUser());
	Usuario u=new Usuario();
	u.setLogin("Jesus3");
	u.setSenha("123");
	u.setNome("123123 ajudajesus");
	u.setTipo(Tipo.VENDEDOR);
	UsuarioController.getInstance().cadastrarUsuario(u);
	List<Usuario> l=UsuarioController.getInstance().getUsuarioList();
	System.out.println(l);
	}
}
