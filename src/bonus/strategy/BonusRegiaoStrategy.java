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
public class BonusRegiaoStrategy implements IBonusStrategy {

    @Override
    public void calcularBonus(Funcionario f) throws Exception {
        ArrayList<Bonus> bonus = new ArrayList<>();
        switch (f.getRegiao()) {
            case "Brasil": {
                Bonus b = new Bonus("Região", (f.getSalario() * 0.05));
                bonus.add(b);
                break;
            }
            case "Siria": {
                Bonus b = new Bonus("Região", (f.getSalario() * 10));
                bonus.add(b);
                break;
            }
            case "Caribe": {
                Bonus b = new Bonus("Região", 0);
                bonus.add(b);
                break;
            }
        }
        f.setBonus(bonus);
    }
}
