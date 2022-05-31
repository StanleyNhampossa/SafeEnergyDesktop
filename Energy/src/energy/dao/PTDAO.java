package energy.dao;

import energy.model.PT;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PTDAO {

    public void cadastrarPT(PT pt) throws ExceptionDAO {

        String querySQL = "insert into pt (numeroDoPT, provincia, cidade, bairro) value (?, ?, ?, ?)";

        Connection conexao = null;
        PreparedStatement preparedStatement = null;

        try {
            conexao = new ConnectionLocal().getConnection();
            preparedStatement = conexao.prepareStatement(querySQL);

            preparedStatement.setInt(1, pt.getNumeroDePT());
            preparedStatement.setString(2, pt.getProvincia());
            preparedStatement.setString(3, pt.getCidade());
            preparedStatement.setString(4, pt.getBairro());
            preparedStatement.execute();

        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao cadastrar PT " + e);
        } finally {
            try {
                if (conexao != null)
                    conexao.close();
            } catch (SQLException e) {
                throw new ExceptionDAO("Erro ao fechar conexão " + e);
            }
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
            } catch (SQLException e) {
                throw new ExceptionDAO("Erro ao fechar statement " + e);
            }
        }

    }

    public ArrayList<PT> listarTodosPTS() throws ExceptionDAO {
        ArrayList<PT> pts = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String querSQL = "select * from pt where activo = 1";

        try {
            connection = new ConnectionLocal().getConnection();
            preparedStatement = connection.prepareStatement(querSQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet != null) {
                pts = new ArrayList<>();
                while (resultSet.next()) {
                    PT pt = new PT();
                    pt.setId(resultSet.getInt(1));
                    pt.setNumeroDePT(resultSet.getInt(2));
                    pt.setProvincia(resultSet.getString(3));
                    pt.setCidade(resultSet.getString(4));
                    pt.setBairro(resultSet.getString(5));

                    pts.add(pt);
                }
            }
        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao listar PT " + e);
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                throw new ExceptionDAO("Erro ao fechar conexão " + e);
            }
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
            } catch (SQLException e) {
                throw new ExceptionDAO("Erro ao fechar o statement " + e);
            }
        }

        return pts;
    }

    public PT encontrarPTPorID(int id) throws ExceptionDAO {
        PT pt = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String querSQL = "select * from pt where activo = 1 and id = ?";

        try {
            connection = new ConnectionLocal().getConnection();
            preparedStatement = connection.prepareStatement(querSQL);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                pt = new PT();
                pt.setId(resultSet.getInt(1));
                pt.setNumeroDePT(resultSet.getInt(2));
                pt.setProvincia(resultSet.getString(3));
                pt.setCidade(resultSet.getString(4));
                pt.setBairro(resultSet.getString(5));

            }
        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao listar PT " + e);
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                throw new ExceptionDAO("Erro ao fechar conexão " + e);
            }
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
            } catch (SQLException e) {
                throw new ExceptionDAO("Erro ao fechar o statement " + e);
            }
        }

        return pt;
    }

    public void deletarPT(int id) throws ExceptionDAO {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String querySQL = "update pt set activo = 0 where id = ?";

        try {
            connection = new ConnectionLocal().getConnection();
            preparedStatement = connection.prepareStatement(querySQL);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao listar PT " + e);
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                throw new ExceptionDAO("Erro ao fechar conexão " + e);
            }
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
            } catch (SQLException e) {
                throw new ExceptionDAO("Erro ao fechar o statement " + e);
            }

        }

    }

    public void actualzarPT(PT pt) throws ExceptionDAO {

        String querySQL = "update pt set numeroDoPT = ?, provincia = ?, cidade = ?, bairro = ? where id = ?";

        Connection conexao = null;
        PreparedStatement preparedStatement = null;

        try {
            conexao = new ConnectionLocal().getConnection();
            preparedStatement = conexao.prepareStatement(querySQL);

            preparedStatement.setInt(1, pt.getNumeroDePT());
            preparedStatement.setString(2, pt.getProvincia());
            preparedStatement.setString(3, pt.getCidade());
            preparedStatement.setString(4, pt.getBairro());
            preparedStatement.setInt(5, pt.getId());
            preparedStatement.execute();

        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao editar PT " + e);
        } finally {
            try {
                if (conexao != null)
                    conexao.close();
            } catch (SQLException e) {
                throw new ExceptionDAO("Erro ao fechar conexão " + e);
            }
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
            } catch (SQLException e) {
                throw new ExceptionDAO("Erro ao fechar statement " + e);
            }
        }

    }

}