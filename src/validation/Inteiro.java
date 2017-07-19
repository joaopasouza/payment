/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author joaopaulo
 */
public class Inteiro implements ITratador {

    @Override
    public boolean aceitar(String valor) {
        return isInteger(valor);
    }

    @Override
    public void validar(String campo, String valor) throws Exception {
        if (aceitar(valor)) {
            throw new Exception("O campo " + campo + " deve conter um número inteiro.");
        }
    }

    private boolean isInteger(String valor) {
        String regex = "^\\d+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(valor);

        return !(matcher.find());
    }

}
