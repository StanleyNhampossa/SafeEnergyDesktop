package energy.model;

import energy.dao.ASCDAO;
import energy.dao.ExceptionDAO;

import java.util.ArrayList;

public class AreaDeServicoAoCliente {

    private int codigoDeASC;
    private String provincia;
    private String cidade_Municipio;
    private String areaDeServico;

    public AreaDeServicoAoCliente(String areaDeServico, String provincia, String cidade_Municipio) {
        this.provincia = provincia;
        this.cidade_Municipio = cidade_Municipio;
        this.areaDeServico = areaDeServico;
    }

    public AreaDeServicoAoCliente(){}

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

    @Override
    public String toString(){
        return this.areaDeServico;
    }

    public void cadastarASC(AreaDeServicoAoCliente areaDeServicoAoCliente) throws ExceptionDAO {
        new ASCDAO().cadastrarASC(areaDeServicoAoCliente);
    }

    public ArrayList<AreaDeServicoAoCliente> listrarASC() throws ExceptionDAO{
        return new ASCDAO().listarTodasASC();
    }

    public void alterarASC(AreaDeServicoAoCliente areaDeServicoAoCliente) throws ExceptionDAO {
        new ASCDAO().alterarASC(areaDeServicoAoCliente);
    }


}
