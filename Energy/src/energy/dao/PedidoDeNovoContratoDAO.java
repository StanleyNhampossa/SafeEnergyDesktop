package energy.dao;

import energy.model.PedidoDeNovosContratos;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;

public class PedidoDeNovoContratoDAO {

    public ArrayList<PedidoDeNovosContratos> listarTodosPedidos() throws ExceptionDAO{
        String querySQL = "select * from pedidoDeNovosContratos";
        ArrayList<PedidoDeNovosContratos> pedidoDeNovosContratos = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = new ConnectionRemota().getConnection();
            preparedStatement = connection.prepareStatement(querySQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet != null){
                pedidoDeNovosContratos = new ArrayList<>();
                while (resultSet.next()){
                    PedidoDeNovosContratos pedidoDeNovosContrato = new PedidoDeNovosContratos();
                    pedidoDeNovosContrato.setId(resultSet.getInt(1));
                    pedidoDeNovosContrato.setNomeDoCliente(resultSet.getString(2));
                    pedidoDeNovosContrato.setDataDeNascimento(resultSet.getDate(3));
                    pedidoDeNovosContrato.setDistrito(resultSet.getString(4));
                    pedidoDeNovosContrato.setContacto(resultSet.getInt(5));
                    pedidoDeNovosContrato.setEmail(resultSet.getString(6));
                    pedidoDeNovosContrato.setLocalizacaoDaCasa(resultSet.getString(7));
                    pedidoDeNovosContrato.setNumeroDaCasa(resultSet.getString(8));
                    pedidoDeNovosContrato.setDataDaIda(resultSet.getDate(9));
                    pedidoDeNovosContrato.setRespondido(resultSet.getBoolean(10));
                    pedidoDeNovosContratos.add(pedidoDeNovosContrato);

                }

            }
        }catch (SQLException e){
            throw new ExceptionDAO("Erro ao listar pedidos de novos contratos " + e);
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


        return pedidoDeNovosContratos;
    }

    public ArrayList<PedidoDeNovosContratos> listarPedidosRespondidos() throws ExceptionDAO{
        String querySQL = "select * from pedidoDeNovosContratos where respondido = 1";
        ArrayList<PedidoDeNovosContratos> pedidoDeNovosContratos = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = new ConnectionRemota().getConnection();
            preparedStatement = connection.prepareStatement(querySQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet != null){
                pedidoDeNovosContratos = new ArrayList<>();
                while (resultSet.next()){
                    PedidoDeNovosContratos pedidoDeNovosContrato = new PedidoDeNovosContratos();
                    pedidoDeNovosContrato.setId(resultSet.getInt(1));
                    pedidoDeNovosContrato.setNomeDoCliente(resultSet.getString(2));
                    pedidoDeNovosContrato.setDistrito(resultSet.getString(3));
                    pedidoDeNovosContrato.setContacto(resultSet.getInt(4));
                    pedidoDeNovosContrato.setEmail(resultSet.getString(5));
                    pedidoDeNovosContrato.setLocalizacaoDaCasa(resultSet.getString(6));
                    pedidoDeNovosContrato.setNumeroDaCasa(resultSet.getString(7));
                    pedidoDeNovosContrato.setDataDaIda(resultSet.getDate(8));
                    pedidoDeNovosContrato.setRespondido(resultSet.getBoolean(9));
                    pedidoDeNovosContratos.add(pedidoDeNovosContrato);

                }

            }
        }catch (SQLException e){
            throw new ExceptionDAO("Erro ao listar pedidos de novos contratos " + e);
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


        return pedidoDeNovosContratos;
    }

    public PedidoDeNovosContratos listarPedidoDeNovoCOntrato(int id)throws ExceptionDAO{
        PedidoDeNovosContratos pedidoDeNovosContratos = null;

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String querySQL = "select * from pedidoDeNovosContratos where id = ?";

        try{
            connection = new ConnectionRemota().getConnection();
            preparedStatement = connection.prepareStatement(querySQL);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                pedidoDeNovosContratos = new PedidoDeNovosContratos();
                pedidoDeNovosContratos.setId(resultSet.getInt(1));
                pedidoDeNovosContratos.setNomeDoCliente(resultSet.getString(2));
                pedidoDeNovosContratos.setDataDeNascimento(resultSet.getDate(3));
                pedidoDeNovosContratos.setDistrito(resultSet.getString(4));
                pedidoDeNovosContratos.setContacto(resultSet.getInt(5));
                pedidoDeNovosContratos.setEmail(resultSet.getString(6));
                pedidoDeNovosContratos.setLocalizacaoDaCasa(resultSet.getString(7));
                pedidoDeNovosContratos.setNumeroDaCasa(resultSet.getString(8));
                pedidoDeNovosContratos.setDataDaIda(resultSet.getDate(9));
                pedidoDeNovosContratos.setRespondido(resultSet.getBoolean(10));
            }

        }catch (SQLException e){
            throw new ExceptionDAO("Erro ao listar Pedido de Novo Contrato");
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

        return pedidoDeNovosContratos;
    }
    public ArrayList<PedidoDeNovosContratos> listarPedidosNaoRespondidos() throws ExceptionDAO{
        String querySQL = "select * from pedidoDeNovosContratos where respondido = 0";
        ArrayList<PedidoDeNovosContratos> pedidoDeNovosContratos = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = new ConnectionRemota().getConnection();
            preparedStatement = connection.prepareStatement(querySQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet != null){
                pedidoDeNovosContratos = new ArrayList<>();
                while (resultSet.next()){
                    PedidoDeNovosContratos pedidoDeNovosContrato = new PedidoDeNovosContratos();
                    pedidoDeNovosContrato.setId(resultSet.getInt(1));
                    pedidoDeNovosContrato.setNomeDoCliente(resultSet.getString(2));
                    pedidoDeNovosContrato.setDistrito(resultSet.getString(3));
                    pedidoDeNovosContrato.setContacto(resultSet.getInt(4));
                    pedidoDeNovosContrato.setEmail(resultSet.getString(5));
                    pedidoDeNovosContrato.setLocalizacaoDaCasa(resultSet.getString(6));
                    pedidoDeNovosContrato.setNumeroDaCasa(resultSet.getString(7));
                    pedidoDeNovosContrato.setDataDaIda(resultSet.getDate(8));
                    pedidoDeNovosContrato.setRespondido(resultSet.getBoolean(9));
                    pedidoDeNovosContratos.add(pedidoDeNovosContrato);

                }

            }
        }catch (SQLException e){
            throw new ExceptionDAO("Erro ao listar pedidos de novos contratos " + e);
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

        return pedidoDeNovosContratos;
    }

    public void respondendoPedidosDeNovosContratos(PedidoDeNovosContratos pedidoDeNovosContratos)throws ExceptionDAO{
        String querySQL = "update pedidoDeNovosContratos set dataDeIda = ?, respondido = 1 where id = ?";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{
            connection = new ConnectionRemota().getConnection();
            preparedStatement = connection.prepareStatement(querySQL);

            preparedStatement.setDate(1, new Date(pedidoDeNovosContratos.getDataDaIda().getTime()));
            preparedStatement.setInt(2, pedidoDeNovosContratos.getId());

            preparedStatement.execute();
        }catch (SQLException e){
            throw new ExceptionDAO("Erro ao responder pedido de novo contrato " + e);
        }finally {
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
            }
        }

    }

}
