package energy.model;

import java.util.Date;

abstract class Pessoa {

    protected String nome;
    protected String apelido;

    protected Date dataDeNascimento;
    protected String estadoCivil;
    protected String profissao;
    protected String morada;
    protected String email;
    protected String numeroDeBI;
    protected int contacto;
    protected int nuit;
    protected String genero;

    public Pessoa(){

    }

    public Pessoa(String nome, String apelido, Date dataDeNascimento, String estadoCivil, String profissao, String morada, String email, String numeroDeBI, int contacto, int nuit, String genero) {
        this.nome = nome;
        this.apelido = apelido;
        this.dataDeNascimento = dataDeNascimento;
        this.estadoCivil = estadoCivil;
        this.profissao = profissao;
        this.morada = morada;
        this.email = email;
        this.numeroDeBI = numeroDeBI;
        this.contacto = contacto;
        this.nuit = nuit;
        this.genero = genero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }


    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumeroDeBI() {
        return numeroDeBI;
    }

    public void setNumeroDeBI(String numeroDeBI) {
        this.numeroDeBI = numeroDeBI;
    }

    public int getContacto() {
        return contacto;
    }

    public void setContacto(int contacto) {
        this.contacto = contacto;
    }

    public int getNuit() {
        return nuit;
    }

    public void setNuit(int nuit) {
        this.nuit = nuit;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
