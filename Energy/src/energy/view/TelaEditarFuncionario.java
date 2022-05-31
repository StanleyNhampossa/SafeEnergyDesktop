package energy.view;

import com.toedter.calendar.JDateChooser;
import energy.controller.ASCController;
import energy.controller.FuncionarioController;
import energy.dao.ExceptionDAO;
import energy.model.AreaDeServicoAoCliente;
import energy.model.Funcionario;
import energy.model.Usuario;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;

public class TelaEditarFuncionario extends JFrame implements ActionListener {


    Usuario usuario;

    private JLabel lblNome = new JLabel("Nome (e outros)");
    private JTextField txtNome = new JTextField();

    private JLabel lblApelido = new JLabel("Apelido");
    private JTextField txtApelido = new JTextField();

    private JLabel lblMorada = new JLabel("Morada");
    private JTextField txtMorada = new JTextField();

    private JLabel lblEmail = new JLabel("Email");
    private JTextField txtEmail = new JTextField();

    private JLabel lblNUIT = new JLabel("NUIT");
    private JTextField txtNUIT = new JTextField();

    private JLabel lblNoBI = new JLabel("No BI");
    private JTextField txtNoBI = new JTextField();

    private JLabel lblDataDeNascimento = new JLabel("Data de Nascimento");
    private MaskFormatter MascaraData = null;

    JDateChooser JDataFormatada = new JDateChooser();

    private JLabel lblProfissao = new JLabel("Profissão");
    private JTextField txtProfissao = new JTextField();

    private JLabel lblContacto = new JLabel("Contacto");
    private JTextField txtContacto = new JTextField();

    private JLabel lblContactoAlternativo = new JLabel("Contacto Alternativo");
    private JTextField txtContactoAlternativo = new JTextField();

    private JButton btnSalvar = new JButton("SALVAR");
    private JButton btnLimpar = new JButton("Limpar");
    private JButton btnVoltar = new JButton("VOLTAR");

    private JLabel lblSexo = new JLabel("Sexo");
    private JRadioButton rbSexoMasculino = new JRadioButton("Masculino");
    private JRadioButton rbSexoFeminino = new JRadioButton("Feminino");
    private ButtonGroup bgSexo = new ButtonGroup();

    private JLabel lblEstadoCivil = new JLabel("Estado Civil");
    private JComboBox<String> cbEstadoCivil = new JComboBox<>();

    private JButton btnMudarCorLaranja = new JButton();
    private JButton btnMudarCorBranco = new JButton();

    private JLabel lblMudarFundo = new JLabel("Mudar Tema");

    private Color colorOrange = new Color(248, 114, 23);
    private Color tangerine = new Color(255, 185, 57);

    private JLabel lblBarraLateralEsquerdo = new JLabel();
    private JLabel lblEditar = new JLabel(" Editar ");

    private JFormattedTextField jftdDataDeNascimento;

    private int numeroDoFuncionario;

    private JLabel lblCategoria = new JLabel("Categoria");
    private JComboBox<String> cbCategoria = new JComboBox<>();

    private JLabel lblAreaDeServico = new JLabel("Área de Serviço");
    private JComboBox<AreaDeServicoAoCliente> cbAreaDeServico = new JComboBox<>();

    public TelaEditarFuncionario() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(989, 612); //
//        setVisible(true);
        setTitle("Cadastrar Funcionários");
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

    public void buscarFuncionario(Funcionario funcionario, Usuario usuario){
        this.usuario = usuario;
        this.Tela(this.usuario);
        for(int i = 0; i < cbAreaDeServico.getItemCount(); i++){
            if(cbAreaDeServico.getItemAt(i).equals(funcionario.getLocalDeTrabalho().getAreaDeServico())) {
                cbAreaDeServico.setSelectedIndex(i);
            }
        }

        for(int i = 0; i < cbCategoria.getItemCount(); i++) {
            if (cbCategoria.getItemAt(i).equals(funcionario.getCategoria())){
                cbCategoria.setSelectedIndex(i);
            }
        }

        for(int i = 0; i < cbEstadoCivil.getItemCount(); i++){
            if(cbEstadoCivil.getItemAt(i).equals(funcionario.getEstadoCivil()))
                cbEstadoCivil.setSelectedIndex(i);
        }

        this.numeroDoFuncionario = funcionario.getNumeroDeFuncionario();
        this.txtNome.setText(funcionario.getNome());
        this.txtApelido.setText(funcionario.getApelido());
        this.txtContacto.setText(String.valueOf(funcionario.getContacto()));
        this.txtContactoAlternativo.setText(String.valueOf(funcionario.getContactoAlternativo()));
        this.txtEmail.setText(funcionario.getEmail());
        this.txtMorada.setText(funcionario.getMorada());
        this.txtNoBI.setText(funcionario.getNumeroDeBI());
        this.txtNUIT.setText(String.valueOf(funcionario.getNuit()));
        this.txtProfissao.setText(funcionario.getProfissao());
        this.JDataFormatada.setDate(funcionario.getDataDeNascimento());
        if(funcionario.getGenero().equalsIgnoreCase("M"))
            rbSexoMasculino.setSelected(true);
        else
            rbSexoFeminino.setSelected(true);



        this.setVisible(true);
    }

