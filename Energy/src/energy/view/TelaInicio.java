package energy.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class TelaInicio extends JFrame implements ActionListener {

    ImageIcon imagemLogin = new ImageIcon("src\\imagens\\imagem\\tomada.png");
    JLabel lblFundo = new JLabel(imagemLogin);
    JButton JBNext = new JButton(" Next ");
    ImageIcon logo = new ImageIcon("src\\Imagens\\imagem\\tomada.PNG");
    JLabel lbllogo = new JLabel(logo);

    // Decclarar um construttor para criar as funcionalidade basicas como
    //sair do programa, minimizar ou maximizar , aumentare dimunuir a tela.
    public TelaInicio() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // funcao para fechar a tela do programa.
        setVisible(true); // faz com que a tela fique visivel.
        setLocationRelativeTo(null); // Reposicciona a tela do programa.
        setResizable(false);//  faz com que a tela minimize ou maximize.
        setSize(989, 612); // As Dimencoes da tela 
        setTitle("Tela de Inicio"); //  Titulo da tela.
    } // fim de contruttor

    public void gui() {

        setLayout(null); // ajusta a tela do usuario.
        lblFundo.setBounds(0, 0, 989, 612);; // lebal para foto de 
        // As declaracoes abaixo serva para dar dimecoes as botoes e as lebol.
        lbllogo.setBounds(227, 35, 512, 512); //  login simbolo
        JBNext.setBounds(850, 525, 80, 20); // para butao de enter.

        //Adicionar na tela as componentes abaixo
        add(JBNext); // para entrar
        add(lbllogo); // logo
        add(lblFundo); // lebol de fundo.

        //Dar vida aos botões e/ou os textfiel
        JBNext.addActionListener(this);

    } // metodo  que adciona infomacos na tela de de usuario. 

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == (JBNext)) {
            dispose();
            new TelaLogin().gui();

        }// e.getSource
    }

    public static void main(String[] args) {

        new TelaInicio().gui();

    }//  Metodo

}
