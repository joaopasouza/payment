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
public interface ICargo {

    public boolean aceitar(String cargo);

    public void calcular(Funcionario f);

}
