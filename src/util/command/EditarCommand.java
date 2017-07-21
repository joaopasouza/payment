/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.command;

import collection.Funcionarios;
import presenter.ManterFuncionarioPresenter;
import validation.Validador;

/**
 *
 * @author joaopaulo
 */
public class EditarCommand implements ICommand {

    private final Funcionarios collection;
    private final Validador validador;

    public EditarCommand() throws Exception {
        collection = Funcionarios.getInstance();
        validador = Validador.getInstance();
    }

    @Override
    public void executar(ManterFuncionarioPresenter presenter) throws Exception {
        String nome = presenter.getView().getTextNome().getText();
        String cargo = String.valueOf(presenter.getView().getBoxCargo().getSelectedItem());
        String salario = presenter.getView().getTextSalario().getText();
        String faltas = presenter.getView().getTextFaltas().getText();
        String regiao = String.valueOf(presenter.getView().getBoxRegiao().getSelectedItem());
        String bonus = String.valueOf(presenter.getView().getBoxBonus().getSelectedItem());

        validador.setRegras("Nome", nome, new String[]{"Requerido"});
        validador.setRegras("Cargo", cargo, new String[]{"Requerido"});
        validador.setRegras("Salário", salario, new String[]{"Requerido", "Decimal"});
        validador.setRegras("Faltas", faltas, new String[]{"Requerido", "Inteiro"});
        validador.setRegras("Região", regiao, new String[]{"Requerido"});
        validador.setRegras("Bônus", bonus, new String[]{"Requerido"});
    }

}
