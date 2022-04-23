package energy.controller;

import energy.model.Cliente;
import energy.model.Contador;

public class ContadorController {

    public boolean cadastarContador(int numeroDeContador){

        if (String.valueOf(numeroDeContador).length() > 0){
            return true;
        }


        return false;
    }

    public boolean cadastarContador(Cliente proprietario, int numeroDeContador){
        if(proprietario != null && String.valueOf(numeroDeContador).length() > 0){

            Contador contador = new Contador(proprietario, numeroDeContador);
            contador.cadastrarContador(contador);

            return true;
        }



        return false;
    }

    public boolean cadastrarContador(String provincia, String cidade, String bairro, int numeroDeContador, String casa, Cliente proprietario){

        return false;
    }

}
