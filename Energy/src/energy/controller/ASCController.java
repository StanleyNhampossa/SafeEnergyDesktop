package energy.controller;

import energy.dao.ExceptionDAO;
import energy.model.AreaDeServicoAoCliente;

import java.util.ArrayList;

public class ASCController {
    
    public boolean cadastrarASC(String areaDeServico, String provincia, String municipio_Cidade) throws ExceptionDAO {

        if(areaDeServico.length() > 0 && areaDeServico != null && municipio_Cidade.length() > 0 && municipio_Cidade != null){

            AreaDeServicoAoCliente areaDeServicoAoCliente = new AreaDeServicoAoCliente(areaDeServico, provincia, municipio_Cidade);

            areaDeServicoAoCliente.cadastarASC(areaDeServicoAoCliente);

            return true;
        }

        return false;
    }

    public ArrayList<AreaDeServicoAoCliente> listarASC() throws ExceptionDAO{

        return new AreaDeServicoAoCliente().listrarASC();
    }
    
}
