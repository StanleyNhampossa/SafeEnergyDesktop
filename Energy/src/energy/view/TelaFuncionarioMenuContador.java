package energy.view;

import energy.controller.ClienteController;
import energy.controller.ContadorController;
import energy.dao.ExceptionDAO;
import energy.model.Cliente;
import energy.model.Contador;
import energy.model.Usuario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TelaFuncionarioMenuContador extends JFrame implements ActionListener {

    Usuario usuario;

    JPanel panelPrincipal = new JPanel(null);
    JPanel panelLateralEsquerdo = new JPanel(null);

    JPanel panelInferiorDireito = new JPanel(null);

    JPanel panelSuperiorDireito = new JPanel(null);

    ImageIcon fotoDePerfil = new ImageIcon("src\\imagens\\icon\\user_1.png");
    JLabel lblPerfilFoto = new JLabel(fotoDePerfil);
    JLabel lblNomeDoFuncionario = new JLabel("Funcionarios");
    JButton btnCliente = new JButton("  Cliente ");

    JButton btnHome = new JButton("  Home ");
    JButton btnContador = new JButton(" Contador ");
    JButton btnPT = new JButton(" PT");
    ImageIcon exit = new ImageIcon("src\\imagens\\icon\\exit.png");
    JButton btnExit = new JButton(exit);
    JSeparator separador = new JSeparator();

    Color colorPumpikin = new Color(248, 144, 23);

    Color colorWhaet = new Color(255, 185, 57);

    Color colorPumPikinEscuro = new Color(253, 164, 67);

    ImageIcon fundolistar = new ImageIcon("src\\imagens\\icon\\listar.png");

    ImageIcon fundoAdd = new ImageIcon("src\\imagens\\icon\\add.png");

    JButton btnCadastrar = new JButton("Cadastar", fundoAdd);

    JButton btnListar = new JButton("Listar", fundolistar);

    ImageIcon fundoDeletar = new ImageIcon("src\\imagens\\icon\\delete.png");

    JButton btnDeletar = new JButton("Deletar", fundoDeletar);

    JButton btnActualizar = new JButton("Actualizar");

    JTable tabela = new JTable(); // levar isso
    String[] colunas = {"Número de Contador", "Proprietário", "Provincia", "Cidade", "Bairro"};
    DefaultTableModel model = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(final int row, final int column){
            return false;
        }
    };
    JScrollPane jScrollPane = new JScrollPane(tabela);

    TelaEditarFuncionario telaEditarFuncionario;

    public TelaFuncionarioMenuContador(Usuario usuario){
        this.usuario = usuario;
        lblNomeDoFuncionario.setText(usuario.getNome() + " " + usuario.getApelido());
        setSize(1130, 700);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Menu Contador");

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
        panelSuperiorDireito.setBackground(colorWhaet);

        btnCadastrar.setBounds(400, 70, 120, 40);
        btnCadastrar.setBackground(colorPumpikin);

        btnListar.setBounds(400, 140, 120, 40);
        btnListar.setBackground(colorPumpikin);

        btnActualizar.setBounds(600, 70, 120, 40);
        btnActualizar.setBackground(colorPumpikin);

        btnDeletar.setBounds(600, 140, 120, 40);
        btnDeletar.setBackground(colorPumpikin);

        panelSuperiorDireito.add(btnCadastrar);
        panelSuperiorDireito.add(btnListar);
        panelSuperiorDireito.add(btnActualizar);
        panelSuperiorDireito.add(btnDeletar);


    }

    public void painelInferiorDireito(){

        jScrollPane.setBounds(30, 100, 700, 300);
        model.setColumnIdentifiers(colunas);
        preencherTodosDadosTabela();
        panelInferiorDireito.add(jScrollPane);
    }


    public void preencherTodosDadosTabela(){
        model.setRowCount(0);
        ContadorController contadorController = new ContadorController();

        //Ele tenta preencher a tabela com dados da base de dados
        try{
            ArrayList<Contador> contadores = contadorController.listarTodosContadores();
            contadores.forEach((Contador contador) -> {
                model.addRow(new Object[] {
                        contador.getNumeroDeContador(),
                        contador.getProprietario().getNome() + " " + contador.getProprietario().getApelido(),
                        contador.getProvincia(),
                        contador.getCidade(),
                        contador.getBairro(),
                        contador.getCasa()
                });
            });
            tabela.setModel(model);
        }catch (ExceptionDAO e){
            Logger.getLogger(TelaFuncionarioMenuContador.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void panelLateralEsquerdo(){

        panelLateralEsquerdo.setBackground(colorPumpikin);

        lblPerfilFoto.setBounds(30, 100, 60, 60);
        lblNomeDoFuncionario.setBounds(130, 100, 160, 30);

        btnExit.setBounds(220, 190, 35, 45);
        btnExit.setContentAreaFilled(false);// butto de JBexet.
        btnExit.setBorderPainted(false);

        btnHome.setBounds(0, 250, 272, 50);
        btnHome.setBackground(colorPumpikin);
        btnHome.setBorderPainted(false);

        btnCliente.setBounds(0, 300, 272, 50);
        btnCliente.setBackground(colorPumpikin);
        btnCliente.setBorderPainted(false);

        btnContador.setBounds(0, 350, 272, 50);
        btnContador.setBackground(colorPumPikinEscuro);
        btnContador.setBorderPainted(false);

        btnPT.setBounds(0, 400, 272, 50);
        btnPT.setBackground(colorPumpikin);
        btnPT.setBorderPainted(false);

        separador.setBounds(20, 180, 240, 30);
        separador.setBackground(Color.WHITE);
        separador.setOrientation(SwingConstants.HORIZONTAL);

        panelLateralEsquerdo.add(lblPerfilFoto);
        panelLateralEsquerdo.add(lblNomeDoFuncionario);
        panelLateralEsquerdo.add(separador);
        panelLateralEsquerdo.add(btnExit);
        panelLateralEsquerdo.add(btnHome);
        panelLateralEsquerdo.add(btnCliente);
        panelLateralEsquerdo.add(btnContador);
        panelLateralEsquerdo.add(btnPT);
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

    public void telaMenuClienteFuncionario(){
        panelLateralEsquerdo();
        painelSuperiorDireito();
        adicionarAComponenteAEscuta();
        definirPosicoes();
        adicionarNaTela();
    }

    public void adicionarAComponenteAEscuta(){
        btnExit.addActionListener(this);
        btnContador.addActionListener(this);
        btnHome.addActionListener(this);
        btnPT.addActionListener(this);
        btnListar.addActionListener(this);
        btnCadastrar.addActionListener(this);
        btnDeletar.addActionListener(this);
        btnActualizar.addActionListener(this);
        btnCliente.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnHome){
            new TelaFuncionarioMenuPrincipal(usuario).telaMenuClienteFuncionario();
            this.setVisible(false);
        }

        if(e.getSource() == btnPT){
            new TelaFuncionarioMenuPT(usuario).telaMenuClienteFuncionario();
            this.setVisible(false);
        }

        if(e.getSource() == btnCliente){
            new TelaFuncionarioMenuCliente(usuario).telaMenuClienteFuncionario();
            this.setVisible(false);
        }


        if (e.getSource() == btnExit) {

            int SimOuNao = JOptionPane.showConfirmDialog(null, "Tem a certeza  de que queres terminar a sessao?", " Terminar a Sessao? ", JOptionPane.YES_NO_OPTION);
            if (SimOuNao == 0) {
                dispose();
                new TelaLogin().gui();
            }

        }

        if(e.getSource() == btnListar){
            painelInferiorDireito();
        }

        if(e.getSource() == btnCadastrar){
            dispose();
            new TelaCadastrarCliente().Tela(usuario);
        }

        if(e.getSource() == btnDeletar){

            JOptionPane.showMessageDialog(null, "Não tem permissão para remover um cliente");
//            int id = (Integer) tabela.getModel().getValueAt(tabela.getSelectedRow(), 0);
//            boolean isDelected;
//
//            FuncionarioController funcionarioController = new FuncionarioController();
//            try {
//                isDelected = funcionarioController.deletarFuncionario(id);
//                if(isDelected) {
//                    JOptionPane.showMessageDialog(null, "Funcionário deletado com sucesso");
//                    model.removeRow(tabela.getSelectedRow());
//                }else
//                    JOptionPane.showMessageDialog(null, "Erro ao deletar funcionário");
//            }catch (ExceptionDAO ex){
//                Logger.getLogger(TelaAdministradorMenuFuncionario.class.getName()).log(Level.SEVERE, null, ex);
//
//            }
        }

        if(e.getSource() == btnActualizar){
//            tabela.addMouseListener(new MouseAdapter() {
//                @Override
//                public void mouseClicked(MouseEvent e) {
//                    super.mouseClicked(e);
//                    jTabelaListarFuncionario(e);
//                }
//            });
            actualizarContador();

        }
    }

    public void actualizarContador(){
        int id = (Integer) tabela.getModel().getValueAt(tabela.getSelectedRow(), 0);


        ContadorController contadorController = new ContadorController();
        try {
            Contador contador = contadorController.listarContadorPorID(id);
            dispose();
            new TelaEditarContador().preencherCamposDaTela(usuario, contador);
        }catch (ExceptionDAO ex){
            Logger.getLogger(TelaAdministradorMenuFuncionario.class.getName()).log(Level.SEVERE, null, ex);

        }
    }




}
