package energy.controller;

import energy.dao.ExceptionDAO;
import energy.model.PedidoDeNovosContratos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

public class PedidoDeNovosContratosController {

    public ArrayList<PedidoDeNovosContratos> listarTodosPedidos()throws ExceptionDAO {
        return new PedidoDeNovosContratos().listarTodosPedidos();
    }

    public ArrayList<PedidoDeNovosContratos> listarPedidosRespondidos()throws ExceptionDAO{
        return new PedidoDeNovosContratos().listarPedidosRespondidos();
    }

    public ArrayList<PedidoDeNovosContratos> listarPedidosNaoRespondidos()throws ExceptionDAO{
        return new PedidoDeNovosContratos().listarPedidosNaoRespondidos();
    }

    public boolean responderPedidoDeNovoContrato(PedidoDeNovosContratos pedidoDeNovosContratos)throws ExceptionDAO{
        if(pedidoDeNovosContratos.isRespondido() == false){
            pedidoDeNovosContratos.setRespondido(true);
                GregorianCalendar gc=new GregorianCalendar();
                gc.add(gc.MONTH, 2);//Adicions dois meses a data de ida
                pedidoDeNovosContratos.setDataDaIda(gc.getTime());
            pedidoDeNovosContratos.responderPedidoDeNovoContrato(pedidoDeNovosContratos);
            return true;
        }

        return false;
    }

    public PedidoDeNovosContratos listarPedidoDeNovoContratoPorID(int id)throws ExceptionDAO{
        return new PedidoDeNovosContratos().listarPedidoDeNovoContratoPorID(id);
    }

}
