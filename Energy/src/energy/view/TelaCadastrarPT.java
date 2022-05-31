package energy.view;

import energy.controller.PTController;
import energy.model.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCadastrarPT extends JFrame implements ActionListener {

    Usuario usuario;
    private JLabel lblNumeroDoPT = new JLabel("Numero de PT");
    private JTextField txtNumeroDoPt = new JTextField();

    private JLabel lblProvincia = new JLabel("Provincia");
    private JComboBox<String> cbbProvincia = new JComboBox<>();

    private JLabel lblCidade = new JLabel("Cidade");
    private JTextField txtCidade = new JTextField();

    private JLabel lblBairro = new JLabel("Bairro");
    private JTextField txtBairro = new JTextField();


    private JButton btnSalvar = new JButton("Salvar");
    private JButton btnLimpar = new JButton("Limpar");
    private JButton btnVoltar = new JButton("Voltar");

    private Color tangerine = new Color(255, 185, 57);


    public TelaCadastrarPT(Usuario usuario){
        this.usuario = usuario;
        setVisible(true);
        setResizable(false);
        setTitle("Cadastrar Contador");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(550, 400);
        setLayout(null);
        getContentPane().setBackground(tangerine);

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

    private void definirPosicaoDasComponentes(){
        lblNumeroDoPT.setBounds(40, 40, 100, 25);
        txtNumeroDoPt.setBounds(170, 40, 305, 25);
        lblProvincia.setBounds(40, 85, 100, 25);
        cbbProvincia.setBounds(170, 85, 305, 25);
        lblCidade.setBounds(40, 130, 100, 25);
        txtCidade.setBounds(170, 130, 305, 25);
        lblBairro.setBounds(40, 175, 100, 25);
        txtBairro.setBounds(170, 175, 305, 25);
        btnSalvar.setBounds(170, 220, 95, 25);
        btnLimpar.setBounds(275, 220, 95, 25);
        btnVoltar.setBounds(380, 220, 95, 25);
    }

    private void adicionarATelaAsComponentes(){
        add(lblNumeroDoPT);
        add(txtNumeroDoPt);
        add(lblCidade);
        add(txtCidade);
        add(lblProvincia);
        add(cbbProvincia);
        add(lblBairro);
        add(txtBairro);
        add(btnSalvar);
        add(btnVoltar);
        add(btnLimpar);
    }

    private void adicionarDadosAsComponentes(){
        cbbProvincia.addItem("Cabo Delegado");
        cbbProvincia.addItem("Niassa");
        cbbProvincia.addItem("Nampula");
        cbbProvincia.addItem("Zambézia");
        cbbProvincia.addItem("Tete");
        cbbProvincia.addItem("Manica");
        cbbProvincia.addItem("Sofala");
        cbbProvincia.addItem("Inhambane");
        cbbProvincia.addItem("Gaza");
        cbbProvincia.addItem("Maputo Provincia");
        cbbProvincia.addItem("Maputo Cidade");
    }

    private void adicionarComponentesAEscuta(){
        btnSalvar.addActionListener(this);
        btnLimpar.addActionListener(this);
        btnVoltar.addActionListener(this);
    }

    public void limparTela(){
        txtNumeroDoPt.setText("");
        cbbProvincia.setSelectedIndex(0);
        txtCidade.setText("");
        txtBairro.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnSalvar){
            cadastrarPT();
        }

        if(e.getSource() == btnLimpar){
            limparTela();
        }

        if(e.getSource() == btnVoltar){
            this.dispose();
            new TelaFuncionarioMenuPT(usuario).telaMenuClienteFuncionario();
        }
    }

    public void cadastrarPT(){
        boolean cadastradoComSucesso;

        try{
            PTController ptController = new PTController();
            cadastradoComSucesso = ptController.cadastrarPT(Integer.parseInt(txtNumeroDoPt.getText()), cbbProvincia.getSelectedItem().toString(), txtCidade.getText(), txtBairro.getText());
            if(cadastradoComSucesso){
                JOptionPane.showMessageDialog(null, "PT cadastrado com sucesso");
            }else{
                JOptionPane.showMessageDialog(null, "Preencha todos os campos");
            }

        }catch (Exception FormatNumberException){
            JOptionPane.showMessageDialog(null, "Digite um número válido para PT");
        }
    }

    public void telaCadastrarPT(){
        definirPosicaoDasComponentes();
        adicionarComponentesAEscuta();
        adicionarATelaAsComponentes();
        adicionarDadosAsComponentes();
    }

}
