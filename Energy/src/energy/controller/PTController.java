package energy.controller;

import energy.dao.ExceptionDAO;
import energy.model.PT;

public class PTController {

    public boolean cadastrarPT(int numeroDePT, String provincia, String cidade, String bairro)throws ExceptionDAO {

        if(String.valueOf(numeroDePT).length() > 0 && provincia.length() > 0 && cidade.length() > 0 && bairro.length() > 0){

            PT pt = new PT(provincia, cidade, bairro, numeroDePT);
            pt.cadastarPT(pt);
            return true;
        }

        return false;
    }

}
