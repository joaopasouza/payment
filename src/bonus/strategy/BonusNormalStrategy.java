/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonus.strategy;

import cargo.chain.ProcessarCargo;
import model.Funcionario;

/**
 *
 * @author joaopaulo
 */
public class BonusNormalStrategy implements IBonusStrategy {

    @Override
    public void calcularBonus(Funcionario f) throws Exception {
        ProcessarCargo pc = new ProcessarCargo();
        pc.processar(f);
    }

}
