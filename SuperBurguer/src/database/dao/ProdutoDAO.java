package database.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.Database;
import database.models.Produto;
import database.util.ByteArray;

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
	
	public static ArrayList<Produto> getAll(String filter) {
		ArrayList<Produto> produtos = new ArrayList<>();
		final String sqlScript =
				"SELECT * "
				+ "FROM " + TABLE_NAME + " "
				+ "WHERE "
				+ Column.cod_produto.toString() + "='" + filter + "' OR "
				+ Column.nome.toString() + " LIKE '%" + filter + "%'";
		
		ResultSet rs = Database.DBExecuteQuery(sqlScript);
		
		try {
			while(rs.next())
				produtos.add(newInstance(rs));
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return produtos;
	}
	
	public static ArrayList<Produto> getAll() {
		ArrayList<Produto> produtos = new ArrayList<>();
		final String sqlScript =
				"SELECT * "
				+ "FROM " + TABLE_NAME;
		
		ResultSet rs = Database.DBExecuteQuery(sqlScript);
		
		try {
			while(rs.next()) {
				produtos.add(newInstance(rs));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return produtos;
	}

	public static void remove(int cod_produto) {
		final String sqlScript =
				"DELETE FROM " + ProdutoDAO.TABLE_NAME + " "
				+ "WHERE " + ProdutoDAO.Column.cod_produto + "=" + cod_produto;
		
		Database.DBUpdate(sqlScript);
	}

	public static void insert(Produto produto) {
		String sqlScript =
				"INSERT INTO " + TABLE_NAME + " "
				+ "VALUE (null, '"
				+ produto.getNome() + "', '"
				+ produto.getDescricao() + "', '"
				+ produto.getTipo().toString() + "', '"
				+ produto.getPreco() + "', ?)";
		
		try {
			PreparedStatement prpStmt = Database.getSingletonConnection().prepareStatement(sqlScript);
			
			if(produto.getImage()!=null)
				prpStmt.setBytes(1, produto.getImage());
			else
				prpStmt.setNull(1, java.sql.Types.BLOB);
			
			Database.DBUpdate(prpStmt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Produto newInstance(ResultSet rs) {
		try {
			return new Produto(
					rs.getInt(ProdutoDAO.Column.cod_produto.toString()),
					rs.getString(ProdutoDAO.Column.nome.toString()),
					rs.getDouble(ProdutoDAO.Column.preco.toString()),
					Produto.toTipoProduto(rs.getString(ProdutoDAO.Column.tipo.toString())),
					rs.getString(ProdutoDAO.Column.descricao.toString()),
					ByteArray.parseToByteArray(rs.getBlob(ProdutoDAO.Column.imagem.toString())));
		} catch (SQLException ex) {
			System.err.println("Não foi possível criar instância de Produto.");
			ex.printStackTrace();
		}
	
		return null;
	}

}
