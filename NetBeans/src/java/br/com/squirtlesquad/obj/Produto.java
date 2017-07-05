package br.com.squirtlesquad.obj;

import java.util.Date;

public class Produto {
	private int id;
	private String nome;
	private String descricao;
	private int quantidade;
	private String unidadeMedida;
	private Date dataValidade;
	private int promocao;
	private double porcentagemPromocao;
	private int quantidadeMinDesconto;
	private String caminhoImagem;
	private double valorUnidade;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public String getUnidadeMedida() {
		return unidadeMedida;
	}
	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}
	public Date getDataValidade() {
		return dataValidade;
	}
	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}
	public int getPromocao() {
		return promocao;
	}
	public void setPromocao(int promocao) {
		this.promocao = promocao;
	}
	public double getPorcentagemPromocao() {
		return porcentagemPromocao;
	}
	public void setPorcentagemPromocao(double porcentagemPromocao) {
		this.porcentagemPromocao = porcentagemPromocao;
	}
	public int getQuantidadeMinDesconto() {
		return quantidadeMinDesconto;
	}
	public void setQuantidadeMinDesconto(int quantidadeMinDesconto) {
		this.quantidadeMinDesconto = quantidadeMinDesconto;
	}
	public String getCaminhoImagem() {
		return caminhoImagem;
	}
	public void setCaminhoImagem(String caminhoImagem) {
		this.caminhoImagem = caminhoImagem;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getValorUnidade() {
		return valorUnidade;
	}
	public void setValorUnidade(double valorUnidade) {
		this.valorUnidade = valorUnidade;
	}
	
	
	
	
	
}
