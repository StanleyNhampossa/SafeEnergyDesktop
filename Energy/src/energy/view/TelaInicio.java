package energy.view;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.border.MatteBorder;

/**
 *
 * @author Olga Mutisse
 */
public class TelaInicio extends JFrame {
    
        //sair do programa, minimizar ou maximizar , aumentare dimunuir a tela.
    public TelaInicio() {
        setUndecorated(true);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // funcao para fechar a tela do programa.
        setVisible(true); // faz com que a tela fique visivel.
        setResizable(false);//  faz com que a tela minimize ou maximize.
        setSize(989, 612); //
        setLocationRelativeTo(null); // Reposicciona a tela do programa.
        setTitle("Tela de Inicio"); //  Titulo da tela.
        getContentPane().setBackground(TANGERINE);
    } // fim de contruttor
    
    private ImageIcon logo = new ImageIcon("src\\Imagens\\imagem\\maguezi.png");
    private JLabel lbllogo = new JLabel(logo);
    private JLabel lblNomeDelogo = new JLabel("Maguezi");
    private Color TANGERINE = new Color(255, 185, 57);
    private Font fontes = new Font("Times New Roman", Font.ITALIC, 30);
    private JPanel lblLateralEsquerdoFundo = new JPanel();
    static JProgressBar JbBaraDeLoading = new JProgressBar();
    //
    private JTextArea JtaCaixaDeDescricao = new JTextArea("     \n       Maguezi é um software com\n o propósito"
            + " de facilitar a vida dos clientes e para os que trabalham na "
            + " empresa fornecedora \n de corrente eléctrica.\n\n Ela tem como proposta a facilitar o uso,\n registo de dados "
            + " no sistema do cliente\n como os dados pessoais, o número de  \n contador, registo e localização dos PTs,\n"
            + " registo de funcionários, equipas de\n trabalho, entre outras funcionalidades.\n\n Ela facilita o controle e a "
            + " pesquisa  \n de dados e trabalha de forma dinâmica \n para o  mesmo. Facilita o usuário do tipo \n cliente a "
            + " fazer pedido de novos contractos\n com a empresa fornecedora de corrente eléctrica \n pois viu-se que "
            + " um dos maiores\n problema que há é quanto a resposta\n dos pedidos  de novos contractos,\n podendo vir "
            + " a demorar um ano. Para o\n usuário do tipo cliente,também \n é possível fazer reclamações e/ou \n "
            + "sugestões, fazer pedido de prestação \n de serviço. Relatar a falta de corrente \n eléctrica por causas "
            + " naturais\n ou advérsas. Este Software esta dividido\n em duas vertentes, para Destktop e \n para Mobile:");
    private JLabel lblInfroDaDescricao = new JLabel(" DESCRICAO");

    // Decclarar um construttor para criar as funcionalidade basicas como


    public void gui() {
        
        setLayout(null); // ajusta a tela do usuario.
        lblLateralEsquerdoFundo.setBounds(0, 0, 260, 694);
        lblLateralEsquerdoFundo.setBackground(Color.WHITE); // Lateral Esquerdo Fundo
        lblLateralEsquerdoFundo.setOpaque(true);
        //
        lbllogo.setBounds(130, 70, 989, 300); // lebal para foto de 
        // 
        lblNomeDelogo.setBounds(570, 380, 300, 50);
        lblNomeDelogo.setFont(fontes);
        //
        JtaCaixaDeDescricao.setBounds(12, 90, 230, 475);
        JtaCaixaDeDescricao.setOpaque(false);
        JtaCaixaDeDescricao.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
        //
        lblInfroDaDescricao.setFont(fontes);
        lblInfroDaDescricao.setBounds(25, 20, 200, 60);
        //

        JbBaraDeLoading.setValue(0);
        JbBaraDeLoading.setStringPainted(true);
        JbBaraDeLoading.setBounds(450, 550, 400, 12);
        JbBaraDeLoading.setOpaque(false);
        //
        add(JbBaraDeLoading);
        add(JtaCaixaDeDescricao);
        add(lblInfroDaDescricao);
        add(lblNomeDelogo);
        add(lbllogo); // logo
        add(lblLateralEsquerdoFundo);
        // parte de processamento
        for (int i = 1; i <= 100; i++) {
            try {
                JbBaraDeLoading.setValue(i);
                JbBaraDeLoading.setString(i + "%");
                Thread.sleep(70);
                
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        this.dispose();
        new TelaLogin().gui();

    } // metodo  que adciona infomacos na tela de de usuario.



}
