package database.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	
	public static ArrayList<Pedido> get(Status Status) {
		ArrayList<Pedido> pedidos = new ArrayList<>();
		final String sqlScript =
				"SELECT * "
				+ "FROM " + PedidoDAO.TABLE_NAME + " "
				+ "WHERE " + Column.status_pedido + " = '" + Status.toString() + "'";
		
		ResultSet rs = Database.DBExecuteQuery(sqlScript);
		
		try {
			while(rs.next())
				if(toStatus(rs.getString(Column.status_pedido.toString())) == Status)
					pedidos.add(new Pedido(
							rs.getString(Column.num_pedido.toString()),
							toStatus(rs.getString(Column.status_pedido.toString())),
							rs.getTimestamp(Column.data_hora.toString())));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return pedidos;
	}
	
	public static void updateStatus(Pedido pedido) {
		final String sqlScript =
				"UPDATE " + PedidoDAO.TABLE_NAME + " "
				+ "SET " + Column.status_pedido.toString() + "='" + pedido.getStatus().toString() + "' "
				+ "WHERE " + Column.num_pedido.toString() + "='" + pedido.getNumPedido() + "'";
		
		Database.DBUpdate(sqlScript);
	}
	
	public static void insert(Pedido pedido) {
		final String sqlScript =
				"INSERT INTO " + PedidoDAO.TABLE_NAME + " "
				+ "VALUES ('" + pedido.getNumPedido() + "',	'" + Status.PENDENTE + "', NOW())";
		
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
