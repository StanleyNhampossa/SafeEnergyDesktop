package energy.model;

import java.util.ArrayList;

public class AreaDeServicoAoCliente {

    private int codigoDeASC;
    private String provincia;
    private String cidade_Municipio;
    private String areaDeServico;

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    private ArrayList<Funcionario> funcionarios = new ArrayList<>();

    public int getCodigoDeASC() {
        return codigoDeASC;
    }

    public void setCodigoDeASC(int codigoDeASC) {
        this.codigoDeASC = codigoDeASC;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCidade_Municipio() {
        return cidade_Municipio;
    }

    public void setCidade_Municipio(String cidade_Municipio) {
        this.cidade_Municipio = cidade_Municipio;
    }

    public String getAreaDeServico() {
        return areaDeServico;
    }

    public void setAreaDeServico(String areaDeServico) {
        this.areaDeServico = areaDeServico;
    }
}
