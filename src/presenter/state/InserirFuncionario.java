/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter.state;

import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.swing.JOptionPane;
import model.Funcionario;
import presenter.ManterFuncionarioPresenter;
import presenter.command.ICommand;
import presenter.command.InserirCommand;

/**
 *
 * @author joaopaulo
 */
public class InserirFuncionario extends ManterFuncionarioState {

    private ICommand command;

    public InserirFuncionario(ManterFuncionarioPresenter presenter) throws IOException {
        super(presenter);
        configurarTela();
    }

    @Override
    public void inserir() {
        try {
            command = new InserirCommand();
            command.executar(presenter);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(presenter.getView(), e.getMessage());
        }
    }

    @Override
    public void visualizar(Funcionario f) {
        throw new RuntimeException("Não é possível visualizar");
    }

    @Override
    public void atualizar(Funcionario f) {
        throw new RuntimeException("Não é possível atualizar");
    }

    @Override
    public void excluir(Funcionario f) {
        throw new RuntimeException("Não é possível excluir");
    }

    private void configurarTela() {
        presenter.getView().getBtnGerenciarBonus().setVisible(false);
        presenter.getView().getBtnEditar().setVisible(false);
        presenter.getView().getBtnExcluir().setVisible(false);

        presenter.getView().getBtnSalvar().addActionListener((ActionEvent e) -> {
            inserir();
        });

        presenter.getView().setVisible(true);
    }

}
