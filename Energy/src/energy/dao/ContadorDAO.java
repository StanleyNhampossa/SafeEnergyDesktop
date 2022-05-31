package energy.dao;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import energy.model.Cliente;
import energy.model.Contador;

public class ContadorDAO {

    public void cadastrarContador(Contador contador) throws ExceptionDAO{

        String sql = "insert into contador (numeroDeContador, codigoDoCliente, casa, provincia, cidade, bairro)" +
                " value (?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = null;

        Connection conexao = null;

        try{
            conexao = new ConnectionLocal().getConnection();

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
            }finally {
                try {
                    if(conexao != null)
                        conexao.close();
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

    public ArrayList<Contador> listarTodosContadores() throws ExceptionDAO{

        //String querySQL = "select * from contador";
        String querySQL = "select * from contador join cliente c on c.codigoDoCliente = contador.codigoDoCliente";

        Connection conexao = null;
        PreparedStatement preparedStatement = null;

        ArrayList<Contador> contadores = null;

        try {
            conexao = new ConnectionLocal().getConnection();
            preparedStatement = conexao.prepareStatement(querySQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet != null) {
                contadores = new ArrayList<>();
                while (resultSet.next()) {
                    Contador contador = new Contador();
                    Cliente cliente = new Cliente();
                    contador.setNumeroDeContador(resultSet.getInt(1));
                    contador.setCasa(resultSet.getString(3));
                    contador.setProvincia(resultSet.getString(4));
                    contador.setCidade(resultSet.getString(5));
                    contador.setBairro(resultSet.getString(6));

                    cliente.setCodigoDeCliente(resultSet.getInt(7));
                    cliente.setNome(resultSet.getString(8));
                    cliente.setApelido(resultSet.getString(9));
                    cliente.setDataDeNascimento(resultSet.getDate(10));
                    cliente.setEstadoCivil(resultSet.getString(11));
                    cliente.setProfissao(resultSet.getString(12));
                    cliente.setMorada(resultSet.getString(13));
                    cliente.setEmail(resultSet.getString(14));
                    cliente.setNumeroDeBI(resultSet.getString(15));
                    cliente.setContacto(resultSet.getInt(16));
                    cliente.setContactoAlternativo(resultSet.getInt(17));
                    cliente.setNuit(resultSet.getInt(18));
                    cliente.setGenero(resultSet.getString(19));
                    contador.setProprietario(cliente);

                    contadores.add(contador);
                }
            }
        }catch (SQLException e){
            throw new ExceptionDAO("Erro ao listar contador " + e);
        }finally {
            try {
                if(conexao != null)
                    conexao.close();
            }catch (SQLException e){
                throw new ExceptionDAO("Erro ao fechar conexão " + e);
            }

            try {
                if(preparedStatement != null)
                    preparedStatement.close();
            }catch (SQLException e){
                throw new ExceptionDAO("Erro ao fechar o statement");
            }finally {
                try {
                    if(conexao != null)
                        conexao.close();
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

        return contadores;
    }

    public ArrayList<Contador> listarContadoresPorProprietario(String nome){
        String querySQL = "select from contador where proprietario is like " ;

        ArrayList<Contador> contadores = null;

        return contadores;
    }

    public void editarContador(Contador contador)throws ExceptionDAO{
        String querySQL = "update contador set casa = ?, provincia = ?, cidade = ?, bairro = ? where numeroDeContador = ?";

        Connection conexao = null;
        PreparedStatement preparedStatement = null;

        try {
            conexao = new ConnectionLocal().getConnection();
            preparedStatement = conexao.prepareStatement(querySQL);

            preparedStatement.setString(1, contador.getCasa());
            preparedStatement.setString(2, contador.getProvincia());
            preparedStatement.setString(3, contador.getCidade());
            preparedStatement.setString(4, contador.getBairro());
            preparedStatement.setInt(5, contador.getNumeroDeContador());


            preparedStatement.execute();

        }catch (SQLException e){
            throw new ExceptionDAO("Erro ao listar contador por id " + e);
        }finally {
            try {
                if(conexao != null)
                    conexao.close();
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
                if(conexao != null)
                    conexao.close();
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

    public Contador listarPorID(int id) throws ExceptionDAO{
        Contador contador = null;

        Connection conexao = null;
        PreparedStatement preparedStatement = null;
        String querySQL = "select * from contador join cliente c on c.codigoDoCliente = contador.codigoDoCliente where numeroDeContador = ?";
        try{
            conexao = new ConnectionLocal().getConnection();
            preparedStatement = conexao.prepareStatement(querySQL);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                contador = new Contador();
                Cliente cliente = new Cliente();
                contador.setNumeroDeContador(resultSet.getInt(1));
                contador.setCasa(resultSet.getString(3));
                contador.setProvincia(resultSet.getString(4));
                contador.setCidade(resultSet.getString(5));
                contador.setBairro(resultSet.getString(6));

                cliente.setCodigoDeCliente(resultSet.getInt(7));
                cliente.setNome(resultSet.getString(8));
                cliente.setApelido(resultSet.getString(9));
                cliente.setDataDeNascimento(resultSet.getDate(10));
                cliente.setEstadoCivil(resultSet.getString(11));
                cliente.setProfissao(resultSet.getString(12));
                cliente.setMorada(resultSet.getString(13));
                cliente.setEmail(resultSet.getString(14));
                cliente.setNumeroDeBI(resultSet.getString(15));
                cliente.setContacto(resultSet.getInt(16));
                cliente.setContactoAlternativo(resultSet.getInt(17));
                cliente.setNuit(resultSet.getInt(18));
                cliente.setGenero(resultSet.getString(19));
                contador.setProprietario(cliente);
            }
        }catch (SQLException e){
            throw new ExceptionDAO("Erro ao listar contador por id " + e);
        }finally {
            try {
                if(conexao != null)
                    conexao.close();
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
        return contador;
    }


}


