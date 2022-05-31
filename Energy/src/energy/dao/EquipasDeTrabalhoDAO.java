package energy.dao;

import energy.model.EquipasDeTrabalho;
import energy.model.Funcionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EquipasDeTrabalhoDAO {

    public void cadastraEquipaDeTrabalho(EquipasDeTrabalho equipasDeTrabalho)throws ExceptionDAO{
        String querySQL = "insert into equipasdetrabalho (codigoDoLiderDaEquipa) value (?)";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{
            connection = new ConnectionLocal().getConnection();
            preparedStatement = connection.prepareStatement(querySQL);

            preparedStatement.setInt(1, equipasDeTrabalho.getLiderDaEquipa().getNumeroDeFuncionario());

            preparedStatement.execute();
        }catch (SQLException e){
            throw new ExceptionDAO("Erro ao cadastrar funcionário");
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

    public ArrayList<EquipasDeTrabalho> listarEquipasDeTrabalho()throws ExceptionDAO{
        ArrayList<EquipasDeTrabalho> equipasDeTrabalhos = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String querySQL = "select * from equipasdetrabalho join funcionario f on f.numeroDeFuncionario = equipasdetrabalho.codigoDoLiderDaEquipa where activo = 1";



        try {
            connection = new ConnectionLocal().getConnection();
            preparedStatement = connection.prepareStatement(querySQL);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet != null){
                equipasDeTrabalhos = new ArrayList<>();
                while (resultSet.next()){

                    EquipasDeTrabalho equipasDeTrabalho = new EquipasDeTrabalho();
                    Funcionario funcionario = new Funcionario();

                    equipasDeTrabalho.setNumeroDaEquipa(resultSet.getInt(1));

                    funcionario.setNumeroDeFuncionario(resultSet.getInt(2));
                    funcionario.setCategoria(resultSet.getString(6));
                    funcionario.setNome(resultSet.getString(7));
                    funcionario.setApelido(resultSet.getString(8));

                    equipasDeTrabalho.setLiderDaEquipa(funcionario);

                    equipasDeTrabalhos.add(equipasDeTrabalho);

                }

            }

        }catch (SQLException e){
            throw new ExceptionDAO("Erro ao listar equipas de trabalho " + e);
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


        return equipasDeTrabalhos;
    }

    public void listarEquipasDeTrabalhoPorID(int id)throws ExceptionDAO{
        EquipasDeTrabalho equipasDeTrabalho = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String querySQL = "update equipasdetrabalho set activo = 0 where numeroDaEquipa = ?";



        try {
            connection = new ConnectionLocal().getConnection();
            preparedStatement = connection.prepareStatement(querySQL);
            preparedStatement.setInt(1, id);

            preparedStatement.execute();

        }catch (SQLException e){
            throw new ExceptionDAO("Erro ao deletar equipas de trabalho " + e);
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
