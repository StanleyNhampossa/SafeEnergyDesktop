package energy.model;

import java.util.Date;

public class Funcionario extends Pessoa{

    private int numeroDeFuncionario;
    private AreaDeServicoAoCliente localDeTrabalho;
    private String categoria;

    public Funcionario(String nome, String apelido, Date dataDeNascimento, String estadoCivil, String nacionalidade, String morada, String email, String numeroDeBI, int contacto, int nuit, String genero, AreaDeServicoAoCliente localDeTrabalho, String categoria) {
        super(nome, apelido, dataDeNascimento, estadoCivil, nacionalidade, morada, email, numeroDeBI, contacto, nuit, genero);
        this.localDeTrabalho = localDeTrabalho;
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getNumeroDeFuncionario() {
        return numeroDeFuncionario;
    }

    public void setNumeroDeFuncionario(int numeroDeFuncionario) {
        this.numeroDeFuncionario = numeroDeFuncionario;
    }

    public AreaDeServicoAoCliente getLocalDeTrabalho() {
        return localDeTrabalho;
    }

    public void setLocalDeTrabalho(AreaDeServicoAoCliente localDeTrabalho) {
        this.localDeTrabalho = localDeTrabalho;
    }

}
