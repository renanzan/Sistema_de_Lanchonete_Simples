package database.dao;

public class ProdutoDAO {
	
	public enum Column {
		cod_produto,
		nome,
		preco,
		tipo,
		descricao,
		qtd,
		imagem
	}
	
	public static final String TABLE_NAME = "produtos";
	public static final Column COLUMN_PRIMARY_KEY = Column.cod_produto;

}
