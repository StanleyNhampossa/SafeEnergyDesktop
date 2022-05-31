package energy.controller;

import energy.dao.ExceptionDAO;
import energy.model.Classificacao;

import java.util.ArrayList;

public class ClassificacaoController {

    public ArrayList<Classificacao> listarTodasClassificacoes()throws ExceptionDAO{
        return new Classificacao().listarTodasClassificacoes();
    }

}
