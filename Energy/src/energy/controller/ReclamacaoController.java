package energy.controller;

import energy.dao.ExceptionDAO;
import energy.model.Reclamacao;

import java.util.ArrayList;

public class ReclamacaoController {

    public ArrayList<Reclamacao> listarTodasReclamacoes() throws ExceptionDAO {
        return new Reclamacao().listarTodasReclamacoes();
    }

    public ArrayList<Reclamacao> listarReclamacoesRespondidas()throws ExceptionDAO{
        return new Reclamacao().listarReclamacoesRespondidas();
    }

    public ArrayList<Reclamacao> listarReclamacoesNaoRespondidas()throws ExceptionDAO{
        return new Reclamacao().listarReclamacoesNaoRespondidas();
    }

    public boolean responderMensagem(Reclamacao reclamacao)throws ExceptionDAO{
        if(reclamacao.getResposta().length() > 0){
            reclamacao.responderReclamacao(reclamacao);
            return true;
        }
        return false;
    }



    public Reclamacao listarReclamacaoPorID(int id) throws ExceptionDAO{
        return new Reclamacao().listarReclamacaoPorID(id);
    }

}
