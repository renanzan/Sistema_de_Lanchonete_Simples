package database.models;

import java.awt.Image;
import java.util.ArrayList;

public class Produto {
	
	public enum TipoProduto {
		LANCHE,
		BEBIDA
	}
	
	private String codProduto;
	private String nome;
	private double preco;
	private TipoProduto tipo;
	private ArrayList<String> ingredientes;
	private byte[] image;
	
	public double getPreco() {
		return preco;
	}

}
