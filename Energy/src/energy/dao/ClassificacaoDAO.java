package energy.dao;

import energy.model.Classificacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClassificacaoDAO {

    public ArrayList<Classificacao> listarTodasClassificacoes()throws ExceptionDAO{
        ArrayList<Classificacao> classificacoes = null;
        String querySQL ="select * from classificacao";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = new ConnectionRemota().getConnection();
            preparedStatement = connection.prepareStatement(querySQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet != null){
                classificacoes = new ArrayList<>();
                while (resultSet.next()){
                    Classificacao classificacao = new Classificacao();
                    classificacao.setId(resultSet.getInt(1));
                    classificacao.setNumeroDeEstrelas(resultSet.getDouble(2));
                    classificacao.setComentario(resultSet.getString(3));
                    classificacao.setNumeroDaEquipa(resultSet.getInt(4));
                    classificacao.setNomeDoCliente(resultSet.getString(5));
                    classificacoes.add(classificacao);
                }

            }

        }catch (SQLException e){
            throw new ExceptionDAO("Erro ao listar classificações " + e);
        }finally {
            try {
                if(connection != null)
                    connection.close();
            }catch (SQLException e){
                throw new ExceptionDAO("Erro ao fechar conexão");
            }

            try {
                if(preparedStatement != null)
                    preparedStatement.close();
            }catch (SQLException e){
                throw new ExceptionDAO("Erro ao fechar o statement " + e);
            }
        }

        return classificacoes;
    }

}
