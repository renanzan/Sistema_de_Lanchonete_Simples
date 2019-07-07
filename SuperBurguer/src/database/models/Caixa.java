package database.models;

import database.dao.CaixaDAO;

public class Caixa extends CaixaDAO {
	
	private String nome;
	private String sobrenome;
	private String username;
	private String senha;
	
	public Caixa(String nome, String sobrenome, String username, String senha) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.username = username;
		this.senha = senha;
	}

	private boolean autenticar() {
		final String sqlScript = "SELECT ";
		return true;
	}
	
	public String getNome() {
		return nome + " " + sobrenome;
	}
	
}
