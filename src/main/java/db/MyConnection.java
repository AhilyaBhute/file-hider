package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
    public static Connection connection = null;
    public static Connection getConnection(){
        try {
            // load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/file_hider?useSSL=false";
            String user = "root";
            String password = "mysql@ssds";
            connection = DriverManager.getConnection(url,user,password);
//            System.out.println("Connection is successful!!");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }
    public static void closeConnection(){
        if(connection != null){
            try {
                connection.close();
//                System.out.println("Connection is closed!!");
            }catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }

}
