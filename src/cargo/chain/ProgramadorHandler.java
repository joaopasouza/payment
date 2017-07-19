/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cargo.chain;

import java.util.ArrayList;
import model.Bonus;
import model.Funcionario;

/**
 *
 * @author joaopaulo
 */
public class ProgramadorHandler implements ICargo {

    @Override
    public boolean aceitar(String cargo) {
        return cargo.equalsIgnoreCase("Programador");
    }

    @Override
    public void calcular(Funcionario f) {
        ArrayList<Bonus> bonus = new ArrayList<>();
        Bonus b = new Bonus("Normal", 250);
        bonus.add(b);
        f.setBonus(bonus);
    }

}
