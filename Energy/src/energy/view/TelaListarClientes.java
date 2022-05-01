package energy.view;

import energy.controller.ClienteController;
import energy.dao.ExceptionDAO;
import energy.model.Cliente;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TelaListarClientes extends JFrame implements ActionListener {

    private JButton btnVoltar = new JButton();
    private JComboBox <String> cbOpcao = new JComboBox<>();
    private JTextField txtCampoDePesquisa = new JTextField();
    private JButton btnPesquisar = new JButton();

    private JTable tbTabela = new JTable();
    private String [] colunas ={"Código", "Nome", "Apelido", "Email", "Contacto", "Contacto Alternativo", "NUIT", "No BI", "Acção"};
    private DefaultTableModel model = new DefaultTableModel();


    private Color tangerine = new Color(255, 185, 57);


    public TelaListarClientes(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        setSize(1150, 725);
        setResizable(false);
        setTitle("Listar Clientes");
        getContentPane().setBackground(tangerine);
    }

    public void Tela(){
        setLayout(null);


        JScrollPane jScrollPane;
        model.setColumnIdentifiers(colunas);

        tbTabela.setModel(model);
        tbTabela.setRowHeight(20);
        jScrollPane = new JScrollPane(tbTabela);
        jScrollPane.setBounds(25, 75, 1080, 550);

        btnVoltar.setBounds(25, 20, 30, 30);
        cbOpcao.setBounds(800, 20, 75, 30);
        txtCampoDePesquisa.setBounds(875, 20, 200, 30);
        btnPesquisar.setBounds(1075, 20, 30, 30);

        add(jScrollPane);
        add(btnVoltar);
        add(cbOpcao);
        add(txtCampoDePesquisa);
        add(btnPesquisar);

        cbOpcao.addItem("ID");
        cbOpcao.addItem("Nome");

        btnPesquisar.addActionListener(this);

        model.setRowCount(0);
        ClienteController clienteController = new ClienteController();
        try{
            ArrayList<Cliente> clientes = clienteController.listarClientes();
            clientes.forEach((Cliente cliente) -> {
                model.addRow(new Object[] {cliente.getCodigoDeCliente(),
                        cliente.getNome(),
                        cliente.getApelido(),
                        cliente.getEmail(),
                        cliente.getContacto(),
                        cliente.getContactoAlternativo(),
                        cliente.getNuit(),
                        cliente.getNumeroDeBI(),
                        cliente.getApelido()});
            });
            tbTabela.setModel(model);
        }catch (ExceptionDAO e){
            Logger.getLogger(TelaListarClientes.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    public static void main(String[] args) {
        new TelaListarClientes().Tela();
    }

    public void preencherTabela() throws ExceptionDAO {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == btnPesquisar){


        }

    }
}
