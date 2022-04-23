package energy.view;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaRecuperarAPassword extends JFrame implements ActionListener {

    ImageIcon logo = new ImageIcon("src\\Imagens\\imagem\\fndr.png");
    JLabel lbllogo = new JLabel(logo);

    JLabel lblEmailDeFuncionario = new JLabel(" E-mail  ");
    JTextField txtEmailDeFuncionario = new JTextField();
    JLabel lbltexto = new JLabel(" Recuperar a Conta  ");
    JLabel lblIdDeFuncuinario = new JLabel(" Nº de Funcionario   ");
    JPasswordField txtIdDeFuncionario = new JPasswordField();
    JButton JBPedir = new JButton(" Pedir ");
    JButton JbVoltar = new JButton(" Voltar");

    public TelaRecuperarAPassword() {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension telaTamanho = kit.getScreenSize();
//        int largura=telaTamanho.width;
//        int altura= telaTamanho.height;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // funcao para fechar a tela do programa.
        setVisible(true); // faz com que a tela fique visivel.
        setLocationRelativeTo(null); // Reposicciona a tela do programa.
        //setLocation(largura,altura);
        setResizable(false);//  faz com que a tela minimize ou maximize.
        setSize(500, 325); // As Dimencoes da tela 
        setTitle(" Recuperar a Conta "); //  Titulo da tela.
    } // fim de contruttor

    public void gui() {

        setLayout(null);

        lbllogo.setBounds(0, 0, 500, 325); //  login simbolo

        lbltexto.setBounds(180, 85, 150, 20); //        
        lbltexto.setForeground(Color.BLACK); // 

        lblEmailDeFuncionario.setBounds(60, 140, 100, 20); //  mensagem que sera exibida.
        txtEmailDeFuncionario.setBounds(170, 140, 185, 20); // para caixa de entradada.
        lblEmailDeFuncionario.setForeground(Color.BLACK); // cor de texto.
        txtEmailDeFuncionario.setOpaque(false);
        txtEmailDeFuncionario.setBorder(new MatteBorder(0, 0, 2, 0, Color.WHITE));

        lblIdDeFuncuinario.setBounds(60, 180, 130, 20);
        txtIdDeFuncionario.setBounds(170, 180, 185, 20); // caixa de entrada de dados
        lblIdDeFuncuinario.setForeground(Color.BLACK);
        txtIdDeFuncionario.setOpaque(false);
        txtIdDeFuncionario.setBorder(new MatteBorder(0, 0, 2, 0, Color.WHITE));

        JbVoltar.setBounds(160, 250, 80, 20); // para butao de enter.
        JbVoltar.setContentAreaFilled(false);
        JBPedir.setBounds(300, 250, 80, 20);// para butao de sair.
        JBPedir.setContentAreaFilled(false);

        add(lblEmailDeFuncionario); // caixa de teXto para escrever a mensagem.
        add(txtEmailDeFuncionario);// caixa de intrucao.
        add(lbltexto);
        add(JBPedir);
        add(JbVoltar);
        add(txtIdDeFuncionario); // texto de senha.
        add(lblIdDeFuncuinario); // tetoo da palavra chave 
        add(lbllogo); // logo

        JBPedir.addActionListener(this);
        JbVoltar.addActionListener(this);
        txtEmailDeFuncionario.addActionListener(this);
        txtIdDeFuncionario.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {

//        if (e.getSource() == JBPedir
//                dispose();
//                JOptionPane.showMessageDialog(this, "Preencha os campos.", "Notificação", INFORMATION_MESSAGE);
//                dispose();
//                new TelaLogin().gui();
//            } else if (txtIdDeFuncionario.getPassword().equals("")) {
//                dispose();
//                JOptionPane.showMessageDialog(this, "Preencha os campos.", "Notificação", INFORMATION_MESSAGE);
//                dispose();
//                new TelaLogin().gui();
//            } else {
//                dispose();
//                JOptionPane.showMessageDialog(this, "ID do Usuario ou Senha incorrecta.", "Notificação", WARNING_MESSAGE);
//                dispose();
//                new TelaLogin().gui();
//            }
//
//        }
        if (e.getSource() == JbVoltar) {
            dispose();
            new TelaLogin().gui();
        }
    }

    public static void main(String[] args) {

        new TelaRecuperarAPassword().gui();

    }
}
