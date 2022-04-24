package energy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import energy.model.Cliente;
import energy.model.Contador;

public class ContadorDAO {

    public void cadastrarContador(Contador contador) throws ExceptionDAO{

        String sql = "insert into contador (numeroDeContador, codigoDoCliente, casa, provincia, cidade, bairro)" +
                " value (?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = null;

        Connection conexao = null;

        try{
            conexao = new ConnectionMVC().getConnection();

            preparedStatement = conexao.prepareStatement(sql);

            preparedStatement.setInt(1, contador.getNumeroDeContador());
            preparedStatement.setInt(2, contador.getProprietario().getCodigoDeCliente());
            preparedStatement.setString(3, contador.getCasa());
            preparedStatement.setString(4, contador.getProvincia());
            preparedStatement.setString(5, contador.getCidade());
            preparedStatement.setString(6, contador.getBairro());

            preparedStatement.execute();

        } catch (SQLException e){
            throw new ExceptionDAO("Erro ao cadastrar contador " + e);

        } finally {

            try {
                if(preparedStatement != null)
                    preparedStatement.close();

            }catch (SQLException e){
                throw new ExceptionDAO("Erro ao fechar o Statement " + e);
            }

            try {
                if(conexao != null)
                    conexao.close();

            }catch (SQLException e){
                throw new ExceptionDAO("Erro ao fechar conexão " + e);
            }

        }


    }



}


