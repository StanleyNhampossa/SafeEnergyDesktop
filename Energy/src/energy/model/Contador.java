package energy.model;

import energy.dao.ContadorDAO;
import energy.dao.ExceptionDAO;

import java.util.ArrayList;

public class Contador extends Equipamentos{

    private int numeroDeContador;
    private String casa;
    private Cliente proprietario;
    private ArrayList<PT> pt = new ArrayList<>();

    public Contador(){  }


    public Contador(Cliente proprietario, int numeroDeContador){
        this.proprietario = proprietario;
        this.numeroDeContador = numeroDeContador;


    }

    public Contador(int numeroDeContador){
        this.numeroDeContador = numeroDeContador;
    }

    public Contador(String provincia, String cidade, String bairro, int numeroDeContador, String casa, Cliente proprietario, ArrayList<PT> pt) {
        super(provincia, cidade, bairro);
        this.numeroDeContador = numeroDeContador;
        this.casa = casa;
        this.proprietario = proprietario;
        this.pt = pt;
    }

    public ArrayList<PT> getPt() {
        return pt;
    }

    public void setPt(ArrayList<PT> pt) {
        this.pt = pt;
    }

    public int getNumeroDeContador() {
        return numeroDeContador;
    }

    public void setNumeroDeContador(int numeroDeContador) {
        this.numeroDeContador = numeroDeContador;
    }

    public String getCasa() {
        return casa;
    }

    public void setCasa(String casa) {
        this.casa = casa;
    }

    public Cliente getProprietario() {
        return proprietario;
    }

    public void setProprietario(Cliente proprietario) {
        this.proprietario = proprietario;
    }

    public void cadastrarContador(Contador contador) throws ExceptionDAO {
        new ContadorDAO().cadastrarContador(contador);
    }
}
