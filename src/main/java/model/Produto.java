package model;

import javax.persistence.*;

@Entity
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable=false)
	private String Descricao;
	@Column(nullable=false)
	private String nomeProduto;
	@Column(nullable=false)
	private String tipo;
	@Column(nullable=false)
	private Double preco;	
	@Column(nullable=false)
	private Integer qtEmEstoque;
	public Integer getId() {
	
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return Descricao;
	}
	public void setDescricao(String descricao) {
		Descricao = descricao;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public Integer getQtEmEstoque() {
		return qtEmEstoque;
	}
	public void setQtEmEstoque(Integer qtEmEstoque) {
		this.qtEmEstoque = qtEmEstoque;
	}
	@Override
	public String toString() {
		return getNomeProduto();
	}


}
