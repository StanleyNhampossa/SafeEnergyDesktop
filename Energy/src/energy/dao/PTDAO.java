package energy.dao;

import energy.model.PT;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PTDAO {

    public void cadastrarPT(PT pt) throws ExceptionDAO{

        String querySQL = "insert into pt (numeroDoPT, provincia, cidade, bairro) value (?, ?, ?, ?)";

        Connection conexao = null;
        PreparedStatement preparedStatement = null;

        try {
            conexao = new ConnectionMVC().getConnection();
            preparedStatement = conexao.prepareStatement(querySQL);

            preparedStatement.setInt(1, pt.getNumeroDePT());
            preparedStatement.setString(2, pt.getProvincia());
            preparedStatement.setString(3, pt.getCidade());
            preparedStatement.setString(4, pt.getBairro());
            preparedStatement.execute();

        }catch (SQLException e){
            throw new ExceptionDAO("Erro ao cadastrar PT " + e);
        }finally{
            try{
                if(conexao != null)
                    conexao.close();
            }catch (SQLException e){
                throw new ExceptionDAO("Erro ao fechar conexão " + e);
            }
            try {
                if(preparedStatement != null)
                    preparedStatement.close();
            }catch (SQLException e){
                throw new ExceptionDAO("Erro ao fechar statement " + e);
            }
        }

    }

}
