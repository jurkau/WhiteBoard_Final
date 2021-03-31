package baseDonne;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MyConnection {
    private static String serveur = "localhost";
    private static String baseName = "Projet";
    private static String user = "ablaye";
    private static String password = "passer";

    private static Connection connection;

    public static Connection getInstance() {
        if (connection == null) {
            String url = "jdbc:mysql://" + serveur + "/" + baseName;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(url, user, password );
            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
        }
        return connection;
    }
}