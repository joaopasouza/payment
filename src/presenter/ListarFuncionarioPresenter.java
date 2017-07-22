/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import collection.Funcionarios;
import collection.observer.IObservador;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Funcionario;
import view.ListarFuncionarioView;

/**
 *
 * @author joaopaulo
 */
public class ListarFuncionarioPresenter implements IObservador {

    private final ListarFuncionarioView view;
    private final Funcionarios collection;
    private DefaultTableModel tableModel = null;
    private Funcionario funcionario;

    public ListarFuncionarioPresenter() throws Exception {
        view = new ListarFuncionarioView();
        tableModel = new DefaultTableModel(new Object[]{"Nome", "Cargo", "Salário"}, 0);

        collection = Funcionarios.getInstance();
        collection.addObserver(this);

        view.getBtnVisualizar().addActionListener((ActionEvent e) -> {
            try {
                funcionario = selecionarFuncionario();
                ManterFuncionarioPresenter presenter = new ManterFuncionarioPresenter("visualizar", funcionario);
                view.getParent().add(presenter.getView());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(view, ex.getMessage());
            }
        });

        view.getBtnFechar().addActionListener((ActionEvent e) -> {
            view.dispose();
        });

        preencherTabela();

        view.setTitle("Lista de Funcionários");
        view.setClosable(true);
        view.setVisible(true);
    }

    public ListarFuncionarioView getView() {
        return view;
    }

    @Override
    public void update() {
        try {
            preencherTabela();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage());
        }
    }

    private void preencherTabela() throws Exception {
        tableModel = (DefaultTableModel) view.getTableFuncionarios().getModel();
        tableModel.setNumRows(0);

        for (Funcionario f : collection.find()) {
            String nome = f.getNome();
            String cargo = f.getCargo();
            String salario = String.valueOf(f.calcularSalario());

            tableModel.addRow(new Object[]{nome, cargo, salario});
        }
    }

    private Funcionario selecionarFuncionario() throws Exception {
        if (view.getTableFuncionarios().getSelectedRow() == -1) {
            throw new Exception("Selecione um funcionário!");
        }

        int line = view.getTableFuncionarios().getSelectedRow();
        String name = (String) view.getTableFuncionarios().getValueAt(line, 0);

        return collection.findByName(name);
    }

}
