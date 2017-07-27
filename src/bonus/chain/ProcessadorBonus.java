/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonus.chain;

import bonus.strategy.IBonusStrategy;
import java.util.ArrayList;

/**
 *
 * @author joaopaulo
 */
public class ProcessadorBonus {

    private final ArrayList<IBonus> handlers;

    public ProcessadorBonus() {
        handlers = new ArrayList<>();
        handlers.add(new BonusNormal());
        handlers.add(new BonusGeneroso());
    }

    public IBonusStrategy calcular(String bonus) throws Exception {
        for (IBonus handler : handlers) {
            if (handler.aceitar(bonus)) {
                return handler.tratar();
            }
        }

        throw new Exception("Não existe tratador para este bônus!!");
    }

}
