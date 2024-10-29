package resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
    //resorces conexao com o banco dedados;
    //conexao com o banco de dados mysql
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/anime_store";
        String user = "root";
        String password = "123456";
        return DriverManager.getConnection(url, user, password);
    }
}
