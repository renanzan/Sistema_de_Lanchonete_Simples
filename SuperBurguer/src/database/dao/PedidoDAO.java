package database.dao;

import database.models.Pedido;

public abstract class PedidoDAO extends Pedido {

	public enum Column {
		num_pedido,
		status_pedido,
		data_hora
	}
	
	public static final String TABLE_NAME = "pedidos";
	public static final Column COLUMN_PRIMARY_KEY = Column.num_pedido;
	
}
