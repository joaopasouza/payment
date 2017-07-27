/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonus.chain;

import bonus.strategy.BonusGenerosoStrategy;
import bonus.strategy.IBonusStrategy;

/**
 *
 * @author joaopaulo
 */
public class BonusGeneroso implements IBonus {

    @Override
    public boolean aceitar(String bonus) {
        return bonus.equalsIgnoreCase("Generoso");
    }

    @Override
    public IBonusStrategy tratar() throws Exception {
        return new BonusGenerosoStrategy();
    }

}
