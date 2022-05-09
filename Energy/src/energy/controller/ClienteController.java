package energy.controller;


import energy.dao.ClienteDAO;
import energy.dao.ExceptionDAO;
import energy.escritadocx.NovoCliente;
import energy.model.Cliente;
import energy.model.Contador;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ClienteController {

    public boolean cadastarCliente(String nome, String apelido, String dataDeNascimento, String estadoCivil, String profissao, String morada, String email,
                                   String numeroDeBI, int contacto, int contactoAlternativo, int nuit, String genero, int numeroDeContador) throws ParseException, ExceptionDAO {

        if( (nome != null && nome.length() > 0) && (apelido != null && apelido.length() > 0) && dataDeNascimento.length() > 0 && validarDataDeNascimento(dataDeNascimento) && (estadoCivil != null && estadoCivil.length() > 0) &&
                (profissao != null & profissao.length() > 0) && (morada != null && morada.length() > 0) && (email.length() > 0 && validarEmail(email)) && (numeroDeBI.length() > 0 && validarNoBI(numeroDeBI))
                &&  (String.valueOf(contacto).length() > 0 && validarContacto(contacto)) && String.valueOf(contactoAlternativo).length() > 0 && validarContacto(contactoAlternativo) && String.valueOf(nuit).length() > 0 && validarNUIT(nuit) && validarSexo(genero)) {

            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/YYYY");

            Date data = formato.parse(dataDeNascimento);

            Contador contador = new Contador(numeroDeContador);
            ArrayList<Contador> contadores = new ArrayList<>();
            contadores.add(contador);

            Cliente cliente = new Cliente(nome, apelido, data, estadoCivil, profissao, morada, email, numeroDeBI, contacto, contactoAlternativo, nuit, genero, contadores);

            cliente.setPalavraPasse(apelido + nuit);
            cliente.cadastarCliente(cliente);


            //Ele chama o método responsável por cadastar contador

            ClienteDAO clienteDAO = new ClienteDAO();

            cliente = clienteDAO.encontrarClientePorEmail(cliente.getEmail());

            //NovoCliente novoCliente = new NovoCliente();

            //novoCliente.registarCredenciaisCliente(cliente);

            ContadorController contadorController = new ContadorController();

            contadorController.cadastarContador(cliente, numeroDeContador);
            //Fim

            return true;

        }
        return false;
    }

    public ArrayList<Cliente> listarClientes() throws ExceptionDAO{
        return new Cliente().listarTodosOsClientes();
    }

    public ArrayList<Cliente> listarClientesPorNome(String nome) throws ExceptionDAO{
        return new Cliente().listarTodosOsClientesPorNome(nome);
    }

    public boolean alterarCliente(int codigoDoCliente, String nome, String apelido, String dataDeNascimento, String estadoCivil, String profissao, String morada, String email,
                                   String numeroDeBI, int contacto, int contactoAlternativo, int nuit, String genero, int numeroDeContador) throws ParseException, ExceptionDAO {

        if( (nome != null && nome.length() > 0) && (apelido != null && apelido.length() > 0) && dataDeNascimento.length() > 0 && validarDataDeNascimento(dataDeNascimento) && (estadoCivil != null && estadoCivil.length() > 0) &&
                (profissao != null & profissao.length() > 0) && (morada != null && morada.length() > 0) && (email.length() > 0 && validarEmail(email)) && (numeroDeBI.length() > 0 && validarNoBI(numeroDeBI))
                &&  (String.valueOf(contacto).length() > 0 && validarContacto(contacto)) && String.valueOf(contactoAlternativo).length() > 0 && validarContacto(contactoAlternativo) && String.valueOf(nuit).length() > 0 && validarNUIT(nuit) && validarSexo(genero)) {

            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

            Date data = formato.parse(dataDeNascimento);


            Cliente cliente = new Cliente(nome, apelido, data, estadoCivil, profissao, morada, email, numeroDeBI, contacto, contactoAlternativo, nuit, genero);
            cliente.setCodigoDeCliente(codigoDoCliente);
            cliente.alterarCliente(cliente);


            return true;

        }
        return false;
    }

    public boolean validarSexo(String sexo){
        if(sexo == "M" || sexo == "F"){
            return true;
        }

        return false;
    }



    public boolean validarDataDeNascimento(String dataDeNascimento){
        for(int i = 0; i < dataDeNascimento.length(); i ++){
            if(!(Character.isDigit(dataDeNascimento.charAt(i)))){
                if(!(i == 2 || i == 5) ){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean validarEmail(String email){
        if(email.matches("^[A-Za-z0-9+.-]+@(.+)$")){
            return true;
        }

        return false;

    }

    public boolean validarNoBI(String noBI){
        for(int i = 0; i < noBI.length(); i ++){
            if(!(Character.isDigit(noBI.charAt(i)))){
                if(!(i == 13)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean validarContacto(int contacto){
        //if(contacto.matches("[82-87]+[0-9]*{5}"))


        return true;

    }


    public boolean validarNUIT(int nuit){
        return true;
    }


}


