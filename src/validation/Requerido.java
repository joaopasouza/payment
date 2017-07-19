/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validation;

/**
 *
 * @author joaopaulo
 */
public class Requerido implements ITratador {

    @Override
    public boolean aceitar(String valor) {
        return valor.equals("");
    }

    @Override
    public void validar(String campo, String valor) throws Exception {
        if (aceitar(valor)) {
            throw new Exception("O campo " + campo + " é obrigatório.");
        }
    }

}
