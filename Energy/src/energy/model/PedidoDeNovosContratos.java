package energy.model;

import energy.dao.ExceptionDAO;
import energy.dao.PedidoDeNovoContratoDAO;

import java.util.ArrayList;
import java.util.Date;

public class PedidoDeNovosContratos {

    private int id;

    private String nomeDoCliente;

    private Date dataDeNascimento;

    private String distrito;

    private int contacto;

    private String email;

    private String localizacaoDaCasa;

    private String numeroDaCasa;

    private Date dataDaIda;

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

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public void setNomeDoCliente(String nomeDoCliente) {
        this.nomeDoCliente = nomeDoCliente;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public int getContacto() {
        return contacto;
    }

    public void setContacto(int contacto) {
        this.contacto = contacto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocalizacaoDaCasa() {
        return localizacaoDaCasa;
    }

    public void setLocalizacaoDaCasa(String localizacaoDaCasa) {
        this.localizacaoDaCasa = localizacaoDaCasa;
    }

    public String getNumeroDaCasa() {
        return numeroDaCasa;
    }

    public void setNumeroDaCasa(String numeroDaCasa) {
        this.numeroDaCasa = numeroDaCasa;
    }

    public Date getDataDaIda() {
        return dataDaIda;
    }

    public void setDataDaIda(Date dataDaIda) {
        this.dataDaIda = dataDaIda;
    }

    public boolean isRespondido() {
        return respondido;
    }

    public void setRespondido(boolean respondido) {
        this.respondido = respondido;
    }

    public ArrayList<PedidoDeNovosContratos> listarTodosPedidos()throws ExceptionDAO{
        return new PedidoDeNovoContratoDAO().listarTodosPedidos();
    }

    public ArrayList<PedidoDeNovosContratos> listarPedidosRespondidos()throws ExceptionDAO{
        return new PedidoDeNovoContratoDAO().listarPedidosRespondidos();
    }

    public ArrayList<PedidoDeNovosContratos> listarPedidosNaoRespondidos()throws ExceptionDAO{
        return new PedidoDeNovoContratoDAO().listarPedidosNaoRespondidos();
    }

    public void responderPedidoDeNovoContrato(PedidoDeNovosContratos pedidoDeNovosContratos)throws ExceptionDAO{
        new PedidoDeNovoContratoDAO().respondendoPedidosDeNovosContratos(pedidoDeNovosContratos);
    }

    public PedidoDeNovosContratos listarPedidoDeNovoContratoPorID(int id)throws ExceptionDAO{
        return new PedidoDeNovoContratoDAO().listarPedidoDeNovoCOntrato(id);
    }
}
