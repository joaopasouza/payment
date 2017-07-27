/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonus.regiao;

import java.util.ArrayList;
import model.Funcionario;

/**
 *
 * @author joaopaulo
 */
public class ProcessadorRegiao {

    private final ArrayList<IRegiaoHandler> handlers;

    public ProcessadorRegiao() {
        handlers = new ArrayList<>();
        handlers.add(new BrasilHandler());
        handlers.add(new SiriaHandler());
        handlers.add(new CaribeHandler());
    }

    public void calcular(Funcionario f) throws Exception {
        for (IRegiaoHandler h : handlers) {
            if (h.aceitar(f.getRegiao())) {
                h.calcular(f);
            }
        }
    }

}
