package database.models;

public class Gerente extends Caixa {
	
	public Gerente(String nome, String sobrenome, String username, String senha) {
		super(nome, sobrenome, username, senha);
	}

	public void AdicionarProduto(Produto produto) {
		// ...
	}
	
	public void AlterarProduto(Produto produto) {
		// ...
	}
	
	public void ExcluirProduto(String codProduto) {
		// ...
	}
	
	public void teste() {
		System.out.println("É GERENTE!");
	}
	
}
