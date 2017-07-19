/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter.state;

import bonus.strategy.BonusNormalStrategy;
import bonus.strategy.IBonusStrategy;
import collection.Funcionarios;
import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.swing.JOptionPane;
import model.Funcionario;
import presenter.ManterFuncionarioPresenter;
import validation.Validador;

/**
 *
 * @author joaopaulo
 */
public class InserirFuncionario extends ManterFuncionarioState {

    private final Funcionarios collection;
    private final Validador validador;
    private Funcionario funcionario;

    public InserirFuncionario(ManterFuncionarioPresenter presenter) throws IOException {
        super(presenter);

        presenter.getView().getBtnGerenciarBonus().setVisible(false);
        presenter.getView().getBtnEditar().setVisible(false);
        presenter.getView().getBtnExcluir().setVisible(false);

        presenter.getView().getBtnSalvar().addActionListener((ActionEvent e) -> {
            inserir();
        });

        collection = Funcionarios.getInstance();
        validador = Validador.getInstance();

        presenter.getView().setVisible(true);
    }

    @Override
    public void inserir() {
        try {
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
                presenter.setState(new InserirFuncionario(presenter));
            } else {
                presenter.getView().dispose();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(presenter.getView(), e.getMessage());
        }
    }

    @Override
    public void visualizar(Funcionario f) {
        throw new RuntimeException("Não é possível visualizar");
    }

    @Override
    public void atualizar(Funcionario f) {
        throw new RuntimeException("Não é possível atualizar");
    }

    @Override
    public void excluir(Funcionario f) {
        throw new RuntimeException("Não é possível excluir");
    }

    private IBonusStrategy calcularBonus(String bonus) {
        return new BonusNormalStrategy();
    }

}
