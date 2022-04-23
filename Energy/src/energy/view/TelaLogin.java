package energy.view;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static javax.swing.JOptionPane.WARNING_MESSAGE;


public class TelaLogin extends JFrame implements ActionListener{

    ImageIcon fundoTelaInicio = new ImageIcon("src\\Imagens\\imagem\\TelaInicio_1.jpg");
    JLabel lblFundo = new JLabel(fundoTelaInicio);

    ImageIcon imageUser = new ImageIcon("src\\imagens\\icon\\user_1.png");
    JLabel lblImageUser = new JLabel(imageUser);

    JLabel lblId = new JLabel(" User   ");
    JTextField txtId = new JTextField();
    JLabel Caixa1 = new JLabel();
//
    JLabel lblTextoDeLogin = new JLabel(" FAÇA O LOGIN  ");
    JLabel lblsenha = new JLabel(" Senha   ");
    JLabel caixa2 = new JLabel();
    JPasswordField txtSenha = new JPasswordField();
    //
    JButton btnEntrar = new JButton(" LOGIN ");
    //
    JSeparator separador = new JSeparator();
    //
    ImageIcon lblsugesta = new ImageIcon("src\\imagens\\icon\\info (1).png");
    JButton btnRecuperarSenha = new JButton(lblsugesta);
    JLabel lblInfroDErecuperarConto = new JLabel();
    //

    public TelaLogin() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // funcao para fechar a tela do programa.
        setVisible(true); // faz com que a tela fique visivel.
        setLocationRelativeTo(null); // Reposicciona a tela do programa.
        setResizable(false);//  faz com que a tela minimize ou maximize.
        setSize(500, 325); // As Dimencoes da tela 
        setTitle(" Login "); //  Titulo da tela.
    } // fim de contruttor

    public void gui() {

        setLayout(null);

        lblFundo.setBounds(0, 0, 500, 325);
        lblImageUser.setBounds(227, 30, 70, 60); //  login simbolo

        lblTextoDeLogin.setBounds(215, 100, 100, 20); //        
        lblTextoDeLogin.setForeground(Color.white); // 
        //
        lblId.setBounds(120, 130, 100, 20); //  mensagem que sera exibida.
        txtId.setBounds(170, 130, 185, 20); // para caixa de entradada.
        txtId.setOpaque(false);
        txtId.setBorder(new MatteBorder(0, 0, 2, 0, Color.WHITE));
        lblId.setForeground(Color.white); // cor de texto.
        txtId.setForeground(Color.white);
        //
        lblsenha.setBounds(120, 170, 100, 20);
        txtSenha.setBounds(170, 175, 185, 20); // caixa de entrada de dados
        txtSenha.setOpaque(false);
        txtSenha.setBorder(new MatteBorder(0, 0, 2, 0, Color.WHITE));
        lblsenha.setForeground(Color.white);
        txtSenha.setForeground(Color.white);
        //
        btnEntrar.setBounds(220, 215, 75, 20); // para butao de enter.
        btnEntrar.setContentAreaFilled(false);

        //
//        separador.setBounds(190, 250, 150, 30);
//        separador.setBackground(Color.WHITE);
//        separador.setOrientation(SwingConstants.HORIZONTAL);
        //\
        btnRecuperarSenha.setBounds(450, 15, 25, 25);
        btnRecuperarSenha.setContentAreaFilled(false); // butto de JBHome
        btnRecuperarSenha.setBorderPainted(false);
        btnRecuperarSenha.setBackground(Color.WHITE);
        

        add(lblId); // caixa de teXto para escrever a mensagem.
        add(txtId);// caixa de intrucao.
        add(lblImageUser); // logo
        add(lblTextoDeLogin);
        add(lblInfroDErecuperarConto);
        add(txtSenha); // texto de senha.
        add(lblsenha); // tetoo da palavra chave 
        add(btnEntrar); // para entrar
        add(separador);
        add(btnRecuperarSenha);
        add(lblFundo);

        btnEntrar.addActionListener(this);
        btnRecuperarSenha.addActionListener(this);
        txtId.addActionListener(this);
        txtSenha.addActionListener(this);
        
        btnRecuperarSenha.addMouseListener(new  MouseAdapter() {
            
             @Override
            public void mouseClicked(MouseEvent me) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mousePressed(MouseEvent me) {
               //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
               dispose();
                new TelaRecuperarAPassword().gui();
            }

            @Override
            public void mouseReleased(MouseEvent me) {

                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                
            }

            @Override
            public void mouseEntered(MouseEvent me) {
               // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
               super.mouseEntered(me);
               lblInfroDErecuperarConto.setText("  Esqueceu-se dos Dados? ");
                lblInfroDErecuperarConto.setBounds(290, 15, 160, 25);
                lblInfroDErecuperarConto.setForeground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent me) {
        //        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                lblInfroDErecuperarConto.setText("");
            }
            
        });

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnEntrar) {
            if ((txtId.getText().equals("123")) && (txtSenha.getPassword().equals("321"))) {
                dispose();
                new TelaDeFuncionarios().gui();
            } else if (txtId.getText().equals("")) {
                dispose();
                JOptionPane.showMessageDialog(this, "Preencha os campos.", "Notificação",WARNING_MESSAGE);
                dispose();
                new TelaLogin().gui();
            } else if (txtSenha.getPassword().equals("")) {
                dispose();
                JOptionPane.showMessageDialog(this, "Preencha os campos.", "Notificação",WARNING_MESSAGE);
                dispose();
                new TelaLogin().gui();
            } else {
                dispose();
                JOptionPane.showMessageDialog(this, "ID do Usuario ou Senha incorrecta.", "Notificação", WARNING_MESSAGE);
                dispose();
                new TelaLogin().gui();
            }

        }

  
    }

    public static void main(String[] args) {

        new TelaLogin().gui();

    }

   
}
