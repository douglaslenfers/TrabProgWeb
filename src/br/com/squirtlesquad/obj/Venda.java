package br.com.squirtlesquad.obj;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Venda {
	private List<Produto> produto = new ArrayList();
	private Pessoa pessoa;
	private int idVenda;
	private Date dataVenda;
	
	
	public void addProduto(Produto p){
		produto.add(p);
	}
	public List<Produto> getProduto() {
		return produto;
	}
	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public int getIdVenda() {
		return idVenda;
	}
	public void setIdVenda(int idVenda) {
		this.idVenda = idVenda;
	}
	public Date getDataVenda() {
		return dataVenda;
	}
	public void setDataVenda() {
		this.dataVenda = new Date(System.currentTimeMillis());
		
	}
	public void setDataVenda(Date data) {
		this.dataVenda = data;
		
	}
	
	
	
	

}
