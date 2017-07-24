/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonus.strategy;

import java.util.ArrayList;
import model.Bonus;
import model.Funcionario;

/**
 *
 * @author joaopaulo
 */
public class BonusGenerosoStrategy implements IBonusStrategy {

    @Override
    public void calcularBonus(Funcionario f) throws Exception {
        ArrayList<Bonus> bonus = new ArrayList<>();
        switch (f.getCargo()) {
            case "Gerente": {
                bonus.add(new Bonus("Generoso", 500));
                break;
            }
            case "Programador": {
                bonus.add(new Bonus("Generoso", 250));
                break;
            }
            case "Secretario": {
                bonus.add(new Bonus("Generoso", 100));
            }
        }
        f.setBonus(bonus);
    }

}
