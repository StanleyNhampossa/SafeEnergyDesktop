package energy.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class TelaDeFuncionarios extends JFrame implements ActionListener {

    // padrao da tela
    JLabel lblLateralEsquerdoFundo = new JLabel();
    JLabel lblBarraSuperiorFundo = new JLabel();
    JLabel lblBarraSuperiorContinuacaoFundo = new JLabel();
    JLabel lblBarraDeColocacaoDados1Fundo = new JLabel(); // cores do fundo
    JLabel lblBarraDeColocacaoDados2Fundo = new JLabel();

    // formatacao de data 
//   Calendar c = Calendar.getInstance();
//     Date data = c.getTime();
//     DateFormat f = DateFormat.getDateInstance(DateFormat.FULL); //Data COmpleta
//
//    // System.out.println ("Data brasileira: "+f.format(data));
//
//      JLabel lblData = new JLabel();
    // JLabel lblDataFormatada = new JLabel(Date);
    // cores da tela
    Color pumpikin = new Color(248, 144, 23);
    Color tangerine = new Color(255, 232, 119);
    Color laranjado = new Color(255, 203, 119);
    Color redsand = new Color(248, 229, 90);
    Color wheat = new Color(255, 185, 57);
    Color orange = new Color(252, 241, 186);

    // funcionalidades da tela
    JLabel lblPesqisar = new JLabel(" Pesquisar   ");
    JTextField txtPesqisar = new JTextField();

    //
    ImageIcon fotoDePerfil = new ImageIcon("src\\imagens\\icon\\user.png");
    JLabel lblPerfilFoto = new JLabel(fotoDePerfil);
    //
    JLabel lblNomeDoFuncionario = new JLabel(" Nome Do Funcionario  ");
    //
    JLabel lblCategoria = new JLabel(" Categoria Do Funcionario  ");
    // butoes
    ImageIcon exit = new ImageIcon("src\\imagens\\icon\\exit.png");
    JButton btnExit = new JButton(exit);

    JButton btnCadastroDeCliente = new JButton("Cadas. Cliente  ");
    JButton btnInformacaoPT = new JButton("Dados Do PT ");
    JButton btnMeuPerfil = new JButton("Meu Perfil ");
    JButton btnDadosDoCliente = new JButton("Dados Do Cliente");
    JButton btnAdministrador = new JButton("Administração");
    //  cadastramento
    JMenu jMenuMaisInformacoes = new JMenu(" Mais informações ");
    JMenuItem jmiOpcaoInfoDoContador = new JMenuItem("Contador");
    JMenuItem jmiOpcaoInfoListarEquipe = new JMenuItem("Listar Equipe");//x
    JMenuItem jmiOpcaoInfoDoPT = new JMenuItem("PT");
    JMenuItem jmiOpcaoInfoDoFuncionario = new JMenuItem("Funcionario");
    JMenuItem jmiOpcaoInfoEquipe = new JMenuItem("Equipe de trabalho");
    JMenuItem jmiOpcaoInfoEquipamentos = new JMenuItem("Equipamentos de trabalho");
    // relatorio
    JMenu JmenuRelatorio = new JMenu(" Relatorio ");

    //  Menu de barra
    JMenuBar barraDeMenu = new JMenuBar();
    //
    JSeparator separador = new JSeparator();

    // tabela
    Object[][] dados = {
        {"Nome", " Nº Contador ", " Telefone", " Morada", " Email"},
        {"", "", "", ""},
        {"", "", "", ""}
    };


    String[] colunas = {"  Nome", "  Telefone", "  Morada", "  Email"};

    JTable tabela = new JTable(dados, colunas); // 
    //    //
    ImageIcon b1 = new ImageIcon("src\\imagens\\icon\\email (2).png");
    JButton btn1 = new JButton(b1);
    ImageIcon b2 = new ImageIcon("src\\imagens\\icon\\padlock (1).png");
    JButton btn2 = new JButton(b2);
    ImageIcon b3 = new ImageIcon("src\\imagens\\icon\\calendar.png");
    JButton btn3 = new JButton(b3);
//

    // Decclarar um construttor para criar as funcionalidade basicas como
    //sair do programa, minimizar ou maximizar , aumentare dimunuir a tela.
    public TelaDeFuncionarios() {
        // setPreferredSize(new Dimension(989, 612));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // funcao para fechar a tela do programa.
        setVisible(true); // faz com que a tela fique visivel.
        setLocationRelativeTo(null); // Reposicciona a tela do programa.
        setResizable(false);//  faz com que a tela minimize ou maximize.
        setSize(989, 612); // As Dimencoes da tela 
        setTitle("Tela Funcionarios"); //  Titulo da tela.

    } // fim de contruttor

    public void gui() {

        setLayout(null);
        lblPesqisar.setBounds(730, 0, 989, 50);
        txtPesqisar.setBounds(810, 15, 150, 20);
        //
        lblLateralEsquerdoFundo.setBounds(0, 0, 130, 612);
        lblLateralEsquerdoFundo.setBackground(pumpikin); // Lateral Esquerdo Fundo
        lblLateralEsquerdoFundo.setOpaque(true);
        //
        lblBarraSuperiorFundo.setBounds(0, 0, 989, 50);
        lblBarraSuperiorFundo.setBackground(tangerine); // Barra Superior
        lblBarraSuperiorFundo.setOpaque(true);
        //
        lblBarraSuperiorContinuacaoFundo.setBounds(100, 30, 380, 612);
        lblBarraSuperiorContinuacaoFundo.setBackground(tangerine); // BarraS uperior Continuacao Fundo
        lblBarraSuperiorContinuacaoFundo.setOpaque(true);
        //
        lblBarraDeColocacaoDados1Fundo.setBounds(100, 50, 380, 95);
        lblBarraDeColocacaoDados1Fundo.setBackground(laranjado); // foto de perfil
        lblBarraDeColocacaoDados1Fundo.setOpaque(true); //
        //
        lblBarraDeColocacaoDados2Fundo.setBounds(130, 140, 350, 160);
        lblBarraDeColocacaoDados2Fundo.setBackground(wheat); // dados de usuario
        lblBarraDeColocacaoDados2Fundo.setOpaque(true);

        //
        lblNomeDoFuncionario.setBounds(220, 75, 170, 20); //        
        lblNomeDoFuncionario.setForeground(Color.BLACK); //

        //
        lblCategoria.setBounds(150, 160, 180, 20); //        
        lblCategoria.setForeground(Color.BLACK); //

        //
        btnExit.setBounds(430, 50, 35, 45);
        btnExit.setContentAreaFilled(false);// butto de JBexet.
        btnExit.setBorderPainted(false);
        //
        btnCadastroDeCliente.setBounds(0, 225, 130, 50);
        btnCadastroDeCliente.setBackground(pumpikin);
        btnCadastroDeCliente.setBorderPainted(false);
        //
        btnInformacaoPT.setBounds(0, 175, 130, 50);
        btnInformacaoPT.setBackground(pumpikin); // butto de btnInformacaoPT
        btnInformacaoPT.setBorderPainted(false);
        lblPerfilFoto.setBounds(140, 50, 65, 95); //  login simbolo
        //
        btnMeuPerfil.setBounds(0, 125, 130, 50);
        btnMeuPerfil.setBackground(pumpikin); // butto de btnMeuPerfil
        btnMeuPerfil.setBorderPainted(false);
        //pesquisar
        btnDadosDoCliente.setBounds(0, 275, 130, 50);
        btnDadosDoCliente.setBackground(pumpikin);
        btnDadosDoCliente.setBorderPainted(false);

        // Data
        // lblData.setBounds(0,0, 130, 50);
        // tabela
        tabela.setBounds(485, 235, 490, 300);
        //
        separador.setBounds(150, 230, 240, 30);
        separador.setBackground(Color.WHITE);
        separador.setOrientation(SwingConstants.HORIZONTAL);
        //
        btn1.setBounds(200, 240, 26, 26);
        btn1.setContentAreaFilled(false);
        btn1.setBorderPainted(false);
        btn2.setBounds(260, 240, 26, 26);
        btn2.setContentAreaFilled(false);
        btn2.setBorderPainted(false);
        btn3.setBounds(330, 240, 26, 26);
        btn3.setContentAreaFilled(false);
        btn3.setBorderPainted(false);
        //
        add(btn1);
        add(btn2);
        add(btn3);
        add(lblPesqisar);
        add(lblPerfilFoto);
        add(txtPesqisar);
        // add(lblData);
        add(btnCadastroDeCliente);
        add(tabela);
        add(btnMeuPerfil);
        add(btnInformacaoPT);
        add(separador);
        add(btnExit);
        add(lblCategoria);

        //  crud 
        add(btnDadosDoCliente);

        add(lblLateralEsquerdoFundo);
        add(lblNomeDoFuncionario);
        add(lblBarraDeColocacaoDados1Fundo);
        add(lblBarraDeColocacaoDados2Fundo);
        add(lblBarraSuperiorFundo);
        add(lblBarraSuperiorContinuacaoFundo);

        // cadastro
        jMenuMaisInformacoes.add(jmiOpcaoInfoDoContador);
        jMenuMaisInformacoes.add(jmiOpcaoInfoDoPT);
        jMenuMaisInformacoes.add(jmiOpcaoInfoListarEquipe);
        jMenuMaisInformacoes.add(jmiOpcaoInfoDoFuncionario);
        jMenuMaisInformacoes.add(jmiOpcaoInfoEquipe);
        jMenuMaisInformacoes.add(jmiOpcaoInfoEquipamentos);
        // barra
        setJMenuBar(barraDeMenu);
        // adicionar a barra
        barraDeMenu.add(jMenuMaisInformacoes);
        barraDeMenu.add(JmenuRelatorio);
        barraDeMenu.setBackground(Color.WHITE);

        btnExit.addActionListener(this);
        btnCadastroDeCliente.addActionListener(this);
        btnDadosDoCliente.addActionListener(this);

        btnCadastroDeCliente.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent me) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                super.mouseClicked(me);
                btnCadastroDeCliente.setBackground(tangerine);
                btnInformacaoPT.setBackground(tangerine);
                btnMeuPerfil.setBackground(tangerine);
                btnDadosDoCliente.setBackground(tangerine);
            }

            @Override
            public void mouseExited(MouseEvent me) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                super.mouseClicked(me);
                btnCadastroDeCliente.setBackground(pumpikin);
                btnInformacaoPT.setBackground(pumpikin);
                btnMeuPerfil.setBackground(pumpikin);
                btnDadosDoCliente.setBackground(pumpikin);
            }

        });

    } // metodo  que adciona infomacos na tela de de usuario. 

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnExit) {

            int SimOuNao = JOptionPane.showConfirmDialog(null, "Tem a certeza  de que queres terminar a sessao?", " Terminar a Sessao? ", JOptionPane.YES_NO_OPTION);
            if (SimOuNao == 0) {
                dispose();
                new TelaLogin().gui();
            } else {
                dispose();
                new TelaDeFuncionarios().gui();

            }

        }

        if (e.getSource() == btnCadastroDeCliente) {
            dispose();
            new TelaCadastarCliente().Tela();

        }

        if (e.getSource() == btnDadosDoCliente) {
            JOptionPane.showInputDialog(" Digite o nome ou Nº De Contaddor: ");

        }

    }

    public static void main(String[] args) {

        new TelaDeFuncionarios().gui();

    }//  Metodo

}
