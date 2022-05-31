package energy.model;

import energy.dao.ExceptionDAO;
import energy.dao.ReclamacaoDAO;

import java.util.ArrayList;
import java.util.Date;

public class Reclamacao {

    private int id;
    private String nomeDoCliente;
    private String mensagem;
    private boolean anonimo;

    private String resposta;

    private String email;

    private Date dataDeEnvio;

    private boolean respondido;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeDoCliente() {
        return nomeDoCliente;
    }

    public void setNomeDoCliente(String nomeDoCliente) {
        this.nomeDoCliente = nomeDoCliente;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public boolean isAnonimo() {
        return anonimo;
    }

    public void setAnonimo(boolean anonimo) {
        this.anonimo = anonimo;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isRespondido() {
        return respondido;
    }

    public void setRespondido(boolean respondido) {
        this.respondido = respondido;
    }

    public Date getDataDeEnvio() {
        return dataDeEnvio;
    }

    public void setDataDeEnvio(Date dataDeEnvio) {
        this.dataDeEnvio = dataDeEnvio;
    }

    public ArrayList<Reclamacao> listarTodasReclamacoes()throws ExceptionDAO{
        return new ReclamacaoDAO().listarTodasReclamacoes();
    }

    public ArrayList<Reclamacao> listarReclamacoesRespondidas()throws ExceptionDAO{
        return new ReclamacaoDAO().listarReclamacoesRespondidas();
    }

    public ArrayList<Reclamacao> listarReclamacoesNaoRespondidas()throws ExceptionDAO{
        return new ReclamacaoDAO().listarReclamacoesNaoRespondidas();
    }

    public void responderReclamacao(Reclamacao reclamacao) throws ExceptionDAO{
        new ReclamacaoDAO().responderReclamacao(reclamacao);
    }

    public Reclamacao listarReclamacaoPorID(int id)throws ExceptionDAO{
        return new ReclamacaoDAO().listarReclamacaoPorID(id);
    }
}
