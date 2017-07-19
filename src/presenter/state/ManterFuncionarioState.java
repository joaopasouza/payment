/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter.state;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Funcionario;
import presenter.ManterFuncionarioPresenter;

/**
 *
 * @author joaopaulo
 */
public abstract class ManterFuncionarioState {

    protected ManterFuncionarioPresenter presenter;

    public ManterFuncionarioState(ManterFuncionarioPresenter presenter) {
        this.presenter = presenter;

        configurarTela();

        presenter.getView().getBtnFechar().addActionListener((ActionEvent e) -> {
            presenter.getView().dispose();
        });
    }

    public abstract void inserir();

    public abstract void visualizar(Funcionario f);

    public abstract void atualizar(Funcionario f);

    public abstract void excluir(Funcionario f);

    private void configurarTela() {
        presenter.getView().setTitle("Manter Funcionário");
        presenter.getView().setClosable(true);

        presenter.getView().getTextNome().setText("");
        presenter.getView().getTextSalario().setText("");
        presenter.getView().getTextFaltas().setText("");

        presenter.getView().getBoxCargo().removeAllItems();
        presenter.getView().getBoxRegiao().removeAllItems();
        presenter.getView().getBoxBonus().removeAllItems();

        for (ActionListener al : presenter.getView().getBtnGerenciarBonus().getActionListeners()) {
            presenter.getView().getBtnGerenciarBonus().removeActionListener(al);
        }

        for (ActionListener al : presenter.getView().getBtnEditar().getActionListeners()) {
            presenter.getView().getBtnEditar().removeActionListener(al);
        }

        for (ActionListener al : presenter.getView().getBtnExcluir().getActionListeners()) {
            presenter.getView().getBtnExcluir().removeActionListener(al);
        }

        for (ActionListener al : presenter.getView().getBtnSalvar().getActionListeners()) {
            presenter.getView().getBtnSalvar().removeActionListener(al);
        }

        for (ActionListener al : presenter.getView().getBtnFechar().getActionListeners()) {
            presenter.getView().getBtnFechar().removeActionListener(al);
        }

        preencherBoxCargo();
        preencherBoxRegiao();
        preencherBoxBonus();
    }

    private void preencherBoxCargo() {
        presenter.getView().getBoxCargo().addItem("");
        presenter.getView().getBoxCargo().addItem("Secretário");
        presenter.getView().getBoxCargo().addItem("Programador");
        presenter.getView().getBoxCargo().addItem("Gerente");
    }

    private void preencherBoxRegiao() {
        presenter.getView().getBoxRegiao().addItem("");
        presenter.getView().getBoxRegiao().addItem("ES");
        presenter.getView().getBoxRegiao().addItem("MG");
        presenter.getView().getBoxRegiao().addItem("RJ");
        presenter.getView().getBoxRegiao().addItem("SP");
    }

    private void preencherBoxBonus() {
        presenter.getView().getBoxBonus().addItem("");
        presenter.getView().getBoxBonus().addItem("Normal");
        presenter.getView().getBoxBonus().addItem("Generoso");
    }

}
