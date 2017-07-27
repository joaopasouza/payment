/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonus.regiao;

import model.Funcionario;

/**
 *
 * @author joaopaulo
 */
public interface IRegiaoHandler {

    public boolean aceitar(String regiao);

    public void calcular(Funcionario f) throws Exception;

}
