package energy.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TelaAdministracao extends JFrame implements ActionListener {

    JLabel lblLateralEsquerdoFundo = new JLabel();
    JLabel lblBarraDeColocacaoDados1Fundo = new JLabel(); // cores do fundo

    //  
    ImageIcon fotoDePerfil = new ImageIcon("src\\imagens\\icon\\user_1.png");
    JLabel lblPerfilFoto = new JLabel(fotoDePerfil);

// botao de sair
    ImageIcon exit = new ImageIcon("src\\imagens\\icon\\exit.png");
    JButton btnExit = new JButton(exit);
    // botoes
    JButton btnFuncionarios = new JButton("  Funcionarios ");
    JButton btnEquipesDeTrabalho = new JButton(" Equipes de Trabalho ");
    JButton btnCadastroPts = new JButton("  PT's ");
    JButton btnCadstrarMaterialTrabal = new JButton(" Material Trabalho ");
    JButton btnRelatorio = new JButton(" Relatorio");
// cores
    Color tangerine = new Color(255, 232, 119);
    Color pumpikin = new Color(248, 144, 23);
    Color wheat = new Color(255, 185, 57);
    //separador
    JSeparator separador = new JSeparator();
    // tabela
    Object[][] dados = {
        {"Nome de Funcionario", " Telefone", "Turno", " Email"},
        {"", "", "", ""},
        {"", "", "", ""}
    };

    String[] colunas = {"  Nome", "  Telefone", "  Morada", "  Email"};

    JTable tabela = new JTable(dados, colunas); // 
    //
    JLabel lblNomeDoFuncionario = new JLabel(" Nome Do Administrador  ");

    // butoes crud 
    ImageIcon fundoAtualizar = new ImageIcon("src\\imagens\\icon\\atualizar.png");
    JButton btnAtualizar = new JButton("Atualizar", fundoAtualizar);
    //
    ImageIcon fundoPesquisar = new ImageIcon("src\\imagens\\icon\\search_find.png");
    JButton btnPesquisar = new JButton("Pesquisar", fundoPesquisar);
    //
    ImageIcon fundoListar = new ImageIcon("src\\imagens\\icon\\listar.png");
    JButton btnListar = new JButton("Listar", fundoListar);
    //
    ImageIcon fundoDeletar = new ImageIcon("src\\imagens\\icon\\delete.png");
    JButton btnDeletar = new JButton("Deletar", fundoDeletar);
    //

    public TelaAdministracao() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // funcao para fechar a tela do programa.
        setVisible(true); // faz com que a tela fique visivel.
        setLocationRelativeTo(null); // Reposicciona a tela do programa.
        setResizable(false);//  faz com que a tela minimize ou maximize.
        setSize(989, 612); // As Dimencoes da tela 
        setTitle("Tela Administracao"); //  Titulo da tela.

    } // fim de contruttor

    public void gui() {
        setLayout(null);

        lblLateralEsquerdoFundo.setBounds(0, 0, 275, 612);
        lblLateralEsquerdoFundo.setBackground(pumpikin); // Lateral Esquerdo Fundo
        lblLateralEsquerdoFundo.setOpaque(true);

        lblBarraDeColocacaoDados1Fundo.setBounds(275, 70, 989, 190);
        lblBarraDeColocacaoDados1Fundo.setBackground(wheat); // foto de perfil
        lblBarraDeColocacaoDados1Fundo.setOpaque(true);

        //
        separador.setBounds(20, 180, 240, 30);
        separador.setBackground(Color.WHITE);
        separador.setOrientation(SwingConstants.HORIZONTAL);
        //
        btnExit.setBounds(220, 190, 35, 45);
        btnExit.setContentAreaFilled(false);// butto de JBexet.
        btnExit.setBorderPainted(false);
        //
        lblPerfilFoto.setBounds(30, 100, 60, 60); //  login simbolo
        //
        btnCadastroPts.setBounds(0, 250, 272, 50);
        btnCadastroPts.setBackground(pumpikin);
        //btnCadastroPts.setBorderPainted(false);

        //
        btnEquipesDeTrabalho.setBounds(0, 350, 272, 50);
        btnEquipesDeTrabalho.setBackground(pumpikin);
        //btnEquipesDeTrabalho.setBorderPainted(false);
        //
        btnFuncionarios.setBounds(0, 300, 272, 50);
        btnFuncionarios.setBackground(pumpikin);
        //btnFuncionarios.setBorderPainted(false);
        //
        btnCadstrarMaterialTrabal.setBounds(0, 400, 272, 50);
        btnCadstrarMaterialTrabal.setBackground(pumpikin);
        //btnCadstrarMaterialTrabal.setBorderPainted(false);

        btnRelatorio.setBounds(0, 450, 272, 50);
        btnRelatorio.setBackground(pumpikin);
        //btnRelatorio.setBorderPainted(false);
        // 
        tabela.setBounds(283, 275, 690, 300);
        //
        lblNomeDoFuncionario.setBounds(100, 120, 160, 10);
        // Crud

        // atualizar
        btnAtualizar.setBounds(300, 90, 120, 40);
        btnAtualizar.setBackground(pumpikin);
        //listar
        btnListar.setBounds(300, 150, 120, 40);
        btnListar.setBackground(pumpikin);
        //eliminar
        btnDeletar.setBounds(450, 90, 120, 40);
       btnDeletar.setBackground(pumpikin);
        //pesquisar
        btnPesquisar.setBounds(450, 150, 120, 40);
        btnPesquisar.setBackground(pumpikin);
        // Crud
        add(btnAtualizar);
        add(btnPesquisar);
        add(btnListar);
        add(btnDeletar);
        add(btnPesquisar);

        //
        add(lblPerfilFoto);
        add(separador);
        add(lblNomeDoFuncionario);
        add(tabela);
        add(btnRelatorio);
        add(btnCadstrarMaterialTrabal);
        add(btnEquipesDeTrabalho);
        add(btnCadastroPts);
        add(btnFuncionarios);

        add(btnExit);
        add(lblBarraDeColocacaoDados1Fundo);
        add(lblLateralEsquerdoFundo);

        btnExit.addActionListener(this);

    } // fim gui
    
    

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnExit) {

            int SimOuNao = JOptionPane.showConfirmDialog(null, "Tem a certeza  de que queres terminar a sessao?", " Terminar a Sessao? ", JOptionPane.YES_NO_OPTION);
            if (SimOuNao == 0) {
                dispose();
                new TelaLogin().gui();
            } else {
                dispose();
                new TelaAdministracao().gui();

            }

        }
    }

    public static void main(String[] args) {
        new TelaAdministracao().gui();
    }

}// fin clss
