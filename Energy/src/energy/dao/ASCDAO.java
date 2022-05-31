package energy.dao;

import energy.model.AreaDeServicoAoCliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ASCDAO {

    public void cadastrarASC(AreaDeServicoAoCliente areaDeServicoAoCliente) throws ExceptionDAO{

        String sql = "insert into AreaDeServicoAoCliente (provincia, cidade_Municipio, areaDeServico) value (?, ?, ?)";

        PreparedStatement preparedStatement = null;

        Connection conexao = null;

        try {

            conexao = new ConnectionLocal().getConnection();
            preparedStatement = conexao.prepareStatement(sql);

            preparedStatement.setString(1, areaDeServicoAoCliente.getProvincia());
            preparedStatement.setString(2, areaDeServicoAoCliente.getCidade_Municipio());
            preparedStatement.setString(3, areaDeServicoAoCliente.getAreaDeServico());

            preparedStatement.execute();

        }catch (SQLException e){
            throw new ExceptionDAO("Erro ao cadastrar ASC " + e);
        }finally {

            try {
                if (preparedStatement != null)
                    preparedStatement.close();
            }catch (SQLException e){
                throw new ExceptionDAO("Erro ao fechar o statement " + e);
            }

            try {
                if (conexao != null)
                    conexao.close();
            }catch (SQLException e){
                throw new ExceptionDAO("Erro ao fechar conexão " + e);
            }

        }



    }

    public ArrayList<AreaDeServicoAoCliente> listarTodasASC() throws ExceptionDAO{

        String sql = "select * from AreaDeServicoAoCliente";

        PreparedStatement preparedStatement = null;
        Connection conexao = null;

        ArrayList<AreaDeServicoAoCliente> areasDeServicoAoCliente = null;


        try {

            conexao = new ConnectionLocal().getConnection();
            preparedStatement = conexao.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery(sql);

            if(resultSet != null) {

                areasDeServicoAoCliente = new ArrayList<>();

                while (resultSet.next()) {
                    AreaDeServicoAoCliente areaDeServicoAoCliente = new AreaDeServicoAoCliente();

                    areaDeServicoAoCliente.setCodigoDeASC(resultSet.getInt("codigoDeASC"));
                    areaDeServicoAoCliente.setProvincia(resultSet.getString("provincia"));
                    areaDeServicoAoCliente.setCidade_Municipio(resultSet.getString("cidade_Municipio"));
                    areaDeServicoAoCliente.setAreaDeServico(resultSet.getString("areaDeServico"));

                    areasDeServicoAoCliente.add(areaDeServicoAoCliente);

                }

            }
        }catch (SQLException e){
            throw new ExceptionDAO("Erro ao consultar Área de Serviço ao Cliente");
        }finally {

            try {
                if(preparedStatement != null)
                    preparedStatement.close();
            }catch (SQLException e){
                throw new ExceptionDAO("Erro ao fechar o statement " + e);
            }

            try {
                if (conexao != null)
                    conexao.close();
            }catch (SQLException e){
                throw new ExceptionDAO("Erro ao fechar conexão " + e);
            }

        }


        return areasDeServicoAoCliente;
    }

    public AreaDeServicoAoCliente listarASCPorId(int id) throws ExceptionDAO{

        String querySQL = "select * from AreaDeServicoAoCliente where codigoDeASC = ?";

        Connection conexao = null;
        PreparedStatement preparedStatement = null;

        AreaDeServicoAoCliente areaDeServicoAoCliente = null;

        try {
            conexao = new ConnectionLocal().getConnection();
            preparedStatement = conexao.prepareStatement(querySQL);

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();




        }catch (SQLException e){
            throw new ExceptionDAO("Erro ao consultar Área de Serviço");
        }

        return areaDeServicoAoCliente;

    }

    public void alterarASC(AreaDeServicoAoCliente asc) throws ExceptionDAO{

        String querySQL = "update AreaDeServicoAoCliente set provincia = ?, cidade_Municipio = ?, areaDeServico = ? where codigoDeASC = ?";

        Connection conexao = null;
        PreparedStatement preparedStatement = null;

        try {
            conexao = new ConnectionLocal().getConnection();
            preparedStatement = conexao.prepareStatement(querySQL);
            preparedStatement.setString(1, asc.getProvincia());
            preparedStatement.setString(2, asc.getCidade_Municipio());
            preparedStatement.setString(3, asc.getAreaDeServico());
            preparedStatement.setInt(4, asc.getCodigoDeASC());
            preparedStatement.execute();

        }catch (SQLException e){
            throw new ExceptionDAO("Erro ao editar Área de Serviço ao Cliente " + e);
        }finally {
            try {
                if(conexao != null)
                    conexao.close();
            }catch (SQLException e){
                throw new ExceptionDAO("Erro ao fechar conexão " + e);
            }

            try {
                if (preparedStatement != null)
                    preparedStatement.close();
            }catch (SQLException e){
                throw new ExceptionDAO("Erro ao fechar o statement " + e);
            }
        }

    }

}
