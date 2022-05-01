package energy.model;

import java.util.Date;

public final class Usuario extends Funcionario{

    public Usuario(String nome, String apelido, Date dataDeNascimento, String estadoCivil, String nacionalidade, String morada, String email, String numeroDeBI, int contacto, int contactoAlternativo, int nuit, String genero, AreaDeServicoAoCliente localDeTrabalho, String categoria) {
        super(nome, apelido, dataDeNascimento, estadoCivil, nacionalidade, morada, email, numeroDeBI, contacto, contactoAlternativo, nuit, genero, localDeTrabalho, categoria);
    }

    public Usuario(){}

}
