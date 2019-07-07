package database.models;

public class Produto {
	
	public enum TipoProduto {
		LANCHE,
		BEBIDA,
		DOCE
	}
	
	private int cod_produto;
	private String nome;
	private double preco;
	private TipoProduto tipo;
	private String descricao;
	private byte[] image;
	
	public Produto(int cod_produto, String nome, double preco, TipoProduto tipo, String descricao, int qtd) {
		this.cod_produto = cod_produto;
		this.nome = nome;
		this.preco = preco;
		this.tipo = tipo;
		this.descricao = descricao;
		
		// PEGAR A IMAGEM
		//this.image = image;
	}
	
	public static TipoProduto toTipoProduto(String tripoProduto) {
		return TipoProduto.valueOf(tripoProduto.toUpperCase());
	}

	public int getCod_produto() {
		return cod_produto;
	}
	
	public String getNome() {
		return nome;
	}
	
	public double getPreco() {
		return preco;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	

}