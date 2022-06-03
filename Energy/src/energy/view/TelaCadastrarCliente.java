package energy.view;

import com.toedter.calendar.JDateChooser;
import energy.controller.ClienteController;
import energy.controller.ContadorController;
import energy.model.PedidoDeNovosContratos;
import energy.model.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.text.MaskFormatter;

public class TelaCadastrarCliente extends JFrame implements ActionListener {

    Usuario usuario;

    JLabel lblCodigoDoCliente = new JLabel("Código do Cliente");
    JTextField txtCodigoDoCliente = new JTextField();

    JLabel lblNome = new JLabel("Nome (e outros)");
    JTextField txtNome = new JTextField();

    JLabel lblApelido = new JLabel("Apelido");
    JTextField txtApelido = new JTextField();

    JLabel lblMorada = new JLabel("Morada");
    JTextField txtMorada = new JTextField();

    JLabel lblEmail = new JLabel("Email");
    JTextField txtEmail = new JTextField();

    JLabel lblNUIT = new JLabel("NUIT");
    JTextField txtNUIT = new JTextField();

    JLabel lblNoBI = new JLabel("No BI");
    JTextField txtNoBI = new JTextField();

    JLabel lblNumeroDeContador = new JLabel("Número de Contador");
    JTextField txtNumeroDeContador = new JTextField();

    JLabel lblDataDeNascimento = new JLabel("Data de Nascimento");

    JDateChooser JDataFormatada = new JDateChooser();
    MaskFormatter MascaraData = null;

    JLabel lblProfissao = new JLabel("Profissão");
    JTextField txtProfissao = new JTextField();

    JLabel lblContacto = new JLabel("Contacto");
    JTextField txtContacto = new JTextField();

    JLabel lblContactoAlternativo = new JLabel("Contacto Alternativo");
    JTextField txtContactoAlternativo = new JTextField();

    JButton btnSalvar = new JButton("SALVAR");
    JButton btnCancelar = new JButton("CANCELAR");
    JButton btnVoltar = new JButton("VOLTAR");

    JLabel lblSexo = new JLabel("Sexo");
    JRadioButton rbSexoMasculino = new JRadioButton("Masculino");
    JRadioButton rbSexoFeminino = new JRadioButton("Feminino");

    ButtonGroup bgSexo = new ButtonGroup();

    JLabel lblEstadoCivil = new JLabel("Estado Civil");
    JComboBox<String> cbEstadoCivil = new JComboBox<>();


    JButton btnMudarCorLaranja = new JButton();
    JButton btnMudarCorBranco = new JButton();

    JLabel lblMudarFundo = new JLabel("Mudar Tema");

    Color colorOrange = new Color(248, 114, 23);
    Color tangerine = new Color(255, 185, 57);

    JLabel lblBarraLateralEsquerdo = new JLabel();

    JLabel lblBarraDeCadastro = new JLabel(" Cadastro ");
    JFormattedTextField jFormattedTextData;

