package energy.dao;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionRemota {

    private static final String URL = "jdbc:mysql://sql4.freesqldatabase.com:3306/sql4496101";
    private static final String USER = "sql4496101";
    private static final String SENHA = "SuPqQap3G7";


    public java.sql.Connection getConnection() {

        java.sql.Connection conexao = null;


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
