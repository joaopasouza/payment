/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.command;

import bonus.strategy.BonusNormalStrategy;
import collection.Funcionarios;
import java.io.IOException;
import javax.swing.JOptionPane;
import model.Funcionario;
import presenter.ManterFuncionarioPresenter;
import util.state.InserirFuncionario;
import validation.Validador;

/**
 *
 * @author joaopaulo
 */
public class InserirCommand implements ICommand {

    private final Funcionarios collection;
    private final Validador validador;
    private Funcionario funcionario;

    public InserirCommand() throws IOException {
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

        double fieldSalario = Double.parseDouble(salario);
        int FieldFaltas = Integer.parseInt(faltas);

        funcionario = new Funcionario(nome, cargo, fieldSalario, FieldFaltas, regiao);
        funcionario.setStrategy(new BonusNormalStrategy());
        funcionario.calcularBonus();

        if (collection.insert(funcionario)) {
            JOptionPane.showMessageDialog(presenter.getView(), "Salvo com sucesso!");
        } else {
            throw new Exception("Erro ao inserir o funcionário!");
        }

        int opcao = JOptionPane.showConfirmDialog(presenter.getView(), "Deseja inserir outro funcionário?", "Inserção de Registros", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
        if (opcao == JOptionPane.OK_OPTION) {
            presenter.setState(new InserirFuncionario(presenter, null));
        } else {
            presenter.getView().dispose();
        }
    }

}
