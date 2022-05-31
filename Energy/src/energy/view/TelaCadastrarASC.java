package energy.view;

import energy.controller.ASCController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCadastrarASC extends JFrame implements ActionListener {

    private JLabel lblAreaDeServico = new JLabel("Área de Serviço ao Cliente");
    private JTextField txtAreaDeServico = new JTextField("ASC ");

    private JLabel lblProvincia = new JLabel("Província");
    private JComboBox<String> cbProvincia = new JComboBox<>();

    private JLabel lblDistritoMunicipal = new JLabel("Distrito Municipal");
    private JTextField txtDistritoMunicipal = new JTextField();

    private Color colorTangerine = new Color(255, 185, 57);

    private JButton btnSalvar = new JButton("SALVAR");

    private JButton btnCancelar = new JButton("CANCELAR");

    public TelaCadastrarASC(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 350); //
        setVisible(true);
        setTitle("Cadastrar ASC");
        setResizable(false);
        getContentPane().setBackground(colorTangerine);

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

    public void Tela(){

        setLayout(null);

        lblAreaDeServico.setBounds(20, 25, 150, 25);
        txtAreaDeServico.setBounds(185, 25, 150, 25);



        lblDistritoMunicipal.setBounds(20, 125, 150, 25);
        txtDistritoMunicipal.setBounds(185, 125, 150, 25);

        btnSalvar.setBounds(100, 200, 100, 25);
        btnCancelar.setBounds(300, 200, 100, 25);

        lblProvincia.setBounds(20, 75, 150, 25);
        cbProvincia.setBounds(185, 75, 150, 25);




        add(lblAreaDeServico);
        add(lblDistritoMunicipal);
        add(lblProvincia);

        add(txtAreaDeServico);
        add(txtDistritoMunicipal);

        add(cbProvincia);

        add(btnSalvar);
        add(btnCancelar);

        cbProvincia.addItem("Cabo Delegado");
        cbProvincia.addItem("Niassa");
        cbProvincia.addItem("Nampula");
        cbProvincia.addItem("Zambézia");
        cbProvincia.addItem("Tete");
        cbProvincia.addItem("Manica");
        cbProvincia.addItem("Sofala");
        cbProvincia.addItem("Inhambane");
        cbProvincia.addItem("Gaza");
        cbProvincia.addItem("Maputo Provincia");
        cbProvincia.addItem("Maputo Cidade");

        btnSalvar.addActionListener(this);
        btnCancelar.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e){

        if(e.getSource() == btnSalvar){

            boolean salvoComSucesso;

            try {

                ASCController ascController = new ASCController();

                salvoComSucesso = ascController.cadastrarASC(txtAreaDeServico.getText(), cbProvincia.getSelectedItem().toString(), txtDistritoMunicipal.getText());

                if (salvoComSucesso)
                    JOptionPane.showMessageDialog(null, "Cadastro feito com sucesso");

                else
                    JOptionPane.showMessageDialog(null, "Os campos não foram preenchidos devidamente", "Erro", JOptionPane.WARNING_MESSAGE);


            }catch (Exception ex){
                JOptionPane.showMessageDialog(null, "Erro " + ex, "Erro", JOptionPane.WARNING_MESSAGE);
            }

        }



        if(e.getSource() == btnCancelar){

        }

    }


}
