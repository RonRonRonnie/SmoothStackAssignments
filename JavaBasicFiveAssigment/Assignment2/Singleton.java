package JavaBasicFiveAssigment.Assignment2;

import JavaBasicFourAssignment.Singleton;

import java.math.BigDecimal;
import java.sql.*;


class SampleSingleton {

    private static Connection con = null;


    static {

        String url = "jdbc:mysql:// localhost:3306/org";
        String user = "root";
        String pass = "root";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection()
    {
        return con;
    }

    private volatile static SampleSingleton instance = null;

    public static SampleSingleton getInstance() {
        if (instance==null){
            synchronized (Singleton.class){
                if(instance==null){
                    instance = new SampleSingleton();
                }
            }

        }
        return instance;
    }

}