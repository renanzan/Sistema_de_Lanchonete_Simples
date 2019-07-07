package database.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import database.Database;
import database.models.Produto;

public class ItensDoPedidoDAO {

	public enum Column {
		id_item_pedido,
		num_pedido,
		cod_produto
	}
	
	public static final String TABLE_NAME = "itens_de_pedido";
	public static final Column COLUMN_PRIMARY_KEY = Column.id_item_pedido;
	
	public static HashMap<Produto, Integer> getProdutos(String numPedido) {
		HashMap<Produto, Integer> produtos = new HashMap<>();
		final String sqlScript =
				"SELECT * "
				+ "FROM `" + TABLE_NAME + "` "
				+ "WHERE " + Column.num_pedido + "='" + numPedido + "'";
		
		ResultSet rs = Database.DBExecuteQuery(sqlScript);
		
		try {
			while(rs.next()) {
				Produto produto = getProduto(rs.getInt(ProdutoDAO.Column.cod_produto.toString()));
				
				if(produtos.containsKey(produto))
					produtos.put(produto, produtos.get(produto)+1);
				else
					produtos.put(produto, 1);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return produtos;
	}
	
	private static Produto getProduto(int cod_produto) {
		Produto produto = null;
		final String sqlScript =
				"SELECT * "
				+ "FROM `" + ProdutoDAO.TABLE_NAME + "` "
				+ "WHERE " + ProdutoDAO.Column.cod_produto + "='" + cod_produto + "'";
		
		ResultSet rs = Database.DBExecuteQuery(sqlScript);
		
		try {
			while(rs.next())
				produto = new Produto(
						rs.getInt(ProdutoDAO.Column.cod_produto.toString()),
						rs.getString(ProdutoDAO.Column.nome.toString()),
						rs.getDouble(ProdutoDAO.Column.preco.toString()),
						Produto.toTipoProduto(rs.getString(ProdutoDAO.Column.tipo.toString())),
						rs.getString(ProdutoDAO.Column.descricao.toString()),
						rs.getInt(ProdutoDAO.Column.qtd.toString()));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return produto;
	}
	
}
