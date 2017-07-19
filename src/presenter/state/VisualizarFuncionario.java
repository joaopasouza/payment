/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter.state;

import java.awt.event.ActionEvent;
import java.io.IOException;
import model.Funcionario;
import presenter.ManterFuncionarioPresenter;

/**
 *
 * @author joaopaulo
 */
public class VisualizarFuncionario extends ManterFuncionarioState {

    public VisualizarFuncionario(ManterFuncionarioPresenter presenter, Funcionario f) throws IOException {
        super(presenter);

        configurarTela(f);

        presenter.getView().getBtnEditar().addActionListener((ActionEvent e) -> {
            //
        });

        presenter.getView().getBtnExcluir().addActionListener((ActionEvent e) -> {
            //
        });

        presenter.getView().setVisible(true);
    }

    @Override
    public void inserir() {
        throw new RuntimeException("Não é possível salvar");
    }

    @Override
    public void visualizar(Funcionario f) {
        throw new RuntimeException("Não é possível visualizar");
    }

    @Override
    public void atualizar(Funcionario f) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(Funcionario f) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void configurarTela(Funcionario f) {
        presenter.getView().getBtnGerenciarBonus().setVisible(true);
        presenter.getView().getBtnEditar().setVisible(true);
        presenter.getView().getBtnExcluir().setVisible(true);

        presenter.getView().getBtnEditar().setText("Editar");
        presenter.getView().getBtnSalvar().setEnabled(false);
        presenter.getView().getBtnExcluir().setEnabled(true);

        presenter.getView().getTextNome().setText(f.getNome());
        presenter.getView().getBoxCargo().setSelectedItem(f.getCargo());
        presenter.getView().getTextSalario().setText(String.valueOf(f.getSalario()));
        presenter.getView().getTextFaltas().setText(String.valueOf(f.getFaltas()));
        presenter.getView().getBoxRegiao().setSelectedItem(f.getRegiao());

        String bonus = f.getBonus().get(0).getNome();
        presenter.getView().getBoxBonus().setSelectedItem(bonus);

        presenter.getView().getTextNome().setEnabled(false);
        presenter.getView().getBoxCargo().setEnabled(false);
        presenter.getView().getTextSalario().setEnabled(false);
        presenter.getView().getTextFaltas().setEnabled(false);
        presenter.getView().getBoxRegiao().setEnabled(false);
        presenter.getView().getBoxBonus().setEnabled(false);
    }

}
