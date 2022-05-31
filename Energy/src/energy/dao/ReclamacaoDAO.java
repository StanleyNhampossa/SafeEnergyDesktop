package energy.dao;

import energy.model.Reclamacao;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;

public class ReclamacaoDAO {

    public ArrayList<Reclamacao> listarTodasReclamacoes()throws ExceptionDAO{

        String querySQL = "select * from reclamacao";
        ArrayList<Reclamacao> reclamacoes = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = new ConnectionRemota().getConnection();
            preparedStatement = connection.prepareStatement(querySQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet != null){
                reclamacoes = new ArrayList<>();
                while (resultSet.next()){
                    Reclamacao reclamacao = new Reclamacao();
                    reclamacao.setId(resultSet.getInt(1));
                    reclamacao.setNomeDoCliente(resultSet.getString(2));
                    reclamacao.setMensagem(resultSet.getString(3));
                    reclamacao.setAnonimo(resultSet.getBoolean(4));
                    reclamacao.setResposta(resultSet.getString(5));
                    reclamacao.setEmail(resultSet.getString(6));
//                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
//                    java.util.Date data = format.parse("30/05/2022");
//                    reclamacao.setDataDeEnvio(data);
                    reclamacao.setDataDeEnvio(resultSet.getDate(7));
                    reclamacao.setRespondido(resultSet.getBoolean(8));
                    reclamacoes.add(reclamacao);
                }
            }
        }catch (SQLException e){
            throw new ExceptionDAO("Erro ao listar reclamações " + e);
        } finally {
            try {
                if (connection != null)
                    connection.close();
            }catch (SQLException e){
                throw new ExceptionDAO("Erro ao fechar conexão " + e);
            }

            try {
                if(preparedStatement != null)
                    preparedStatement.close();
            }catch (SQLException e){
                throw new ExceptionDAO("Erro ao fechar o statement " + e);
            }finally {
                try {
                    if(connection != null)
                        connection.close();
                }catch (SQLException e){
                    throw new ExceptionDAO("Erro ao fechar conexão " + e);
                }
                try {
                    if(preparedStatement != null)
                        preparedStatement.close();
                }catch (SQLException e){
                    throw new ExceptionDAO("Erro ao fechar o statement " + e);
                }

            }
        }

