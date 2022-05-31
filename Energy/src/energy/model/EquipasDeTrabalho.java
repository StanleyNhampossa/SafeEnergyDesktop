package energy.model;

import energy.dao.EquipasDeTrabalhoDAO;
import energy.dao.ExceptionDAO;

import java.util.ArrayList;

public class EquipasDeTrabalho {

    private int numeroDaEquipa;
    private Funcionario liderDaEquipa;
    private ArrayList<Funcionario> membrosDaEquipa = new ArrayList<>();

    private ArrayList<Classificacao> classificacoes = new ArrayList<>();
    public int getNumeroDaEquipa() {
        return numeroDaEquipa;
    }

    public void setNumeroDaEquipa(int numeroDaEquipa) {
        this.numeroDaEquipa = numeroDaEquipa;
    }

    public Funcionario getLiderDaEquipa() {
        return liderDaEquipa;
    }

    public void setLiderDaEquipa(Funcionario liderDaEquipa) {
        this.liderDaEquipa = liderDaEquipa;
    }

    public ArrayList<Funcionario> getMembrosDaEquipa() {
        return membrosDaEquipa;
    }

    public void setMembrosDaEquipa(ArrayList<Funcionario> membrosDaEquipa) {
        this.membrosDaEquipa = membrosDaEquipa;
    }

    public ArrayList<Classificacao> getClassificacoes() {
        return classificacoes;
    }

    public void setClassificacoes(ArrayList<Classificacao> classificacoes) {
        this.classificacoes = classificacoes;
    }

    public void cadastrarEquipaDeTrabalho(EquipasDeTrabalho equipasDeTrabalho) throws ExceptionDAO{
        new EquipasDeTrabalhoDAO().cadastraEquipaDeTrabalho(equipasDeTrabalho);
    }

    public ArrayList<EquipasDeTrabalho> listarEquipasDeTrabalho() throws ExceptionDAO{
        return new EquipasDeTrabalhoDAO().listarEquipasDeTrabalho();
    }

    public void listarEquipaDeTrabalhoPrID(int id)throws ExceptionDAO{
        new EquipasDeTrabalhoDAO().listarEquipasDeTrabalhoPorID(id);
    }
}
