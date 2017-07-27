/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonus.regiao;

import model.Funcionario;

/**
 *
 * @author joaopaulo
 */
public class CaribeHandler implements IRegiaoHandler {

    @Override
    public boolean aceitar(String regiao) {
        return regiao.equalsIgnoreCase("Caribe");
    }

    @Override
    public void calcular(Funcionario f) throws Exception {
        f.getBonus().put("Caribe", 0.0);
    }

}
