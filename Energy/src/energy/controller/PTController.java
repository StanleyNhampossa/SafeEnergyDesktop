package energy.controller;

import energy.dao.ExceptionDAO;
import energy.model.PT;

import java.util.ArrayList;

public class PTController {

    public boolean cadastrarPT(int numeroDePT, String provincia, String cidade, String bairro)throws ExceptionDAO {

        if(String.valueOf(numeroDePT).length() > 0 && provincia.length() > 0 && cidade.length() > 0 && bairro.length() > 0){

            PT pt = new PT(provincia, cidade, bairro, numeroDePT);
            pt.cadastarPT(pt);
            return true;
        }

        return false;
    }

    public boolean deletarPT(int id)throws ExceptionDAO{

        if(String.valueOf(id).length() > 0){
            PT pt = new PT();
            pt.deletarPT(id);
            return true;
        }

        return false;
    }

    public ArrayList<PT> listarPT()throws ExceptionDAO{
        return new PT().listarPT();
    }

    public PT encontrarPTPorID(int id)throws ExceptionDAO{
        return new PT().encontrarPTPorID(id);
    }
    public boolean actualizarPT(int id, int numeroDePT, String provincia, String cidade, String bairro) throws ExceptionDAO{

        if(String.valueOf(numeroDePT).length() > 0 && provincia.length() > 0 && cidade.length() > 0 && bairro.length() > 0){

            PT pt = new PT(provincia, cidade, bairro, numeroDePT);
            pt.setId(id);
            pt.actualizarPT(pt);
            return true;
        }

        return false;

    }

}
