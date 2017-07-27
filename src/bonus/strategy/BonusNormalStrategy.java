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
public class BonusNormalStrategy implements IBonusStrategy {

    @Override
    public void calcularBonus(Funcionario funcionario) throws Exception {
        Map<String, Double> bonus = new HashMap<>();
        switch (funcionario.getCargo()) {
            case "Gerente": {
                bonus.put("Normal", 100.00);
                break;
            }
            case "Programador": {
                bonus.put("Normal", 50.00);
                break;
            }
            case "Secretario": {
                bonus.put("Normal", 25.00);
            }
        }
        funcionario.setBonus(bonus);
    }

}
