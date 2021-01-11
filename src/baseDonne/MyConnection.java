package baseDonne;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MyConnection {
    private Connection connection = null;
    public MyConnection(){};

    public  Connection getConnection() {
        return connection;
    }

    //créer une fonction de connexion à la base de données
    public  Connection connect() throws SQLException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/projet","hweber","2011");

        }catch (SQLException | ClassNotFoundException ex){
            System.out.println(ex.getMessage());
        }
        return connection;

    }








}
