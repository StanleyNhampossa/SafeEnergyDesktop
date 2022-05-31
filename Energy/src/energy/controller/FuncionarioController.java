package energy.controller;

import energy.dao.ExceptionDAO;
import energy.model.AreaDeServicoAoCliente;
import energy.model.Funcionario;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class FuncionarioController {

    public boolean cadastrarFuncionario(String nome, String apelido, String dataDeNascimento, String estadoCivil, String profissao, String morada, String email,
                                        String numeroDeBI, int contacto, int contactoAlternativo, int nuit, String genero, AreaDeServicoAoCliente areaDeServicoAoCliente, String categoria) throws ParseException, ExceptionDAO {

        if( (nome != null && nome.length() > 0) && (apelido != null && apelido.length() > 0) && dataDeNascimento.length() > 0 && validarDataDeNascimento(dataDeNascimento) && (estadoCivil != null && estadoCivil.length() > 0) &&
                (profissao != null & profissao.length() > 0) && (morada != null && morada.length() > 0) && (email.length() > 0 && validarEmail(email)) && (numeroDeBI.length() > 0 && validarNoBI(numeroDeBI))
                &&  (String.valueOf(contacto).length() > 0 && validarContacto(contacto)) && String.valueOf(contactoAlternativo).length() > 0 && validarContacto(contactoAlternativo) && String.valueOf(nuit).length() > 0 && validarNUIT(nuit) && validarSexo(genero) && (categoria != null && categoria.length() > 0)) {

            //Ele faz a formatação da data de nascimento
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/YYYY");
            Date data = formato.parse(dataDeNascimento);

            //Ele chama o método a classe da Model para poder cadastrar o funcionário
            Funcionario funcionario = new Funcionario(nome, apelido, data, estadoCivil, profissao, morada, email, numeroDeBI, contacto, contactoAlternativo, nuit, genero, areaDeServicoAoCliente, categoria);
            funcionario.setPalavraPasse(apelido + nuit);
            funcionario.cadastarFuncionario(funcionario);

            return true;

        }
        return false;
    }

    public Funcionario encontrarFuncionario(String email) throws ExceptionDAO{
        return new Funcionario().encontrarFuncionarioPorEmail(email);
    }

    public boolean alterarFuncionario(int numeroDoFuncionario, String nome, String apelido, String dataDeNascimento, String estadoCivil, String profissao, String morada, String email,
                                        String numeroDeBI, int contacto, int contactoAlternativo, int nuit, String genero, AreaDeServicoAoCliente areaDeServicoAoCliente, String categoria) throws ParseException, ExceptionDAO {

        if((nome != null && nome.length() > 0) && (apelido != null && apelido.length() > 0) && dataDeNascimento.length() > 0 && validarDataDeNascimento(dataDeNascimento) && (estadoCivil != null && estadoCivil.length() > 0) &&
                (profissao != null & profissao.length() > 0) && (morada != null && morada.length() > 0) && (email.length() > 0 && validarEmail(email)) && (numeroDeBI.length() > 0 && validarNoBI(numeroDeBI))
                &&  (String.valueOf(contacto).length() > 0 && validarContacto(contacto)) && String.valueOf(contactoAlternativo).length() > 0 && validarContacto(contactoAlternativo) && String.valueOf(nuit).length() > 0 && validarNUIT(nuit) && validarSexo(genero) && (categoria != null && categoria.length() > 0)) {

            //Ele faz a formatação da data de nascimento
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Date data = formato.parse(dataDeNascimento);

            //Ele chama o método a classe da Model para poder alterar o funcionário
            Funcionario funcionario = new Funcionario(nome, apelido, data, estadoCivil, profissao, morada, email, numeroDeBI, contacto, contactoAlternativo, nuit, genero, areaDeServicoAoCliente, categoria);
            funcionario.setNumeroDeFuncionario(numeroDoFuncionario);
            funcionario.alterarFuncionario(funcionario);

            return true;

        }
        return false;
    }

    public ArrayList<Funcionario> listarTodosFuncionarios() throws ExceptionDAO{
        return new Funcionario().listarTodosFuncionarios();
    }

    public void alterarSenha(Funcionario funcionario, String novaSenha) throws ExceptionDAO{
        new Funcionario().alterarSenha(funcionario, novaSenha);
    }

    public boolean deletarFuncionario(int id)throws ExceptionDAO{
        if(id != 0){
            Funcionario funcionario = new Funcionario();
            funcionario.setNumeroDeFuncionario(id);
            funcionario.deletarFuncionario(funcionario);
            return true;
        }

        return false;
    }

    public Funcionario encontrarFuncionarioPorID(int id)throws ExceptionDAO{
        return new Funcionario().encontrarFuncionarioPorID(id);
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
