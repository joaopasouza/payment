/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.command;

import presenter.ManterFuncionarioPresenter;

/**
 *
 * @author joaopaulo
 */
public interface ICommand {

    public void executar(ManterFuncionarioPresenter presenter) throws Exception;

}
