package model;

import java.util.Date;

import javax.persistence.*;
@Entity
public class Venda {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@OneToOne
	private Usuario user;
	private Date dataVenda;
	@OneToOne
	private Produto vendido;
	private Integer qtVendido;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Usuario getUser() {
		return user;
	}
	public void setUser(Usuario user) {
		this.user = user;
	}
	public Integer getQtVendido() {
		return qtVendido;
	}
	public void setQtVendido(Integer qtVendido) {
		this.qtVendido = qtVendido;
	}
	public Produto getVendido() {
		return vendido;
	}
	public void setVendido(Produto vendido) {
		this.vendido = vendido;
	}
	public Date getDataVenda() {
		return dataVenda;
	}
	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}
}
