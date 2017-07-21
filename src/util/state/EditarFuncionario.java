/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.state;

import java.awt.event.ActionEvent;
import model.Funcionario;
import presenter.ManterFuncionarioPresenter;
import util.command.ICommand;

/**
 *
 * @author joaopaulo
 */
public class EditarFuncionario extends ManterFuncionarioState {

    private ICommand command;

    public EditarFuncionario(ManterFuncionarioPresenter presenter, Funcionario funcionario) {
        super(presenter, funcionario);

        configurarTela();

        presenter.getView().getBtnEditar().addActionListener((ActionEvent e) -> {
            cancelar();
        });

        presenter.getView().setVisible(true);
    }

    @Override
    public void salvar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cancelar() {
        presenter.setState(new VisualizarFuncionario(presenter, funcionario));
    }

    @Override
    public void editar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void configurarTela() {
        presenter.getView().getBtnGerenciarBonus().setVisible(true);
        presenter.getView().getBtnEditar().setVisible(true);
        presenter.getView().getBtnExcluir().setVisible(true);

        presenter.getView().getBtnEditar().setText("Cancelar");
        presenter.getView().getBtnSalvar().setEnabled(true);
        presenter.getView().getBtnExcluir().setEnabled(false);
        presenter.getView().getBtnGerenciarBonus().setEnabled(true);

        presenter.getView().getTextNome().setText(funcionario.getNome());
        presenter.getView().getBoxCargo().setSelectedItem(funcionario.getCargo());
        presenter.getView().getTextSalario().setText(String.valueOf(funcionario.getSalario()));
        presenter.getView().getTextFaltas().setText(String.valueOf(funcionario.getFaltas()));
        presenter.getView().getBoxRegiao().setSelectedItem(funcionario.getRegiao());

        String bonus = funcionario.getBonus().get(0).getNome();
        presenter.getView().getBoxBonus().setSelectedItem(bonus);

        presenter.getView().getTextNome().setEnabled(true);
        presenter.getView().getBoxCargo().setEnabled(true);
        presenter.getView().getTextSalario().setEnabled(true);
        presenter.getView().getTextFaltas().setEnabled(true);
        presenter.getView().getBoxRegiao().setEnabled(true);
        presenter.getView().getBoxBonus().setEnabled(true);
    }

}
