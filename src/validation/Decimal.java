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
public class Decimal implements ITratador {

    @Override
    public boolean aceitar(String valor) {
        return isDouble(valor);
    }

    @Override
    public void validar(String campo, String valor) throws Exception {
        if (aceitar(valor)) {
            throw new Exception("O campo " + campo + " deve conter um número decimal.");
        }
    }

    private boolean isDouble(String valor) {
        try {
            Double.parseDouble(valor);
            return false;
        } catch (Exception e) {
            return true;
        }
    }

}
