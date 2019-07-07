package database.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import database.Database;
import database.models.Caixa;
import database.models.Gerente;

public abstract class UsuarioDAO {
	
	public enum Column {
		p_nome,
		s_nome,
		username,
		senha,
		tipo_usuario
	}
	
	public enum Tipo {
		CAIXA,
		GERENTE
	}
	
	public static final String TABLE_NAME = "usuarios";
	public static final Column COLUMN_PRIMARY_KEY = Column.username;
	
	public static Caixa autenticar(String username, String password) {
		final String sqlScript =
				"SELECT * "
				+ "FROM `" + TABLE_NAME + "` "
				+ "WHERE " + Column.username + "='" + username + "' AND " + Column.senha + "='" + password + "'";
		
		ResultSet rs = Database.DBExecuteQuery(sqlScript);
		
		try {
			while(rs.next())
				if(toTipo(rs.getString(Column.tipo_usuario.toString())) == Tipo.CAIXA)
					return new Caixa(
							rs.getString(Column.p_nome.toString()),
							rs.getString(Column.s_nome.toString()),
							rs.getString(Column.username.toString()),
							rs.getString(Column.senha.toString())
							);
				else
					return new Gerente(
							rs.getString(Column.p_nome.toString()),
							rs.getString(Column.s_nome.toString()),
							rs.getString(Column.username.toString()),
							rs.getString(Column.senha.toString())
							);
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return null;
	}
	
	private static Tipo toTipo(String tipo) {
		return Tipo.valueOf(tipo.toUpperCase());
	}
	
	public static boolean isGerente(Caixa caixa) {
		if(caixa instanceof Gerente)
			return true;
		return false;
	}

}
