package energy.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCadastrarContador extends JFrame implements ActionListener {

    JLabel lblProprietaro = new JLabel("Proprietário");
    JLabel lblNomeDoProprietario = new JLabel();

    JLabel lblNumeroDeContador = new JLabel("No de Contador");
    JTextField txtNumeroDeContador = new JTextField();

    JLabel lblProvincia = new JLabel("Provincia");
    JComboBox<String> cbbProvincia = new JComboBox<>();

    JLabel lblCidade = new JLabel("Cidade");
    JTextField txtCidade = new JTextField();

    JLabel lblBairro = new JLabel("Bairro");
    JTextField txtBairro = new JTextField();

    JLabel lblCasa = new JLabel("Casa");
    JTextField txtCasa = new JTextField();

    JButton btnSalvar = new JButton("Salvar");
    JButton btnLimpar = new JButton("Limpar");
    JButton btnCancelar = new JButton("Cancelar");

    Color tangerine = new Color(255, 185, 57);

    public TelaCadastrarContador(){
        setVisible(true);
        setResizable(false);
        setTitle("Cadastrar Contador");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 450);
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
        lblProprietaro.setBounds(40, 40, 100, 25);
        lblNomeDoProprietario.setBounds(170, 40, 305, 25);
        lblNumeroDeContador.setBounds(40, 85, 100, 25);
        txtNumeroDeContador.setBounds(170, 85, 305, 25);
        lblProvincia.setBounds(40, 130, 100, 25);
        cbbProvincia.setBounds(170, 130, 305, 25);
        lblCidade.setBounds(40, 175, 100, 25);
        txtCidade.setBounds(170, 175, 305, 25);
        lblBairro.setBounds(40, 220, 100, 25);
        txtBairro.setBounds(170, 220, 305, 25);
        lblCasa.setBounds(40, 265, 100, 25);
        txtCasa.setBounds(170, 265, 305, 25);
        btnSalvar.setBounds(170, 310, 95, 25);
        btnLimpar.setBounds(275, 310, 95, 25);
        btnCancelar.setBounds(380, 310, 95, 25);
    }

    private void adicionarATelaAsComponentes(){
        add(lblProprietaro);
        add(lblNomeDoProprietario);
        add(lblNumeroDeContador);
        add(txtNumeroDeContador);
        add(lblCidade);
        add(txtCidade);
        add(lblProvincia);
        add(cbbProvincia);
        add(lblBairro);
        add(txtBairro);
        add(lblCasa);
        add(txtCasa);
        add(btnSalvar);
        add(btnCancelar);
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
        btnCancelar.addActionListener(this);
    }

    private void limparTela(){
        txtNumeroDeContador.setText("");
        cbbProvincia.setSelectedIndex(0);
        txtCidade.setText("");
        txtBairro.setText("");
        txtCasa.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == btnSalvar){

        }

        if(e.getSource() == btnLimpar){
            limparTela();
        }
        if(e.getSource() == btnCancelar){

        }
    }

    public void telaCadastrarContador(){
        definirPosicaoDasComponentes();
        adicionarComponentesAEscuta();
        adicionarATelaAsComponentes();
        adicionarDadosAsComponentes();

    }



    public static void main(String[] args) {
        new TelaCadastrarContador().telaCadastrarContador();
    }
}
