/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cargo.chain;

import java.util.ArrayList;
import model.Funcionario;

/**
 *
 * @author joaopaulo
 */
public class ProcessarCargo {

    private final ArrayList<ICargo> cargos;

    public ProcessarCargo() {
        cargos = new ArrayList<>();
        cargos.add(new GerenteHandler());
        cargos.add(new ProgramadorHandler());
        cargos.add(new SecretarioHandler());
    }

    public void processar(Funcionario f) {
        for (ICargo cargo : cargos) {
            if (cargo.aceitar(f.getCargo())) {
                cargo.calcular(f);
            }
        }
    }

}
