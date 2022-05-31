package energy.view;

import energy.controller.EquipasDeTrabalhoController;
import energy.controller.FuncionarioController;
import energy.dao.ExceptionDAO;
import energy.model.Funcionario;
import energy.model.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TelaCadastrarEquipaDeTrabalho extends JFrame implements ActionListener {

    Usuario usuario;

    JLabel lblLiderDaEquipa = new JLabel("Líder da Equipa");

    JComboBox<Funcionario> cbbLiderDaEquipa = new JComboBox<>();

    JButton btnCadastrar = new JButton("Salvar");

    JButton btnVoltar = new JButton("Voltar");

    private final Color tangerine = new Color(255, 185, 57);


    public TelaCadastrarEquipaDeTrabalho(Usuario usuario){
        this.usuario = usuario;

        setSize(400, 350);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Cadastrar Equipa de Trabalho");
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

    public void tela(){
        setLayout(null);

        lblLiderDaEquipa.setBounds(20, 40, 100, 25);
        cbbLiderDaEquipa.setBounds(165, 40, 200, 25);

        btnCadastrar.setBounds(66, 150, 100, 25);
        btnVoltar.setBounds(233, 150, 100, 25);

        add(lblLiderDaEquipa);
        add(cbbLiderDaEquipa);
        add(btnCadastrar);
        add(btnVoltar);

        btnCadastrar.addActionListener(this);
        btnVoltar.addActionListener(this);

        try{
            List<Funcionario> listarFuncionario = new FuncionarioController().listarTodosFuncionarios();
            for(Funcionario funcionario : listarFuncionario){
                cbbLiderDaEquipa.addItem(funcionario);
            }
        }catch (ExceptionDAO e){
            e.printStackTrace();
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnCadastrar){
            EquipasDeTrabalhoController equipasDeTrabalhoController = new EquipasDeTrabalhoController();
            try{
                boolean cadastradoComSucesso = equipasDeTrabalhoController.cadastrarEquipaDeTrabalho((Funcionario) cbbLiderDaEquipa.getSelectedItem());
                if(cadastradoComSucesso)
                    JOptionPane.showMessageDialog(null, "Equipa de Trabalho cadastrada com sucesso");
            }catch (ExceptionDAO ex){
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar equipa de trabalho " + ex);
            }
        }

        if(e.getSource() == btnVoltar){
            new TelaAdministradorMenuEquipasDeTrabalho(usuario).telaMenuPrincipalAdministrador();
            this.dispose();
        }
    }

}
