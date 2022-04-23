package energy.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMVC {

    private static final String URL = "jdbc:mysql://localhost:3306/energy";
    private static final String USER = "root";
    private static final String SENHA = "";


    public Connection getConnection() {

        Connection conexao = null;


        try{

            //Método para poder carregar o driver do MySQL

            Class.forName("com.mysql.cj.jdbc.Driver");

        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }



            //Criar a conexão a partir do DriverManager
        try{

            conexao = DriverManager.getConnection(URL, USER, SENHA);

        }catch (SQLException e){
            e.printStackTrace();
        }

        return conexao;
    }

}
