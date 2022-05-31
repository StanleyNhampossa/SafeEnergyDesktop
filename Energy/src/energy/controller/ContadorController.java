package energy.controller;

import energy.dao.ExceptionDAO;
import energy.model.Cliente;
import energy.model.Contador;

import java.util.ArrayList;

public class ContadorController {

    public boolean cadastarContador(int numeroDeContador){

        if (String.valueOf(numeroDeContador).length() > 0){
            return true;
        }


        return false;
    }

    public boolean cadastarContador(Cliente proprietario, int numeroDeContador) throws ExceptionDAO {
        if(proprietario != null && String.valueOf(numeroDeContador).length() > 0){

            Contador contador = new Contador(proprietario, numeroDeContador);
            contador.cadastrarContador(contador);

            return true;
        }



        return false;
    }

    public boolean cadastrarContador(String provincia, String cidade, String bairro,
                                     int numeroDeContador, String casa, Cliente proprietario) throws ExceptionDAO{

        if(provincia.length() > 0 && cidade.length() > 0 && bairro.length() > 0 &&
        String.valueOf(numeroDeContador).length() > 0 && proprietario != null){
            Contador contador = new Contador(provincia, cidade, bairro, numeroDeContador, casa, proprietario);
            contador.cadastrarContador(contador);

            return true;
        }

        return false;
    }

    public ArrayList<Contador> listarTodosContadores()throws ExceptionDAO{
        return new Contador().listarTodosContadores();
    }

    public Contador listarContadorPorID(int id) throws ExceptionDAO{
        return new Contador().listarContadorPorID(id);
    }

    public boolean editarContador(Contador contador/*Cliente proprietario, int numeroDeContador, String casa, String provincia, String cidade, String bairro*/)throws ExceptionDAO{

        if(contador.getCidade().length() > 0 && contador.getCidade().length() > 0 && contador.getBairro().length() > 0 && contador.getProvincia().length() > 0){
            contador.editarContador(contador);

            return true;
        }

        return false;
    }

}
