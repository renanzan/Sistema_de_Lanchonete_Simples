package database.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.Database;
import database.models.Pedido;

public abstract class CaixaDAO extends UsuarioDAO {
	
	public ArrayList<Pedido> getPedidos() {
		ArrayList<Pedido> pedidos = new ArrayList<>();
		final String sqlScript =
				"SELECT * "
				+ "FROM `" + PedidoDAO.TABLE_NAME + "`";
		
		ResultSet rs = Database.DBExecuteQuery(sqlScript);
		
		try {
			while(rs.next())
				pedidos.add(new Pedido(
						rs.getInt(PedidoDAO.Column.num_pedido.toString()),
						Pedido.toStatus(rs.getString(PedidoDAO.Column.status_pedido.toString())),
						rs.getTimestamp(PedidoDAO.Column.data_hora.toString())
				));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return pedidos;
	}
	
}
