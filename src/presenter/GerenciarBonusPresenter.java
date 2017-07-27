/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import collection.Funcionarios;
import collection.observer.IObservador;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Funcionario;
import view.GerenciarBonusView;

/**
 *
 * @author joaopaulo
 */
public class GerenciarBonusPresenter implements IObservador {

    private final GerenciarBonusView view;
    private final Funcionario funcionario;
    private DefaultTableModel tableModel = null;
    private final Funcionarios collection;

    public GerenciarBonusPresenter(Funcionario funcionario) throws IOException {
        this.funcionario = funcionario;
        view = new GerenciarBonusView();
        view.setModal(true);

        collection = Funcionarios.getInstance();
        collection.addObserver(this);

        tableModel = new DefaultTableModel(new Object[]{"Nome", "Valor"}, 0);
        preencherTabela();

        view.getBtnFechar().addActionListener((ActionEvent e) -> {
            view.dispose();
        });

        view.getBtnExcluir().addActionListener((ActionEvent e) -> {
            excluirBonus();
        });

        view.setVisible(true);
    }

    public GerenciarBonusView getView() {
        return view;
    }

    @Override
    public void update() {
        preencherTabela();
    }

    private void excluirBonus() {
        try {
            String bonus = selecionarBonus();

            int opcao = JOptionPane.showConfirmDialog(view, "Confirma a exclusão deste bônus?", "Exclusão de Registros", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
            if (opcao == JOptionPane.OK_OPTION) {
                funcionario.getBonus().remove(bonus);
                collection.update(funcionario.getNome(), funcionario);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, e.getMessage());
        }

    }

    private void preencherTabela() {
        tableModel = (DefaultTableModel) view.getTableBonus().getModel();
        tableModel.setNumRows(0);

        for (Map.Entry<String, Double> entry : funcionario.getBonus().entrySet()) {
            String nome = entry.getKey();
            Double valor = entry.getValue();
            tableModel.addRow(new Object[]{nome, valor});
        }

        view.getLabelFuncionario().setText(funcionario.getNome());
        view.getLabelSalario().setText(String.valueOf(funcionario.calcularSalario()));
    }

    private String selecionarBonus() throws Exception {
        if (view.getTableBonus().getSelectedRow() == -1) {
            throw new Exception("Selecione um bônus!!");
        }

        int line = view.getTableBonus().getSelectedRow();
        String nome = (String) view.getTableBonus().getValueAt(line, 0);

        return nome;
    }

}
