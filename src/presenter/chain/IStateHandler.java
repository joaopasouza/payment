/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter.chain;

import model.Funcionario;
import presenter.ManterFuncionarioPresenter;
import presenter.state.ManterFuncionarioState;

/**
 *
 * @author joaopaulo
 */
public interface IStateHandler {

    public boolean accept(String state);

    public ManterFuncionarioState doHandler(ManterFuncionarioPresenter presenter, Funcionario f) throws Exception;

}
