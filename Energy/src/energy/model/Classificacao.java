package energy.model;

import energy.dao.ClassificacaoDAO;
import energy.dao.ExceptionDAO;

import java.util.ArrayList;

public class Classificacao {

    private int id;

    private double numeroDeEstrelas;

    private String comentario;

    private EquipasDeTrabalho equipasDeTrabalho;

    private int numeroDaEquipa;

    private String nomeDoCliente;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getNumeroDeEstrelas() {
        return numeroDeEstrelas;
    }

    public void setNumeroDeEstrelas(double numeroDeEstrelas) {
        this.numeroDeEstrelas = numeroDeEstrelas;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public EquipasDeTrabalho getEquipasDeTrabalho() {
        return equipasDeTrabalho;
    }

    public void setEquipasDeTrabalho(EquipasDeTrabalho equipasDeTrabalho) {
        this.equipasDeTrabalho = equipasDeTrabalho;
    }

    public String getNomeDoCliente() {
        return nomeDoCliente;
    }

    public int getNumeroDaEquipa() {
        return numeroDaEquipa;
    }

    public void setNumeroDaEquipa(int numeroDaEquipa) {
        this.numeroDaEquipa = numeroDaEquipa;
    }

    public void setNomeDoCliente(String nomeDoCliente) {
        this.nomeDoCliente = nomeDoCliente;
    }

    public ArrayList<Classificacao> listarTodasClassificacoes()throws ExceptionDAO{
        return new ClassificacaoDAO().listarTodasClassificacoes();
    }
}