    public TelaCadastrarCliente() {

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(989, 612); // 
        setVisible(true);
        setTitle("Cadastrar Clientes");
        setResizable(false);
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

    public void preencherDadosNosCampos(PedidoDeNovosContratos pedidoDeNovosContratos, Usuario usuario){
        this.usuario = usuario;

        this.Tela(usuario);

        txtNome.setText(pedidoDeNovosContratos.getNomeDoCliente());
        txtContacto.setText(String.valueOf(pedidoDeNovosContratos.getContacto()));
        txtEmail.setText(pedidoDeNovosContratos.getEmail());
        JDataFormatada.setDate(pedidoDeNovosContratos.getDataDeNascimento());
        txtMorada.setText(pedidoDeNovosContratos.getLocalizacaoDaCasa() + " Casa " + pedidoDeNovosContratos.getNumeroDaCasa());

    }

    public void Tela(Usuario usuario) {
        this.usuario = usuario;
        setLayout(null);

        lblCodigoDoCliente.setBounds(20, 40, 120, 30);
        txtCodigoDoCliente.setBounds(155, 40, 120, 30);

        Font fontes = new Font("Mongolian Baiti", Font.ITALIC, 32);
        Color cores = new Color(0, 0, 0);
        lblBarraDeCadastro.setBounds(500, 20, 140, 30); //  devo ver layout. 
        lblBarraDeCadastro.setFont(fontes);
        lblBarraDeCadastro.setBackground(tangerine);
        lblBarraDeCadastro.setOpaque(true);

        lblBarraLateralEsquerdo.setBounds(0, 0, 140, 612);
        lblBarraLateralEsquerdo.setBackground(Color.white); // menu
        lblBarraLateralEsquerdo.setOpaque(true);

        lblNome.setBounds(20, 170, 120, 25);
        txtNome.setBounds(155, 170, 270, 25);

        lblApelido.setBounds(20, 130, 120, 25);
        txtApelido.setBounds(155, 130, 270, 25);

        lblMorada.setBounds(20, 210, 210, 25);
        txtMorada.setBounds(155, 210, 270, 25);

        lblProfissao.setBounds(450, 280, 100, 25);
        txtProfissao.setBounds(610, 280, 130, 25);

        lblEmail.setBounds(20, 250, 120, 25);
        txtEmail.setBounds(155, 250, 270, 25);

        lblNUIT.setBounds(20, 295, 120, 25);
        txtNUIT.setBounds(155, 295, 270, 25);

        lblNoBI.setBounds(20, 340, 120, 25);
        txtNoBI.setBounds(155, 340, 270, 25);

        lblNumeroDeContador.setBounds(20, 385, 120, 25);
        txtNumeroDeContador.setBounds(155, 385, 270, 25);

        lblSexo.setBounds(450, 195, 55, 25);
        rbSexoMasculino.setBounds(610, 195, 90, 25);
        rbSexoFeminino.setBounds(715, 195, 80, 25);

        lblEstadoCivil.setBounds(450, 320, 120, 25);
        cbEstadoCivil.setBounds(610, 320, 120, 25);

        lblDataDeNascimento.setBounds(450, 240, 130, 25);
        JDataFormatada.setBounds(610, 240, 130, 25);

        lblContacto.setBounds(20, 430, 120, 25);
        txtContacto.setBounds(155, 430, 120, 25);

        lblContactoAlternativo.setBounds(340, 430, 120, 25);
        txtContactoAlternativo.setBounds(475, 430, 120, 25);

        btnSalvar.setBounds(580, 540, 100, 24);
        btnCancelar.setBounds(700, 540, 100, 24);
        btnVoltar.setBounds(820, 540, 100, 25);

        lblMudarFundo.setBounds(20, 485, 100, 30);
        btnMudarCorBranco.setBounds(150, 485, 30, 30);
        btnMudarCorLaranja.setBounds(190, 485, 30, 30);
        btnMudarCorLaranja.setBackground(new Color(255, 90, 0));
        btnMudarCorBranco.setBackground(Color.white);


        add(lblNome);
        add(lblApelido);
        add(lblMorada);
        add(lblEmail);
        add(lblNUIT);
        add(lblNoBI);
        add(lblNumeroDeContador);
        add(lblEstadoCivil);
        add(lblContacto);
        add(txtContacto);
        add(txtContactoAlternativo);
        add(lblContactoAlternativo);
        add(lblMudarFundo);
        add(lblBarraDeCadastro);

        add(lblBarraLateralEsquerdo);
        add(txtNome);
        add(txtApelido);
        add(txtMorada);
        add(txtEmail);
        add(txtNUIT);
        add(txtNoBI);
        add(txtNumeroDeContador);
        add(lblDataDeNascimento);

        add(lblProfissao);
        add(txtProfissao);

        add(btnSalvar);
        add(btnCancelar);
        add(btnVoltar);

        add(lblSexo);
        add(rbSexoFeminino);
        add(rbSexoMasculino);

        add(cbEstadoCivil);
        add(btnMudarCorBranco);
        add(btnMudarCorLaranja);

        add(JDataFormatada);

        bgSexo.add(rbSexoFeminino);
        bgSexo.add(rbSexoMasculino);


        cbEstadoCivil.addItem("Solteiro");
        cbEstadoCivil.addItem("Casado");
        cbEstadoCivil.addItem("Divorciado");
        cbEstadoCivil.addItem("Viúvo");

        btnMudarCorBranco.addActionListener(this);
        btnMudarCorLaranja.addActionListener(this);

        btnSalvar.addActionListener(this);
        btnVoltar.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnMudarCorLaranja) {
            getContentPane().setBackground(tangerine);
            lblBarraLateralEsquerdo.setBackground(Color.WHITE);
            lblBarraDeCadastro.setBackground(tangerine);
            
        }

        if (e.getSource() == btnMudarCorBranco) {
            getContentPane().setBackground(Color.white);
            lblBarraLateralEsquerdo.setBackground(tangerine);
            lblBarraDeCadastro.setBackground(Color.WHITE);
        }

        String sexo = "0";




        if (e.getSource() == btnSalvar) {

            if (rbSexoMasculino.isSelected()) {
                sexo = "M";
            }
            if(rbSexoFeminino.isSelected()){
                sexo = "F";
            }

            boolean sucessoCadastrarCliente, sucessoCadastrarContador;

            try{


                ContadorController contadorController = new ContadorController();
                sucessoCadastrarContador = contadorController.cadastarContador(Integer.parseInt(txtNumeroDeContador.getText()));


                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                String anoStr = formato.format(JDataFormatada.getDate());
                ClienteController clienteController = new ClienteController();
                sucessoCadastrarCliente = clienteController.cadastarCliente(txtNome.getText(), txtApelido.getText(), anoStr, cbEstadoCivil.getSelectedItem().toString(),
                        txtProfissao.getText(), txtMorada.getText(), txtEmail.getText(), txtNoBI.getText(), Integer.parseInt(txtContacto.getText()),
                        Integer.parseInt(txtContactoAlternativo.getText()), Integer.parseInt(txtNUIT.getText()), sexo, Integer.parseInt(txtNumeroDeContador.getText()));

                if(sucessoCadastrarCliente && sucessoCadastrarContador){
                    JOptionPane.showMessageDialog(null, "Cadastro feito com sucesso");
                }

                else {
                    JOptionPane.showMessageDialog(null, "Os campos não foram preenchidos devidamente", "Erro", JOptionPane.WARNING_MESSAGE);
                }

            }catch (Exception ex){
                JOptionPane.showMessageDialog(null, "Erro " + ex, "Erro", JOptionPane.WARNING_MESSAGE);
            }



        }

        if(e.getSource() == btnVoltar){
            dispose();
            new TelaFuncionarioMenuCliente(usuario).telaMenuClienteFuncionario();
        }

    }



}