        return reclamacoes;
    }

    public Reclamacao listarReclamacaoPorID(int id)throws ExceptionDAO{
        String querySQL = "select * from reclamacao where id = ?";
        Reclamacao reclamacao = null;

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = new ConnectionRemota().getConnection();
            preparedStatement = connection.prepareStatement(querySQL);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                reclamacao = new Reclamacao();
                reclamacao.setId(resultSet.getInt(1));
                reclamacao.setNomeDoCliente(resultSet.getString(2));
                reclamacao.setMensagem(resultSet.getString(3));
                reclamacao.setAnonimo(resultSet.getBoolean(4));
                reclamacao.setResposta(resultSet.getString(5));
                reclamacao.setEmail(resultSet.getString(6));
                reclamacao.setDataDeEnvio(resultSet.getDate(7));
//                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
//                java.util.Date data = format.parse("30/05/2022");
//                reclamacao.setDataDeEnvio(data);
                reclamacao.setRespondido(resultSet.getBoolean(8));

            }
        }catch (SQLException e){
            throw new ExceptionDAO("Erro ao listar reclamação " + e);
        } finally {
            try {
                if (connection != null)
                    connection.close();
            }catch (SQLException e){
                throw new ExceptionDAO("Erro ao fechar conexão " + e);
            }

            try {
                if(preparedStatement != null)
                    preparedStatement.close();
            }catch (SQLException e){
                throw new ExceptionDAO("Erro ao fechar o statement " + e);
            }finally {
                try {
                    if(connection != null)
                        connection.close();
                }catch (SQLException e){
                    throw new ExceptionDAO("Erro ao fechar conexão " + e);
                }
                try {
                    if(preparedStatement != null)
                        preparedStatement.close();
                }catch (SQLException e){
                    throw new ExceptionDAO("Erro ao fechar o statement " + e);
                }

            }
        }

        return reclamacao;
    }

    public ArrayList<Reclamacao> listarReclamacoesRespondidas()throws ExceptionDAO{
        String querySQL = "select * from reclamacao where respondido = 1";
        ArrayList<Reclamacao> reclamacoes = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = new ConnectionRemota().getConnection();
            preparedStatement = connection.prepareStatement(querySQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet != null){
                reclamacoes = new ArrayList<>();
                while (resultSet.next()){
                    Reclamacao reclamacao = new Reclamacao();
                    reclamacao.setId(resultSet.getInt(1));
                    reclamacao.setNomeDoCliente(resultSet.getString(2));
                    reclamacao.setAnonimo(resultSet.getBoolean(3));
                    reclamacao.setResposta(resultSet.getString(4));
                    reclamacao.setEmail(resultSet.getString(5));
                    reclamacao.setDataDeEnvio(resultSet.getDate(6));
//                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
//                    java.util.Date data = format.parse("30/05/2022");
//                    reclamacao.setDataDeEnvio(data);
                    reclamacao.setRespondido(resultSet.getBoolean(7));
                    reclamacoes.add(reclamacao);
                }

            }

        }catch (SQLException e){
            throw new ExceptionDAO("Erro ao listar reclamações " + e);
        } finally {
            try {
                if (connection != null)
                    connection.close();
            }catch (SQLException e){
                throw new ExceptionDAO("Erro ao fechar conexão " + e);
            }

            try {
                if(preparedStatement != null)
                    preparedStatement.close();
            }catch (SQLException e){
                throw new ExceptionDAO("Erro ao fechar o statement " + e);
            }finally {
                try {
                    if(connection != null)
                        connection.close();
                }catch (SQLException e){
                    throw new ExceptionDAO("Erro ao fechar conexão " + e);
                }
                try {
                    if(preparedStatement != null)
                        preparedStatement.close();
                }catch (SQLException e){
                    throw new ExceptionDAO("Erro ao fechar o statement " + e);
                }

            }
        }

        return reclamacoes;
    }

    public ArrayList<Reclamacao> listarReclamacoesNaoRespondidas()throws ExceptionDAO{
        String querySQL = "select * from reclamacao where respondido = 0";
        ArrayList<Reclamacao> reclamacoes = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = new ConnectionRemota().getConnection();
            preparedStatement = connection.prepareStatement(querySQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet != null){
                reclamacoes = new ArrayList<>();
                while (resultSet.next()){
                    Reclamacao reclamacao = new Reclamacao();
                    reclamacao.setId(resultSet.getInt(1));
                    reclamacao.setNomeDoCliente(resultSet.getString(2));
                    reclamacao.setAnonimo(resultSet.getBoolean(3));
                    reclamacao.setResposta(resultSet.getString(4));
                    reclamacao.setEmail(resultSet.getString(5));
                    reclamacao.setDataDeEnvio(resultSet.getDate(6));
//                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
//                    java.util.Date data = format.parse("30/05/2022");
//                    reclamacao.setDataDeEnvio(data);
                    reclamacao.setRespondido(resultSet.getBoolean(7));
                    reclamacoes.add(reclamacao);
                }

            }

        }catch (SQLException e){
            throw new ExceptionDAO("Erro ao listar reclamações");
        } finally {
            try {
                if (connection != null)
                    connection.close();
            }catch (SQLException e){
                throw new ExceptionDAO("Erro ao fechar conexão " + e);
            }

            try {
                if(preparedStatement != null)
                    preparedStatement.close();
            }catch (SQLException e){
                throw new ExceptionDAO("Erro ao fechar o statement " + e);
            }finally {
                try {
                    if(connection != null)
                        connection.close();
                }catch (SQLException e){
                    throw new ExceptionDAO("Erro ao fechar conexão " + e);
                }
                try {
                    if(preparedStatement != null)
                        preparedStatement.close();
                }catch (SQLException e){
                    throw new ExceptionDAO("Erro ao fechar o statement " + e);
                }

            }
        }

        return reclamacoes;
    }

    public void responderReclamacao(Reclamacao reclamacao)throws ExceptionDAO{
        String querySQL = "update reclamacao set nomeDoCliente = ?, mensagem = ?, anonimo = ?, resposta = ?," +
                "email = ?, dataDeEnvio = ?, respondido = ? where id = ?";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = new ConnectionRemota().getConnection();
            preparedStatement = connection.prepareStatement(querySQL);
            preparedStatement.setInt(8, reclamacao.getId());
            preparedStatement.setString(1, reclamacao.getNomeDoCliente());
            preparedStatement.setString(2, reclamacao.getMensagem());
            preparedStatement.setBoolean(3, reclamacao.isAnonimo());
            preparedStatement.setString(4, reclamacao.getResposta());
            preparedStatement.setString(5, reclamacao.getEmail());
            preparedStatement.setDate(6, new Date(reclamacao.getDataDeEnvio().getTime()));
            preparedStatement.setBoolean(7, reclamacao.isRespondido());
            preparedStatement.execute();
        }catch (SQLException e){
            throw new ExceptionDAO("Erro ao alterar resposta " + e);
        }finally {
            try {
                if(connection != null)
                    connection.close();
            }catch (SQLException e){
                throw new ExceptionDAO("Erro ao fechar conexão " + e);
            }
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
            }catch (SQLException e){
                throw new ExceptionDAO("Erro ao fechar statement " + e);
            }finally {
                try {
                    if(connection != null)
                        connection.close();
                }catch (SQLException e){
                    throw new ExceptionDAO("Erro ao fechar conexão " + e);
                }
                try {
                    if(preparedStatement != null)
                        preparedStatement.close();
                }catch (SQLException e){
                    throw new ExceptionDAO("Erro ao fechar o statement " + e);
                }

            }
        }

    }

}
