package energy.controller;

import energy.dao.ExceptionDAO;
import energy.model.EquipasDeTrabalho;
import energy.model.Funcionario;

import java.util.ArrayList;

public class EquipasDeTrabalhoController {

    public boolean cadastrarEquipaDeTrabalho(Funcionario liderDaEquipa) throws ExceptionDAO {

        if(liderDaEquipa != null){
            EquipasDeTrabalho equipasDeTrabalho = new EquipasDeTrabalho();
            equipasDeTrabalho.setLiderDaEquipa(liderDaEquipa);
            equipasDeTrabalho.cadastrarEquipaDeTrabalho(equipasDeTrabalho);

            return true;
        }

        return false;
    }

    public ArrayList<EquipasDeTrabalho> listarEquipasDeTrabalho() throws ExceptionDAO{
        return new EquipasDeTrabalho().listarEquipasDeTrabalho();
    }

    public boolean listarEquipaDeTrabalhoPorID(int id)throws ExceptionDAO{
        if(String.valueOf(id).length() > 0) {
            new EquipasDeTrabalho().listarEquipaDeTrabalhoPrID(id);
            return true;
        }
        return false;
    }
}
