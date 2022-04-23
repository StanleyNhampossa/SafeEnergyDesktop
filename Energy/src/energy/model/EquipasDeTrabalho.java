package energy.model;

import java.util.ArrayList;

public class EquipasDeTrabalho {

    private int numeroDaEquipa;
    private Funcionario liderDaEquipa;
    private ArrayList<Funcionario> membrosDaEquipa = new ArrayList<>();

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



}
