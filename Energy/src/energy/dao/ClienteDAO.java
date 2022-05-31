package energy.dao;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;

import energy.model.Cliente;

public class ClienteDAO {

    public void cadastrarCliente(Cliente cliente) throws ExceptionDAO{

        String querySQL = "insert into cliente (nome, apelido, dataDeNascimento, estadoCivil, profissao, morada, email, numeroDeBI, contacto," +
                "contactoAlternativo, nuit, genero) value (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = null;

        Connection conexao = null;

        try {
            conexao = new ConnectionLocal().getConnection();
            preparedStatement = conexao.prepareStatement(querySQL);
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getApelido());
            preparedStatement.setDate(3, new Date(cliente.getDataDeNascimento().getTime()));
            preparedStatement.setString(4, cliente.getEstadoCivil());
            preparedStatement.setString(5, cliente.getProfissao());
            preparedStatement.setString(6, cliente.getMorada());
            preparedStatement.setString(7, cliente.getEmail());
            preparedStatement.setString(8, cliente.getNumeroDeBI());
            preparedStatement.setInt(9, cliente.getContacto());
            preparedStatement.setInt(10, cliente.getContactoAlternativo());
            preparedStatement.setInt(11, cliente.getNuit());
            preparedStatement.setString(12, cliente.getGenero());

            preparedStatement.execute();

        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao cadastrar cliente " + e);
        } finally {

            try {
                if(preparedStatement != null)
                    preparedStatement.close();
            }catch (SQLException e){
                throw new ExceptionDAO("Erro ao fechar o Statement" + e);
            }


            try {
                if(conexao != null)
                    conexao.close();

            }catch (SQLException e){
                throw new ExceptionDAO("Erro ao fechar conexão " + e);
            }


        }

    }


    public ArrayList<Cliente> listarTodosClientes() throws ExceptionDAO{

        String querySQL = "select * from cliente";

        Connection conexao = null;
        PreparedStatement preparedStatement = null;
        ArrayList<Cliente> clientes = null;

        try {
            conexao = new ConnectionLocal().getConnection();
            preparedStatement = conexao.prepareStatement(querySQL);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet != null){
                clientes = new ArrayList<>();

                while (resultSet.next()){
                    Cliente cliente = new Cliente();

                    cliente.setCodigoDeCliente(resultSet.getInt(1));
                    cliente.setNome(resultSet.getString(2));
                    cliente.setApelido(resultSet.getString(3));
                    cliente.setDataDeNascimento(resultSet.getDate(4));
                    cliente.setEstadoCivil(resultSet.getString(5));
                    cliente.setProfissao(resultSet.getString(6));
                    cliente.setMorada(resultSet.getString(7));
                    cliente.setEmail(resultSet.getString(8));
                    cliente.setNumeroDeBI(resultSet.getString(9));
                    cliente.setContacto(resultSet.getInt(10));
                    cliente.setContactoAlternativo(resultSet.getInt(11));
                    cliente.setNuit(resultSet.getInt(12));
                    cliente.setGenero(resultSet.getString(13));

                    clientes.add(cliente);
                }
            }

        }catch (SQLException e){
            throw new ExceptionDAO("Erro ao listar cliente " + e);
        } finally {

            try {
                if(preparedStatement != null)
                    preparedStatement.close();
            }catch (SQLException e){
                throw new ExceptionDAO("Erro ao fechar o Statement" + e);
            }


            try {
                if(conexao != null)
                    conexao.close();

            }catch (SQLException e){
                throw new ExceptionDAO("Erro ao fechar conexão " + e);
            }
        }

        return clientes;
    }


    public Cliente listarClientePorID(int id) throws ExceptionDAO{
        Cliente cliente = null;


        return cliente;
    }


    public ArrayList<Cliente> listarClientePorNome(String nome) throws ExceptionDAO{

        String sql = "select * from cliente where nome like '%" + nome + "%' order by nome";

        Connection conexao = null;
        PreparedStatement preparedStatement = null;

        ArrayList<Cliente> clientes = null;

        try {
            conexao = new ConnectionLocal().getConnection();
            preparedStatement = conexao.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet != null){
                clientes = new ArrayList<>();
                while (resultSet.next()){

                    Cliente cliente = new Cliente();
                    cliente.setCodigoDeCliente(resultSet.getInt(1));
                    cliente.setNome(resultSet.getString(2));
                    cliente.setApelido(resultSet.getString(3));
                    cliente.setDataDeNascimento(resultSet.getDate(4));
                    cliente.setEstadoCivil(resultSet.getString(5));
                    cliente.setProfissao(resultSet.getString(6));
                    cliente.setMorada(resultSet.getString(7));
                    cliente.setEmail(resultSet.getString(8));
                    cliente.setNumeroDeBI(resultSet.getString(9));
                    cliente.setContacto(resultSet.getInt(10));
                    cliente.setContactoAlternativo(resultSet.getInt(11));
                    cliente.setNuit(resultSet.getInt(12));
                    cliente.setGenero(resultSet.getString(13));

                    clientes.add(cliente);

                }
            }
        }catch (SQLException e){
            throw new ExceptionDAO("Erro ao consultar cliente " + e);
        }
        return clientes;
    }

    public Cliente encontrarClientePorEmail(String email) throws ExceptionDAO{


        String sql = "select * from cliente where email = ?";

        Connection conexao = null;
        PreparedStatement preparedStatement = null;

        Cliente cliente = null;

        try {
            conexao = new ConnectionLocal().getConnection();
            preparedStatement = conexao.prepareStatement(sql);

            preparedStatement.setString(1, email);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                cliente = new Cliente();

                cliente.setCodigoDeCliente(resultSet.getInt(1));
                cliente.setNome(resultSet.getString(2));
                cliente.setApelido(resultSet.getString(3));
                cliente.setDataDeNascimento(resultSet.getDate(4));
                cliente.setEstadoCivil(resultSet.getString(5));
                cliente.setProfissao(resultSet.getString(6));
                cliente.setMorada(resultSet.getString(7));
                cliente.setEmail(resultSet.getString(8));
                cliente.setNumeroDeBI(resultSet.getString(9));
                cliente.setContacto(resultSet.getInt(10));
                cliente.setContactoAlternativo(resultSet.getInt(11));
                cliente.setNuit(resultSet.getInt(12));
                cliente.setGenero(resultSet.getString(13));

            }


        }catch (SQLException e){
            throw new ExceptionDAO("Erro ao consultar cliente " + e);

        }finally {
            try {
                if(conexao != null)
                    conexao.close();

            }catch (SQLException e){
                throw new ExceptionDAO("Erro ao fechar a conexão " + e);
            }

            try {
                if(preparedStatement != null)
                    preparedStatement.close();

            }catch (SQLException e){
                throw new ExceptionDAO("Erro ao fechar o statement " + e);
            }
        }



        return cliente;

    }

    public Cliente encontrarClientePorID(int id) throws ExceptionDAO{
        Cliente cliente = null;
        Connection conexao = null;
        PreparedStatement preparedStatement = null;
        String querySQL = "select * from cliente where codigoDoCliente = ?";


        try {
            conexao = new ConnectionLocal().getConnection();
            preparedStatement = conexao.prepareStatement(querySQL);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                cliente = new Cliente();
                cliente.setCodigoDeCliente(resultSet.getInt(1));
                cliente.setNome(resultSet.getString(2));
                cliente.setApelido(resultSet.getString(3));
                cliente.setDataDeNascimento(resultSet.getDate(4));
                cliente.setEstadoCivil(resultSet.getString(5));
                cliente.setProfissao(resultSet.getString(6));
                cliente.setMorada(resultSet.getString(7));
                cliente.setEmail(resultSet.getString(8));
                cliente.setNumeroDeBI(resultSet.getString(9));
                cliente.setContacto(resultSet.getInt(10));
                cliente.setContactoAlternativo(resultSet.getInt(11));
                cliente.setNuit(resultSet.getInt(12));
                cliente.setGenero(resultSet.getString(13));

            }


        } catch (SQLException e){
        throw new ExceptionDAO("Erro ao consultar funcionário " + e);
    }finally {
        try {
            if(conexao != null)
                conexao.close();

        }catch (SQLException e){
            throw new ExceptionDAO("Erro ao fechar a conexão " + e);
        }

        try {
            if(preparedStatement != null)
                preparedStatement.close();

        }catch (SQLException e){
            throw new ExceptionDAO("Erro ao fechar o statement " + e);
        }
    }

        return cliente;

    }

    public void alterarCliente(Cliente cliente) throws ExceptionDAO{
        String querySQL = "Update cliente set nome = ?, apelido = ?, dataDeNascimento = ?, estadoCivil = ?, profissao = ?," +
                " morada = ?, email = ?, numeroDeBI = ?, contacto = ?, contactoAlternativo = ?, nuit = ?, genero = ? where codigoDoCliente = ?";

        PreparedStatement preparedStatement = null;
        Connection conexao = null;

        try{
            conexao = new ConnectionLocal().getConnection();
            preparedStatement = conexao.prepareStatement(querySQL);
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getApelido());
            preparedStatement.setDate(3, new Date(cliente.getDataDeNascimento().getTime()));
            preparedStatement.setString(4, cliente.getEstadoCivil());
            preparedStatement.setString(5, cliente.getProfissao());
            preparedStatement.setString(6, cliente.getMorada());
            preparedStatement.setString(7, cliente.getEmail());
            preparedStatement.setString(8, cliente.getNumeroDeBI());
            preparedStatement.setInt(9, cliente.getContacto());
            preparedStatement.setInt(10, cliente.getContactoAlternativo());
            preparedStatement.setInt(11, cliente.getNuit());
            preparedStatement.setString(12, cliente.getGenero());
            preparedStatement.setInt(13, cliente.getCodigoDeCliente());
            preparedStatement.execute();

        }catch (SQLException e){
            throw new ExceptionDAO("Erro ao alternar cliente " + e);

        }finally {
            try {
                if(conexao != null)
                    conexao.close();

            }catch (SQLException e){
                throw new ExceptionDAO("Erro ao fechar a conexão " + e);
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
