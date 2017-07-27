/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonus.chain;

import bonus.strategy.BonusNormalStrategy;
import bonus.strategy.IBonusStrategy;

/**
 *
 * @author joaopaulo
 */
public class BonusNormal implements IBonus {

    @Override
    public boolean aceitar(String bonus) {
        return bonus.equalsIgnoreCase("Normal");
    }

    @Override
    public IBonusStrategy tratar() throws Exception {
        return new BonusNormalStrategy();
    }

}
