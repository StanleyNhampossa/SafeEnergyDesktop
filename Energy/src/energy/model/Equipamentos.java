package energy.model;

abstract class Equipamentos {

    protected String provincia;
    protected String cidade;
    protected String bairro;

    public Equipamentos(){

    }
    public Equipamentos(String provincia, String cidade, String bairro) {
        this.provincia = provincia;
        this.cidade = cidade;
        this.bairro = bairro;
    }





    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
}
