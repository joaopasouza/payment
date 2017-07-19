/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import collection.Funcionarios;
import collection.observer.IObservador;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import view.PrincipalView;

/**
 *
 * @author joaopaulo
 */
public class PrincipalPresenter implements IObservador {

    private final PrincipalView view;
    private final Funcionarios collection;

    public PrincipalPresenter() throws Exception {
        view = new PrincipalView();

        collection = Funcionarios.getInstance();
        collection.addObserver(this);

        configurarTela();
        atualizarContador();

        view.getMenuItemNovoFuncionario().addActionListener((ActionEvent e) -> {
            try {
                ManterFuncionarioPresenter presenter = new ManterFuncionarioPresenter("inserir", null);
                view.getDesktop().add(presenter.getView());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(view, ex.getMessage());
            }
        });

        view.getMenuListarFuncionario().addActionListener((ActionEvent e) -> {
            ListarFuncionarioPresenter presenter;
            try {
                presenter = new ListarFuncionarioPresenter();
                view.getDesktop().add(presenter.getView());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(view, ex.getMessage());
            }

        });

        view.getMenuItemSair().addActionListener((ActionEvent e) -> {
            System.exit(0);
        });

        view.setVisible(true);
    }

    public PrincipalView getView() {
        return view;
    }

    @Override
    public void update() {
        try {
            atualizarContador();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage());
        }
    }

    private void configurarTela() {
        view.setTitle("Gestão de Funcionários");
        view.setLocationRelativeTo(null);
        view.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    private void atualizarContador() throws Exception {
        String size = String.valueOf(collection.count());
        view.getLabelTotal().setText(size);
    }

}