    public void Tela(Usuario usuarioActual) {
        usuario = usuarioActual;
        setLayout(null);

        Font fontes = new Font("Mongolian Baiti", Font.ITALIC, 32);
        Color cores = new Color(0, 0, 0);

        //Definindo as posições de cada componente na tela

        lblEditar.setBounds(500, 20, 140, 30); //  devo ver layout.
        lblEditar.setFont(fontes);
        lblEditar.setBackground(tangerine);
        lblEditar.setOpaque(true);

        lblBarraLateralEsquerdo.setBounds(0, 0, 140, 612);
        lblBarraLateralEsquerdo.setBackground(Color.white); // menu
        lblBarraLateralEsquerdo.setOpaque(true);

        lblCategoria.setBounds(450, 130, 120, 25);
        cbCategoria.setBounds(610, 130, 120, 25);

        lblNome.setBounds(20, 170, 120, 25);
        txtNome.setBounds(155, 170, 270, 25);

        lblApelido.setBounds(20, 130, 120, 25);
        txtApelido.setBounds(155, 130, 270, 25);

        lblMorada.setBounds(20, 210, 210, 25);
        txtMorada.setBounds(155, 210, 270, 25);

        lblProfissao.setBounds(450, 250, 100, 25);
        txtProfissao.setBounds(610, 250, 130, 25);

        lblEmail.setBounds(20, 250, 120, 25);
        txtEmail.setBounds(155, 250, 270, 25);

        lblNUIT.setBounds(20, 295, 120, 25);
        txtNUIT.setBounds(155, 295, 270, 25);

        lblNoBI.setBounds(20, 340, 120, 25);
        txtNoBI.setBounds(155, 340, 270, 25);

        lblAreaDeServico.setBounds(450, 340, 120, 25);
        cbAreaDeServico.setBounds(610, 340, 150, 25);

        lblSexo.setBounds(450, 170, 55, 25);
        rbSexoMasculino.setBounds(610, 170, 90, 25);
        rbSexoFeminino.setBounds(715, 170, 80, 25);

        lblEstadoCivil.setBounds(450, 295, 120, 25);
        cbEstadoCivil.setBounds(610, 295, 120, 25);

        lblContacto.setBounds(20, 385, 120, 25);
        txtContacto.setBounds(155, 385, 120, 25);

        lblContactoAlternativo.setBounds(340, 385, 120, 25);
        txtContactoAlternativo.setBounds(475, 385, 120, 25);

        lblDataDeNascimento.setBounds(450, 210, 130, 25);
        JDataFormatada.setBounds(610, 210, 130, 25);

        btnSalvar.setBounds(580, 540, 100, 24);
        btnLimpar.setBounds(700, 540, 100, 24);
        btnVoltar.setBounds(820, 540, 100, 25);

        lblMudarFundo.setBounds(20, 485, 100, 30);
        btnMudarCorBranco.setBounds(150, 485, 30, 30);
        btnMudarCorLaranja.setBounds(190, 485, 30, 30);
        btnMudarCorLaranja.setBackground(new Color(255, 90, 0));
        btnMudarCorBranco.setBackground(Color.white);

        //Termina de definir as posições das componentes a tela


        //Adicionando as Labels a tela
        add(lblNome);
        add(lblApelido);
        add(lblMorada);
        add(lblEmail);
        add(lblNUIT);
        add(lblNoBI);
        add(lblEstadoCivil);
        add(lblContacto);
        add(lblContactoAlternativo);
        add(lblMudarFundo);
        add(lblEditar);
        add(lblCategoria);
        add(lblDataDeNascimento);
        add(lblProfissao);
        add(lblSexo);
        add(lblAreaDeServico);
        add(lblBarraLateralEsquerdo);

        //Adicionando as Textfields a tela
        add(txtContacto);
        add(txtContactoAlternativo);
        add(txtNome);
        add(txtApelido);
        add(txtMorada);
        add(txtEmail);
        add(txtNUIT);
        add(txtNoBI);
        add(txtProfissao);

        //Adicionando os RadioButton a tela
        add(rbSexoFeminino);
        add(rbSexoMasculino);

        //Adicionando as ComboBox a tela
        add(cbCategoria);
        add(cbAreaDeServico);
        add(cbEstadoCivil);

        //Adicionando os botões a tela
        add(btnMudarCorBranco);
        add(btnMudarCorLaranja);
        add(btnSalvar);
        add(btnLimpar);
        add(btnVoltar);

        add(JDataFormatada);

        //Adicionando os sexos masculino e feminino ao Group Button
        bgSexo.add(rbSexoFeminino);
        bgSexo.add(rbSexoMasculino);


        //Preenchendo dados da ComboBox de Estado Civil
        cbEstadoCivil.addItem("Solteiro");
        cbEstadoCivil.addItem("Casado");
        cbEstadoCivil.addItem("Divorciado");
        cbEstadoCivil.addItem("Viúvo");

        //Preenchendo dados na ComboD=Box de Categoria
        cbCategoria.addItem("Corpo Técnico");
        cbCategoria.addItem("Administrador");


        //Preenche os dados na combobox da Área de Serviço
        try {
            List<AreaDeServicoAoCliente> listarAServC = new ASCController().listarASC();
            for(AreaDeServicoAoCliente asc : listarAServC){
                cbAreaDeServico.addItem(asc);
            }
        } catch (ExceptionDAO e) {
            e.printStackTrace();
        }
        //Termina de preencher dados na combobox


        //Dando vida aos botões
        btnMudarCorBranco.addActionListener(this);
        btnMudarCorLaranja.addActionListener(this);
        btnSalvar.addActionListener(this);
        btnVoltar.addActionListener(this);
        btnLimpar.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnMudarCorLaranja) {
            getContentPane().setBackground(tangerine);
            lblBarraLateralEsquerdo.setBackground(Color.WHITE);
            lblEditar.setBackground(tangerine);

        }

