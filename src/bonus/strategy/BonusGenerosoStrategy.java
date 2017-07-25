/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonus.strategy;

import java.util.HashMap;
import java.util.Map;
import model.Funcionario;

/**
 *
 * @author joaopaulo
 */
public class BonusGenerosoStrategy implements IBonusStrategy {

    @Override
    public void calcularBonus(Funcionario f) throws Exception {
        Map<String, Double> bonus = new HashMap<>();
        switch (f.getCargo()) {
            case "Gerente": {
                bonus.put("Generoso", 200.00);
                break;
            }
            case "Programador": {
                bonus.put("Generoso", 100.00);
                break;
            }
            case "Secretario": {
                bonus.put("Generoso", 50.00);
            }
        }
        f.setBonus(bonus);
    }

}
