package energy.dao;

import energy.model.AreaDeServicoAoCliente;
import energy.model.Funcionario;

import java.sql.*;

public class FuncionarioDAO {

    public void cadastrarFuncionario(Funcionario funcionario) throws ExceptionDAO{
        String querySQL = "insert into funcionario (codigoDeASC, categoria, nome, apelido, " +
                "palavraPasse, " +
                "dataDeNascimento, estadoCivil, profissao, morada, email, " +
                "numeroDeBI, contacto, contactoAlternativo, nuit, genero) value (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = null;
        Connection conexao = null;

        try {
            conexao = new ConnectionMVC().getConnection();
            preparedStatement = conexao.prepareStatement(querySQL);

            preparedStatement.setInt(1, funcionario.getLocalDeTrabalho().getCodigoDeASC());
            preparedStatement.setString(2, funcionario.getCategoria());
            preparedStatement.setString(3, funcionario.getNome());
            preparedStatement.setString(4, funcionario.getApelido());
            preparedStatement.setString(5, funcionario.getPalavraPasse());
            preparedStatement.setDate(6, new Date(funcionario.getDataDeNascimento().getTime()));
            preparedStatement.setString(7, funcionario.getEstadoCivil());
            preparedStatement.setString(8, funcionario.getProfissao());
            preparedStatement.setString(9, funcionario.getMorada());
            preparedStatement.setString(10, funcionario.getEmail());
            preparedStatement.setString(11, funcionario.getNumeroDeBI());
            preparedStatement.setInt(12, funcionario.getContacto());
            preparedStatement.setInt(13, funcionario.getContactoAlternativo());
            preparedStatement.setInt(14, funcionario.getNuit());
            preparedStatement.setString(15, funcionario.getGenero());

            preparedStatement.execute();

        }catch (SQLException e){
            throw new ExceptionDAO("Erro ao cadastrar funcionário " + e);
        }finally {

            try {
                if(preparedStatement != null)
                    preparedStatement.close();
            }catch (SQLException e){
                throw new ExceptionDAO("Erro ao fechar statement " + e);
            }

            try {
                if(conexao != null)
                    conexao.close();
            }catch (SQLException e){
                throw new ExceptionDAO("Erro ao fechar conexão " + e);
            }

        }

    }

    public Funcionario encontrarFuncionarioPorEmail(String email) throws ExceptionDAO{

        String querySQL = "select * from funcionario where email = ?";

        Connection conexao = null;
        PreparedStatement preparedStatement = null;

        Funcionario funcionario = null;

        try {
            conexao = new ConnectionMVC().getConnection();
            preparedStatement = conexao.prepareStatement(querySQL);

            preparedStatement.setString(1, email);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                funcionario = new Funcionario();

                funcionario.setNumeroDeFuncionario(resultSet.getInt(1));
                //funcionario.setLocalDeTrabalho((AreaDeServicoAoCliente) resultSet.getObject(2));
                //funcionario.setEquipaDeTrabalho();
                funcionario.setCategoria(resultSet.getString(4));
                funcionario.setNome(resultSet.getString(5));
                funcionario.setApelido(resultSet.getString(6));
                funcionario.setPalavraPasse(resultSet.getString(7));
                funcionario.setDataDeNascimento(resultSet.getDate(8));
                funcionario.setEstadoCivil(resultSet.getString(9));
                funcionario.setProfissao(resultSet.getString(10));
                funcionario.setMorada(resultSet.getString(11));
                funcionario.setEmail(resultSet.getString(12));
                funcionario.setNumeroDeBI(resultSet.getString(13));
                funcionario.setContacto(resultSet.getInt(14));
                funcionario.setContactoAlternativo(resultSet.getInt(15));
                funcionario.setNuit(resultSet.getInt(16));
                funcionario.setGenero(resultSet.getString(17));

                /*
                numeroDeFuncionario int auto_increment not null,
                codigoDeASC int,
                numeroDaEquipa int,

                 */


            }


        }catch (SQLException e){
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

        return funcionario;
    }

    public void alterarFuncionario(Funcionario funcionario) throws ExceptionDAO{

        String querySQL = "update funcionario set codigoDeASC = ?, categoria = ?, nome = ?, apelido = ?, dataDeNascimento = ?, " +
                "estadoCivil = ?, profissao = ?, morada = ?, email = ?, numeroDeBI = ?, contacto = ?, contactoAlternativo = ?, nuit = ?, genero = ? where NumeroDeFuncionario = ?";

        PreparedStatement preparedStatement = null;
        Connection conexao = null;

        try {
            conexao = new ConnectionMVC().getConnection();
            preparedStatement = conexao.prepareStatement(querySQL);

            preparedStatement.setInt(1, funcionario.getLocalDeTrabalho().getCodigoDeASC());
            preparedStatement.setString(2, funcionario.getCategoria());
            preparedStatement.setString(3, funcionario.getNome());
            preparedStatement.setString(4, funcionario.getApelido());
            preparedStatement.setDate(5, new Date(funcionario.getDataDeNascimento().getTime()));
            preparedStatement.setString(6, funcionario.getEstadoCivil());
            preparedStatement.setString(7, funcionario.getProfissao());
            preparedStatement.setString(8, funcionario.getMorada());
            preparedStatement.setString(9, funcionario.getEmail());
            preparedStatement.setString(10, funcionario.getNumeroDeBI());
            preparedStatement.setInt(11, funcionario.getContacto());
            preparedStatement.setInt(12, funcionario.getContactoAlternativo());
            preparedStatement.setInt(13, funcionario.getNuit());
            preparedStatement.setString(14, funcionario.getGenero());
            preparedStatement.setInt(15, funcionario.getNumeroDeFuncionario());

            preparedStatement.execute();

        }catch (SQLException e){
            throw new ExceptionDAO("Erro ao alterar funcionário " + e);
        }finally {

            try {
                if(preparedStatement != null)
                    preparedStatement.close();
            }catch (SQLException e){
                throw new ExceptionDAO("Erro ao fechar statement " + e);
            }

            try {
                if(conexao != null)
                    conexao.close();
            }catch (SQLException e){
                throw new ExceptionDAO("Erro ao fechar conexão " + e);
            }

        }

    }

    public void alterarSenha(Funcionario funcionario, String palavraPasse) throws ExceptionDAO{

        String querySQL = "update funcionario set palavraPasse = ? where numeroDeFuncionario = ?";

        PreparedStatement preparedStatement = null;
        Connection conexao = null;

        try {
             conexao = new ConnectionMVC().getConnection();
             preparedStatement = conexao.prepareStatement(querySQL);

             preparedStatement.setString(1, palavraPasse);
             preparedStatement.setInt(2, funcionario.getNumeroDeFuncionario());
             preparedStatement.execute();

        }catch (SQLException e){
            throw new ExceptionDAO("Erro ao alterar funcionário " + e);
        }finally {

            try {
                if(preparedStatement != null)
                    preparedStatement.close();
            }catch (SQLException e){
                throw new ExceptionDAO("Erro ao fechar statement " + e);
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
