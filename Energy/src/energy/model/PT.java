package energy.model;

import java.util.ArrayList;

public class PT extends Equipamentos{

    private int numeroDePT;
    private ArrayList<Contador> contadores = new ArrayList<>();

    public PT(){

    }


    public PT(String provincia, String cidade, String bairro, int numeroDePT, ArrayList<Contador> contadores) {
        super(provincia, cidade, bairro);
        this.numeroDePT = numeroDePT;
        this.contadores = contadores;
    }



    public ArrayList<Contador> getContadores() {
        return contadores;
    }

    public void setContadores(ArrayList<Contador> contadores) {
        this.contadores = contadores;
    }

    public int getNumeroDePT() {
        return numeroDePT;
    }

    public void setNumeroDePT(int numeroDePT) {
        this.numeroDePT = numeroDePT;
    }
}