        if (e.getSource() == btnMudarCorBranco) {
            getContentPane().setBackground(Color.white);
            lblBarraLateralEsquerdo.setBackground(tangerine);
            lblEditar.setBackground(Color.WHITE);
        }

        if(e.getSource() == btnLimpar){
            txtNome.setText("");
            txtApelido.setText("");
            txtContacto.setText("");
            txtEmail.setText("");
            txtContactoAlternativo.setText("");
            txtProfissao.setText("");
            txtNUIT.setText("");
            txtNoBI.setText("");
            txtMorada.setText("");
            cbCategoria.setSelectedIndex(0);
            cbEstadoCivil.setSelectedIndex(0);
            cbAreaDeServico.setSelectedIndex(0);
            bgSexo.clearSelection();
        }

        String sexo = "0";

        if (e.getSource() == btnSalvar) {

            if (rbSexoMasculino.isSelected()) {
                sexo = "M";
            }
            if(rbSexoFeminino.isSelected()){
                sexo = "F";
            }

            boolean sucessoCadastrarFuncionario;

            //AreaDeServicoAoCliente localDeTrabalho = cbAreaDeServico.getSelectedObjects();

            try{
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                String anoStr = formato.format(JDataFormatada.getDate());

                AreaDeServicoAoCliente areaDeServicoAoCliente = (AreaDeServicoAoCliente) cbAreaDeServico.getSelectedItem();
                FuncionarioController funcionarioController = new FuncionarioController();
                sucessoCadastrarFuncionario = funcionarioController.alterarFuncionario(numeroDoFuncionario, txtNome.getText(), txtApelido.getText(), anoStr, cbEstadoCivil.getSelectedItem().toString(), txtProfissao.getText(),
                        txtMorada.getText(), txtEmail.getText(), txtNoBI.getText(), Integer.parseInt(txtContacto.getText()), Integer.parseInt(txtContactoAlternativo.getText()), Integer.parseInt(txtNUIT.getText()), sexo, areaDeServicoAoCliente, cbCategoria.getSelectedItem().toString());

                if(sucessoCadastrarFuncionario){
                    JOptionPane.showMessageDialog(null, "Alteração feita com sucesso");
                }

                else {
                    JOptionPane.showMessageDialog(null, "Os campos não foram preenchidos devidamente", "Erro", JOptionPane.WARNING_MESSAGE);
                }

            }catch (Exception ex){
                JOptionPane.showMessageDialog(null, "Erro " + ex, "Erro", JOptionPane.WARNING_MESSAGE);
            }

        }

        if(e.getSource() == btnVoltar){
            new TelaAdministradorMenuFuncionario(usuario).telaMenuPrincipalAdministrador();

            this.setVisible(false);
        }

    }


}
