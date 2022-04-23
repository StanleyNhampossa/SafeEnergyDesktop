package energy.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import energy.model.Cliente;

public class ClienteDAO {

    public void cadastrarCliente(Cliente cliente) throws ExceptionDAO{

        String sql = "insert into cliente (nome, apelido, palavraPasse, dataDeNascimento, estadoCivil, profissao, morada, email, numeroDeBI, contacto," +
                "contactoAlternativo, nuit, genero) value (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = null;

        Connection conexao = null;

        try {
            conexao = new ConnectionMVC().getConnection();
            preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getApelido());
            preparedStatement.setString(3, cliente.getPalavraPasse());
            preparedStatement.setDate(4, new Date(cliente.getDataDeNascimento().getTime()));
            preparedStatement.setString(5, cliente.getEstadoCivil());
            preparedStatement.setString(6, cliente.getProfissao());
            preparedStatement.setString(7, cliente.getMorada());
            preparedStatement.setString(8, cliente.getEmail());
            preparedStatement.setString(9, cliente.getNumeroDeBI());
            preparedStatement.setInt(10, cliente.getContacto());
            preparedStatement.setInt(11, cliente.getContactoAlternativo());
            preparedStatement.setInt(12, cliente.getNuit());
            preparedStatement.setString(13, cliente.getGenero());

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

}
