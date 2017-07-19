/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import model.Funcionario;
import presenter.chain.ProcessState;
import presenter.state.ManterFuncionarioState;
import view.ManterFuncionarioView;

/**
 *
 * @author joaopaulo
 */
public final class ManterFuncionarioPresenter {

    private final ManterFuncionarioView view;
    private ManterFuncionarioState state;

    public ManterFuncionarioPresenter(String state, Funcionario f) throws Exception {
        view = new ManterFuncionarioView();

        ProcessState process = new ProcessState();
        setState(process.doProcess(state, this, f));
    }

    public ManterFuncionarioView getView() {
        return view;
    }

    public void setState(ManterFuncionarioState state) {
        this.state = state;
    }

}
