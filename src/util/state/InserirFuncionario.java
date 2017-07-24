/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.state;

import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.swing.JOptionPane;
import model.Funcionario;
import presenter.ManterFuncionarioPresenter;
import util.command.ICommand;
import util.command.InserirCommand;

/**
 *
 * @author joaopaulo
 */
public class InserirFuncionario extends ManterFuncionarioState {
    
    private ICommand command;
    
    public InserirFuncionario(ManterFuncionarioPresenter presenter, Funcionario funcionario) throws IOException {
        super(presenter, null);
        
        configurarTela();
        
        presenter.getView().getBtnSalvar().addActionListener((ActionEvent e) -> {
            salvar();
        });
        
        presenter.getView().setVisible(true);
    }
    
    private void configurarTela() {
        presenter.getView().getBtnGerenciarBonus().setVisible(false);
        presenter.getView().getBtnEditar().setVisible(false);
        presenter.getView().getBtnExcluir().setVisible(false);
        presenter.getView().getLabelTotal().setVisible(false);
        presenter.getView().getLabelTotalSalario().setVisible(false);
    }
    
    @Override
    public void salvar() {
        try {
            command = new InserirCommand();
            command.executar(presenter);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(presenter.getView(), e.getMessage());
        }
    }
    
    @Override
    public void cancelar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void editar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void excluir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
