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
public class BrasilHandler implements IRegiaoHandler {

    @Override
    public boolean aceitar(String regiao) {
        return regiao.equalsIgnoreCase("Brasil");
    }

    @Override
    public void calcular(Funcionario f) throws Exception {
        f.getBonus().put("Região", f.getSalario() * 0.05);
    }

}
