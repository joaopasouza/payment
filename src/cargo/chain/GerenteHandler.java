/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cargo.chain;

import model.Funcionario;

/**
 *
 * @author joaopaulo
 */
public class GerenteHandler implements ICargo {

    @Override
    public boolean aceitar(String cargo) {
        return cargo.equalsIgnoreCase("Gerente");
    }

    @Override
    public void adicionar(String tipo) {
        if (true) {

        }
    }

}
