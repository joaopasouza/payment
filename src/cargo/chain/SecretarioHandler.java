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
public class SecretarioHandler implements ICargo {

    @Override
    public boolean aceitar(String cargo) {
        return cargo.equalsIgnoreCase("Secretario");
    }

    @Override
    public void adicionar(String tipo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
