/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonus.strategy;

import model.Funcionario;

/**
 *
 * @author joaopaulo
 */
public interface IBonusStrategy {

    public void calcularBonus(Funcionario f) throws Exception;

}
