package connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 
 * Respons?vel por fazer a conex?o com o banco de dados
 * Conex?o Postgrsql para o banco java-estudo
 * @author Jorge Anderson
 *
 */

public class SingleConnection {
	
	
	private static String url = "jdbc:postgresql://localhost:5432/java-estudo?autoReconnect=true";
	private static String password = "admin";
	private static String user = "postgres";
	private static Connection connection = null;
	
	
	static {//
		conectar();
	}
	
	public SingleConnection() {
		conectar();
	}
	
	private static void conectar() {
		
		try {
			
			if (connection == null) {
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(url, user, password);
				connection.setAutoCommit(false);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao conectar com banco de dados.");
		}
		
	}

	/**
	 * Retoirna a conex?o do banco de dados
	 * 
	 * @author Jorge Anderson
	 */
	public static Connection getConnection() {
		return connection;
	}
	
	

}
