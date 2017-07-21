/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.chain;

import model.Funcionario;
import presenter.ManterFuncionarioPresenter;
import util.state.ManterFuncionarioState;
import util.state.VisualizarFuncionario;

/**
 *
 * @author joaopaulo
 */
public class VisualizarHandler implements IStateHandler {

    @Override
    public boolean accept(String state) {
        return state.equalsIgnoreCase("visualizar");
    }

    @Override
    public ManterFuncionarioState doHandler(ManterFuncionarioPresenter presenter, Funcionario f) throws Exception {
        return new VisualizarFuncionario(presenter, f);
    }

}
