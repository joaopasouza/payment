/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.chain;

import java.util.ArrayList;
import model.Funcionario;
import presenter.ManterFuncionarioPresenter;
import util.state.ManterFuncionarioState;

/**
 *
 * @author joaopaulo
 */
public class ProcessState {

    private final ArrayList<IStateHandler> handlers;

    public ProcessState() {
        handlers = new ArrayList<>();
        handlers.add(new InserirHandler());
        handlers.add(new VisualizarHandler());
    }

    public ManterFuncionarioState doProcess(String state, ManterFuncionarioPresenter presenter, Funcionario f) throws Exception {
        for (IStateHandler handler : handlers) {
            if (handler.accept(state)) {
                return handler.doHandler(presenter, f);
            }
        }

        throw new Exception("Não é possível tratar esse estado!!!");
    }

}
