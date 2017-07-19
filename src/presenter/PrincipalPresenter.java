/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import view.PrincipalView;

/**
 *
 * @author joaopaulo
 */
public class PrincipalPresenter {

    private final PrincipalView view;

    public PrincipalPresenter() {
        view = new PrincipalView();
        configurarTela();

        view.getMenuItemNovoFuncionario().addActionListener((ActionEvent e) -> {
            ManterFuncionarioPresenter presenter;
            try {
                presenter = new ManterFuncionarioPresenter("Inserir", null);
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

    private void configurarTela() {
        view.setTitle("Gestão de Funcionários");
        view.setLocationRelativeTo(null);
        view.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

}
