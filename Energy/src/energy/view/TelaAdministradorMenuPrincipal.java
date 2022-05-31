package energy.view;

import energy.controller.ClassificacaoController;
import energy.controller.ReclamacaoController;
import energy.dao.ExceptionDAO;
import energy.model.Classificacao;
import energy.model.Reclamacao;
import energy.model.Usuario;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TelaAdministradorMenuPrincipal extends JFrame implements ActionListener/*, KeyListener*/ {

    Usuario usuario = null;
    JPanel panelPrincipal = new JPanel(null);
    JPanel panelLateralEsquerdo = new JPanel(null);

    JPanel panelInferiorDireito = new JPanel(null);

    JPanel panelSuperiorDireito = new JPanel(null);

    ImageIcon fotoDePerfil = new ImageIcon("src\\imagens\\icon\\user_1.png");
    JLabel lblPerfilFoto = new JLabel(fotoDePerfil);
    JLabel lblNomeDoFuncionario = new JLabel();
    JButton btnFuncionarios = new JButton("  Funcionarios ");

    JButton btnHome = new JButton("  Home ");
    JButton btnEquipasDeTrabalho = new JButton(" Equipes de Trabalho ");
    JButton btnRelatorio = new JButton(" Relatorio");
    ImageIcon exit = new ImageIcon("src\\imagens\\icon\\exit.png");
    JButton btnExit = new JButton(exit);
    JSeparator separador = new JSeparator();

    Color colorPumpikin = new Color(248, 144, 23);

    Color colorWhaet = new Color(255, 185, 57);

    Color colorPumPikinEscuro = new Color(253, 164, 67);


    JButton btnClassificacao = new JButton("Classificação");

    JButton btnReclamacao = new JButton("Reclamação");


    JButton btnResposta = new JButton("Resposta");

    JButton btnMensagem = new JButton("Mensagem");

    JTable tabela = new JTable(); // levar isso
    String[] colunasClassificacao = {"ID", "Nome de Cliente", "Número de Estrelas", "Comentario", "Equipa de Trabalho"};
    String [] colunasReclamacao = {"ID", "Nome do Cliente", "Email", "Anónimo", "Data de Envio", "Respondido"};

    DefaultTableModel model = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(final int row, final int column){
            return false;
        }
    };
    JScrollPane jScrollPane = new JScrollPane(tabela);

    JTextArea JCaixaDeREclamacao = new JTextArea();

    JLabel lblCaixaDeREclamacao = new JLabel("Caixa de reclamacao");

    public TelaAdministradorMenuPrincipal(Usuario usuario){
        this.usuario = usuario;
        this.lblNomeDoFuncionario.setText(usuario.getNome() + " " + usuario.getApelido());
        setSize(1130, 700);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Menu Principal");

        /* Permite com que a tela seja aberta no meio do ecrã
         * O método setLocationRelativeTo() não funcionava e por isso
         * Foi adoptado esse método
         */
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension tela = tk.getScreenSize();
        int alturaDaTela = tela.height;
        int larguraDaTela = tela.width;
        setLocation( (larguraDaTela - getWidth())/2, (alturaDaTela - getHeight())/2);
    }


    public void painelSuperiorDireito(){
        btnClassificacao.setBounds(600, 70, 120, 40);
        btnClassificacao.setBackground(colorPumpikin);

        btnReclamacao.setBounds(600, 140, 120, 40);
        btnReclamacao.setBackground(colorPumpikin);

        btnMensagem.setBounds(400, 70, 120, 40);
        btnMensagem.setBackground(colorPumpikin);

        btnResposta.setBounds(400, 140, 120, 40);

        JCaixaDeREclamacao.setBounds(30, 35, 300, 150);
        JCaixaDeREclamacao.setOpaque(false);
        JCaixaDeREclamacao.setBorder(new MatteBorder(2, 2, 2, 2, Color.white));
        lblCaixaDeREclamacao.setBounds(30, 10, 150, 30);
        JCaixaDeREclamacao.setForeground(Color.WHITE);


        btnResposta.setBackground(colorPumpikin);

        panelSuperiorDireito.add(JCaixaDeREclamacao);

        panelSuperiorDireito.add(btnClassificacao);
        panelSuperiorDireito.add(btnReclamacao);

        panelSuperiorDireito.add(btnMensagem);
        panelSuperiorDireito.add(btnResposta);
        panelSuperiorDireito.add(lblCaixaDeREclamacao);

        btnMensagem.setVisible(false);
        btnResposta.setVisible(false);
        JCaixaDeREclamacao.setVisible(false);
        lblCaixaDeREclamacao.setVisible(false);

        panelSuperiorDireito.setBackground(colorWhaet);


    }

    public void painelInferiorDireito(){
        jScrollPane.setBounds(30, 100, 700, 300);
        panelInferiorDireito.add(jScrollPane);
    }

    public void panelLateralEsquerdo(){

        panelLateralEsquerdo.setBackground(colorPumpikin);

        lblPerfilFoto.setBounds(30, 100, 60, 60);
        lblNomeDoFuncionario.setBounds(130, 100, 160, 30);

        btnExit.setBounds(220, 190, 35, 45);
        btnExit.setContentAreaFilled(false);// butto de JBexet.
        btnExit.setBorderPainted(false);

        btnHome.setBounds(0, 250, 272, 50);
        btnHome.setBackground(colorPumPikinEscuro);
        btnHome.setBorderPainted(false);

        btnFuncionarios.setBounds(0, 300, 272, 50);
        btnFuncionarios.setBackground(colorPumpikin);
        btnFuncionarios.setBorderPainted(false);

        btnEquipasDeTrabalho.setBounds(0, 350, 272, 50);
        btnEquipasDeTrabalho.setBackground(colorPumpikin);
        btnEquipasDeTrabalho.setBorderPainted(false);

        btnRelatorio.setBounds(0, 400, 272, 50);
        btnRelatorio.setBackground(colorPumpikin);
        btnRelatorio.setBorderPainted(false);

        separador.setBounds(20, 180, 240, 30);
        separador.setBackground(Color.WHITE);
        separador.setOrientation(SwingConstants.HORIZONTAL);

        panelLateralEsquerdo.add(lblPerfilFoto);
        panelLateralEsquerdo.add(lblNomeDoFuncionario);
        panelLateralEsquerdo.add(separador);
        panelLateralEsquerdo.add(btnExit);
        panelLateralEsquerdo.add(btnHome);
        panelLateralEsquerdo.add(btnFuncionarios);
        panelLateralEsquerdo.add(btnEquipasDeTrabalho);
        panelLateralEsquerdo.add(btnRelatorio);
    }

    public void definirPosicoes(){
        panelLateralEsquerdo.setBounds(0, 0, 275, 645);
        panelSuperiorDireito.setBounds(275, 0, 855, 220);
        panelInferiorDireito.setBounds(275, 220, 855, 425);
    }

    public void adicionarNaTela(){
        panelPrincipal.add(panelLateralEsquerdo);
        panelPrincipal.add(panelSuperiorDireito);
        panelPrincipal.add(panelInferiorDireito);

        panelPrincipal.setBounds(0, 0, 1050, 700);
        panelPrincipal.setBackground(colorPumpikin);
        add(panelPrincipal);
    }

    public void telaMenuPrincipalAdministrador(){
        panelLateralEsquerdo();
        painelSuperiorDireito();
        adicionarAComponenteAEscuta();
        definirPosicoes();
        adicionarNaTela();
    }

    public void adicionarAComponenteAEscuta(){
        btnFuncionarios.addActionListener(this);
        btnEquipasDeTrabalho.addActionListener(this);
        btnRelatorio.addActionListener(this);
        btnExit.addActionListener(this);
        btnClassificacao.addActionListener(this);
        btnReclamacao.addActionListener(this);
        btnMensagem.addActionListener(this);
        btnResposta.addActionListener(this);

        JCaixaDeREclamacao.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    int id = (Integer) tabela.getModel().getValueAt(tabela.getSelectedRow(), 0);
                    try {
                        ReclamacaoController reclamacaoController = new ReclamacaoController();
                        Reclamacao reclamacao = reclamacaoController.listarReclamacaoPorID(id);
                        reclamacao.setResposta(JCaixaDeREclamacao.getText());
                        reclamacao.setRespondido(true);
                        //Desaparecerá quando a parte android estiver bem
                        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                        Date data = formato.parse("07/02/2000");
                        reclamacao.setDataDeEnvio(data);
                        //Fim
                        boolean sucesso = new ReclamacaoController().responderMensagem(reclamacao);
                        if(sucesso){
                            JOptionPane.showMessageDialog(null, "Mensagem respondida com sucesso");
                        }else{
                            JOptionPane.showMessageDialog(null, "Erro ao responder mensagem");
                        }
                    }catch (ExceptionDAO ex){
                        Logger.getLogger(TelaAdministradorMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ParseException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

//    public static void main(String[] args) {
//        new TelaAdministradorMenuPrincipal().telaMenuPrincipalAdministrador();
//    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnFuncionarios){
            new TelaAdministradorMenuFuncionario(usuario).telaMenuPrincipalAdministrador();
            this.setVisible(false);
        }

        if (e.getSource() == btnExit) {

            int SimOuNao = JOptionPane.showConfirmDialog(null, "Tem a certeza  de que queres terminar a sessao?", " Terminar a Sessao? ", JOptionPane.YES_NO_OPTION);
            if (SimOuNao == 0) {
                dispose();
                new TelaLogin().gui();
            }

        }

        if(e.getSource() == btnEquipasDeTrabalho){
            new TelaAdministradorMenuEquipasDeTrabalho(usuario).telaMenuPrincipalAdministrador();
            this.dispose();
        }


        if(e.getSource() == btnRelatorio){
            new TelaAdministradorRelatorio(usuario).telaAdministradorMenuRelatorio();
            this.setVisible(false);
        }


        if(e.getSource() == btnClassificacao){
            btnMensagem.setVisible(false);
            btnResposta.setVisible(false);
            painelInferiorDireito();
            preencherDadosNaTabelaClassificacao();

        }

        if(e.getSource() == btnReclamacao){
            btnMensagem.setVisible(true);
            btnResposta.setVisible(true);

            painelInferiorDireito();
            preencherDadosNaTabelaReclamacao();

        }

        if(e.getSource() == btnMensagem){
            int id = (Integer) tabela.getModel().getValueAt(tabela.getSelectedRow(), 0);
            try {
                ReclamacaoController reclamacaoController = new ReclamacaoController();
                Reclamacao reclamacao = reclamacaoController.listarReclamacaoPorID(id);
                if(reclamacao.isAnonimo()){
                    reclamacao.setEmail("Anónimo");
                    reclamacao.setNomeDoCliente("");
                }
                lblCaixaDeREclamacao.setVisible(true);
                JCaixaDeREclamacao.setVisible(true);
                JCaixaDeREclamacao.setEditable(false);
                JCaixaDeREclamacao.setText(reclamacao.getMensagem());
            }catch (ExceptionDAO ex){
                Logger.getLogger(TelaAdministradorMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        if(e.getSource() == btnResposta){


            try {
                int id = (Integer) tabela.getModel().getValueAt(tabela.getSelectedRow(), 0);
                ReclamacaoController reclamacaoController = new ReclamacaoController();
                Reclamacao reclamacao = reclamacaoController.listarReclamacaoPorID(id);
                if(reclamacao.isAnonimo()){
                    reclamacao.setEmail("Anónimo");
                    reclamacao.setNomeDoCliente("");
                }

                lblCaixaDeREclamacao.setVisible(true);
                JCaixaDeREclamacao.setVisible(true);
                if(reclamacao.isRespondido()) {
                    JCaixaDeREclamacao.setText("");
                    JCaixaDeREclamacao.setEditable(false);
                    JCaixaDeREclamacao.setText(reclamacao.getResposta());
                }
                else{
                    JCaixaDeREclamacao.setText("");
                    JCaixaDeREclamacao.setEditable(true);

                }

            }catch (ExceptionDAO ex){
                Logger.getLogger(TelaAdministradorMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }

        }




    }

    public void mandarMensagem(){


    }

    public void preencherDadosNaTabelaClassificacao(){
        model.setColumnIdentifiers(colunasClassificacao);
        model.setRowCount(0);
        ClassificacaoController classificacaoController = new ClassificacaoController();

        try{
            ArrayList<Classificacao> classificacoes = classificacaoController.listarTodasClassificacoes();
            classificacoes.forEach((Classificacao classificacao) -> {
                model.addRow(new Object[] {
                        classificacao.getId(),
                        classificacao.getNomeDoCliente(),
                        classificacao.getNumeroDeEstrelas(),
                        classificacao.getComentario(),
                        classificacao.getNumeroDaEquipa()
                });
            });
            tabela.setModel(model);

        }catch (ExceptionDAO e){
            Logger.getLogger(TelaAdministradorMenuPrincipal.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void preencherDadosNaTabelaReclamacao(){
        model.setColumnIdentifiers(colunasReclamacao);
        model.setRowCount(0);
        ReclamacaoController reclamacaoController = new ReclamacaoController();

        try{
            ArrayList<Reclamacao> reclamacoes = reclamacaoController.listarTodasReclamacoes();
            for(int i = 0; i < reclamacoes.size(); i++){
                if(reclamacoes.get(i).isAnonimo()){
                    reclamacoes.get(i).setNomeDoCliente("Anónimo");
                    reclamacoes.get(i).setEmail("Anónimo");
                }
            }
            reclamacoes.forEach((Reclamacao reclamacao) -> {
                model.addRow(new Object[] {
                        reclamacao.getId(),
                        reclamacao.getNomeDoCliente(),
                        reclamacao.getEmail(),
                        reclamacao.isAnonimo(),
                        reclamacao.getDataDeEnvio(),
                        reclamacao.isRespondido()
                });
            });
            tabela.setModel(model);

        }catch (ExceptionDAO e){
            Logger.getLogger(TelaAdministradorMenuPrincipal.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}
