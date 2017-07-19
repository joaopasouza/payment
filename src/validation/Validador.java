/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validation;

import java.util.ArrayList;

/**
 *
 * @author joaopaulo
 */
public class Validador {

    private ArrayList<ITratador> tratadores;
    private static Validador instance;

    private Validador() {
        tratadores = new ArrayList<>();
    }

    public static Validador getInstance() {
        if (instance == null) {
            instance = new Validador();
        }

        return instance;
    }

    private void add(ITratador tratador) throws Exception {
        tratadores.add(tratador);
    }

    public void setRegras(String campo, String valor, String[] regras) throws Exception {
        tratadores = new ArrayList<>();

        for (String regra : regras) {
            Class<?> classe = Class.forName("validation." + regra);
            Object objeto = classe.newInstance();
            add((ITratador) objeto);
        }

        processar(campo, valor);
    }

    private void processar(String campo, String valor) throws Exception {
        for (ITratador t : tratadores) {
            if (t.aceitar(valor)) {
                t.validar(campo, valor);
            }
        }
    }

}
