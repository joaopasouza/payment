/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonus.chain;

import bonus.strategy.IBonusStrategy;

/**
 *
 * @author joaopaulo
 */
public interface IBonus {

    public boolean aceitar(String bonus);

    public IBonusStrategy tratar() throws Exception;

}
