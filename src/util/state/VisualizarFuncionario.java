/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.state;

import java.awt.event.ActionEvent;
import model.Funcionario;
import presenter.ManterFuncionarioPresenter;

/**
 *
 * @author joaopaulo
 */
public class VisualizarFuncionario extends ManterFuncionarioState {

    public VisualizarFuncionario(ManterFuncionarioPresenter presenter, Funcionario funcionario) {
        super(presenter, funcionario);

        configurarTela();

        presenter.getView().getBtnEditar().addActionListener((ActionEvent e) -> {
            editar();
        });

        presenter.getView().setVisible(true);
    }

    @Override
    public void salvar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cancelar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editar() {
        presenter.setState(new EditarFuncionario(presenter, funcionario));
    }

    @Override
    public void excluir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void configurarTela() {
        presenter.getView().getBtnGerenciarBonus().setVisible(true);
        presenter.getView().getBtnEditar().setVisible(true);
        presenter.getView().getBtnExcluir().setVisible(true);

        presenter.getView().getBtnEditar().setText("Editar");
        presenter.getView().getBtnSalvar().setEnabled(false);
        presenter.getView().getBtnExcluir().setEnabled(true);
        presenter.getView().getBtnGerenciarBonus().setEnabled(false);

        presenter.getView().getTextNome().setText(funcionario.getNome());
        presenter.getView().getBoxCargo().setSelectedItem(funcionario.getCargo());
        presenter.getView().getTextSalario().setText(String.valueOf(funcionario.getSalario()));
        presenter.getView().getTextFaltas().setText(String.valueOf(funcionario.getFaltas()));
        presenter.getView().getBoxRegiao().setSelectedItem(funcionario.getRegiao());

        String bonus = funcionario.getBonus().get(0).getNome();
        presenter.getView().getBoxBonus().setSelectedItem(bonus);

        presenter.getView().getTextNome().setEnabled(false);
        presenter.getView().getBoxCargo().setEnabled(false);
        presenter.getView().getTextSalario().setEnabled(false);
        presenter.getView().getTextFaltas().setEnabled(false);
        presenter.getView().getBoxRegiao().setEnabled(false);
        presenter.getView().getBoxBonus().setEnabled(false);
    }

}