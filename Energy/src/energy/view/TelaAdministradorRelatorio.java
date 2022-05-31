package energy.view;

import energy.model.Usuario;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaAdministradorRelatorio extends JFrame implements ActionListener {

    Usuario usuario;
    JPanel panelPrincipal = new JPanel(null);
    JPanel panelLateralEsquerdo = new JPanel(null);

    JPanel panelInferiorDireito = new JPanel(null);

    JPanel panelSuperiorDireito = new JPanel(null);

    ImageIcon fotoDePerfil = new ImageIcon("src\\imagens\\icon\\user_1.png");
    JLabel lblPerfilFoto = new JLabel(fotoDePerfil);
    JLabel lblNomeDoFuncionario = new JLabel("Funcionarios");
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

    public TelaAdministradorRelatorio(Usuario usuario){
        this.usuario = usuario;
        lblNomeDoFuncionario.setText(usuario.getNome() + " " + usuario.getApelido());
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
        panelSuperiorDireito.setBackground(colorWhaet);


    }

    public void painelInferiorDireito(){
        DefaultCategoryDataset barra = new DefaultCategoryDataset();
        barra.setValue(1, "12", "Contratos ");
        barra.setValue(2, "02/2012", "pts Aranjados ");
        barra.setValue(3, "03/2012", "Reclamcoes");
        barra.setValue(5, "03/2012", "Denucias");
        barra.setValue(8, "03/2012", "Denucias anonimas ");
        org.jfree.chart.JFreeChart grafico = ChartFactory.createBarChart("A", "B", "C", barra, PlotOrientation.VERTICAL, true, true, false);
        ChartPanel Painel = new ChartPanel(grafico);
        Painel.setBounds(50, 90, 500, 300);
        panelInferiorDireito.add(Painel);

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

        btnFuncionarios.setBounds(0, 300, 272, 50);
        btnFuncionarios.setBackground(colorPumpikin);
        btnFuncionarios.setBorderPainted(false);

        btnEquipasDeTrabalho.setBounds(0, 350, 272, 50);
        btnEquipasDeTrabalho.setBackground(colorPumpikin);
        btnEquipasDeTrabalho.setBorderPainted(false);

        btnRelatorio.setBounds(0, 400, 272, 50);
        btnRelatorio.setBackground(colorPumPikinEscuro);
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

    public void telaAdministradorMenuRelatorio(){
        panelLateralEsquerdo();
        painelSuperiorDireito();

        definirPosicoes();
        adicionarAComponenteAEscuta();
        adicionarNaTela();
        painelInferiorDireito();
    }

    public void adicionarAComponenteAEscuta(){
        btnHome.addActionListener(this);
        btnEquipasDeTrabalho.addActionListener(this);
        btnExit.addActionListener(this);
        btnFuncionarios.addActionListener(this);
    }

//    public static void main(String[] args) {
//        new TelaAdministradorRelatorio(usuario).telaAdministradorMenuRelatorio();
//    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnFuncionarios){

            new TelaAdministradorMenuFuncionario(usuario).telaMenuPrincipalAdministrador();
            this.setVisible(false);
        }

        if(e.getSource() == btnHome){
            new TelaAdministradorMenuPrincipal(usuario).telaMenuPrincipalAdministrador();
            this.setVisible(false);
        }

        if (e.getSource() == btnExit) {

            int SimOuNao = JOptionPane.showConfirmDialog(null, "Tem a certeza  de que queres terminar a sessao?", " Terminar a Sessao? ", JOptionPane.YES_NO_OPTION);
            if (SimOuNao == 0) {
                dispose();
                new TelaLogin().gui();
            }

        }


    }

}
