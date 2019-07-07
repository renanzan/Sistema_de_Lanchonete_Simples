package database.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.Database;
import database.models.Produto;

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
	
	public static ArrayList<Produto> getAll() {
		ArrayList<Produto> produtos = new ArrayList<>();
		final String sqlScript =
				"SELECT * "
				+ "FROM " + TABLE_NAME;
		
		ResultSet rs = Database.DBExecuteQuery(sqlScript);
		
		try {
			while(rs.next())
				produtos.add(new Produto(
						rs.getInt(Column.cod_produto.toString()),
						rs.getString(Column.nome.toString()),
						rs.getDouble(Column.preco.toString()),
						Produto.toTipoProduto(rs.getString(Column.tipo.toString())),
						rs.getString(Column.descricao.toString()),
						rs.getInt(Column.qtd.toString())));
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return produtos;
	}

}
