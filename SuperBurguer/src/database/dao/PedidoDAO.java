package database.dao;

import database.Database;
import database.models.Pedido;
import database.models.Produto;

public abstract class PedidoDAO extends Pedido {

	public enum Column {
		num_pedido,
		status_pedido,
		data_hora
	}
	
	public static final String TABLE_NAME = "pedidos";
	public static final Column COLUMN_PRIMARY_KEY = Column.num_pedido;
	
	public static void insert(Pedido pedido) {
		final String sqlScript =
				"INSERT INTO " + PedidoDAO.TABLE_NAME + " "
				+ "VALUES ('" + pedido.getNumPedido() + "',	'" + Pedido.Status.PENDENTE + "', NOW())";
		
		Database.DBUpdate(sqlScript);
		
		insertItensDoPedido(pedido);
	}

	private static void insertItensDoPedido(Pedido pedido) {
		String sqlScript =
				"INSERT INTO " + ItensDoPedidoDAO.TABLE_NAME + " "
				+ "VALUES ";
		
		for(Produto produto : pedido.getProdutos().keySet())
			for(int cont=0; cont < pedido.getProdutos().get(produto); cont++)
				sqlScript += "(NULL, '" + pedido.getNumPedido() + "', '" + produto.getCod_produto() + "'),";
		
		sqlScript = sqlScript.substring(0, sqlScript.length()-1);
		Database.DBUpdate(sqlScript);
	}
	
}
