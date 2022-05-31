package energy.model;

import energy.dao.ExceptionDAO;
import energy.dao.PTDAO;

import java.util.ArrayList;

public class PT extends Equipamentos{

    private int numeroDePT;

    private int id;

    private ArrayList<Contador> contadores = new ArrayList<>();

    public PT(){

    }


    public PT(String provincia, String cidade, String bairro, int numeroDePT) {
        super(provincia, cidade, bairro);
        this.numeroDePT = numeroDePT;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void cadastarPT(PT pt)throws ExceptionDAO {
        new PTDAO().cadastrarPT(pt);
    }

    public ArrayList<PT> listarPT()throws ExceptionDAO{
        return new  PTDAO().listarTodosPTS();
    }

    public void actualizarPT(PT pt)throws ExceptionDAO{
        new PTDAO().actualzarPT(pt);
    }

    public void deletarPT(int id)throws ExceptionDAO{
        new PTDAO().deletarPT(id);
    }

    public PT encontrarPTPorID(int id)throws ExceptionDAO{
        return new PTDAO().encontrarPTPorID(id);
    }
}
