
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Joni
 */
public class DbConnection {
    static String bd = "********"; // BD Name
    static String login = "********"; // User
    static String password = "******"; // Pass
    static String url = "jdbc:mysql://localhost/" + bd;

    Connection conn = null;

    public DbConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(url, login, password);

            if (conn != null) {
                System.out.println("Conexión a la base de datos [" + conn + "]OK");
            }
        } catch (SQLException e) {
            System.out.println("Excepción a la conexión:" + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Excepcion driver: " + e.getMessage());
        }

    }

    // retornar la conexion
    public Connection getConnection() {
        return conn;
    }

    // quitar de memoria la conexión
    public void disconnect() {
        System.out.println("Base de datos cerrada: [" + conn + "] OK");
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }
}
