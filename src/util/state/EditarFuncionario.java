/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.state;

import bonus.strategy.BonusGenerosoStrategy;
import bonus.strategy.BonusNormalStrategy;
import bonus.strategy.IBonusStrategy;
import collection.Funcionarios;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.Map;
import javax.swing.JOptionPane;
import model.Funcionario;
import presenter.ManterFuncionarioPresenter;
import validation.Validador;

/**
 *
 * @author joaopaulo
 */
public class EditarFuncionario extends ManterFuncionarioState {

    private final Validador validador;
    private final Funcionarios collection;

    public EditarFuncionario(ManterFuncionarioPresenter presenter, Funcionario funcionario) throws IOException {
        super(presenter, funcionario);

        validador = Validador.getInstance();
        collection = Funcionarios.getInstance();

        configurarTela();

        presenter.getView().getBtnEditar().addActionListener((ActionEvent e) -> {
            cancelar();
        });

        presenter.getView().getBtnSalvar().addActionListener((ActionEvent e) -> {
            salvar();
        });

        presenter.getView().setVisible(true);
    }

    @Override
    public void salvar() {
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

            funcionario.setNome(nome);
            funcionario.setCargo(cargo);
            funcionario.setSalario(fieldSalario);
            funcionario.setFaltas(FieldFaltas);
            funcionario.setRegiao(regiao);
            funcionario.setStrategy(calcularBonus(bonus));
            funcionario.calcularBonus();

            collection.update(nome, funcionario);
            JOptionPane.showMessageDialog(presenter.getView(), "Salvo com sucesso!");
            presenter.setState(new VisualizarFuncionario(presenter, funcionario));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(presenter.getView(), e.getMessage());
        }
    }

    @Override
    public void cancelar() {
        try {
            presenter.setState(new VisualizarFuncionario(presenter, funcionario));
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(presenter.getView(), ex.getMessage());
        }
    }

    @Override
    public void editar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void configurarTela() {
        presenter.getView().getBtnGerenciarBonus().setVisible(true);
        presenter.getView().getBtnEditar().setVisible(true);
        presenter.getView().getBtnExcluir().setVisible(true);

        presenter.getView().getBtnEditar().setText("Cancelar");
        presenter.getView().getBtnSalvar().setEnabled(true);
        presenter.getView().getBtnExcluir().setEnabled(false);
        presenter.getView().getBtnGerenciarBonus().setEnabled(true);

        String bonus = "";
        for (Map.Entry<String, Double> entry : funcionario.getBonus().entrySet()) {
            String key = entry.getKey();
            if (key.equalsIgnoreCase("Normal")) {
                bonus = key;
            } else if (key.equalsIgnoreCase("Generoso")) {
                bonus = key;
            }
        }

        presenter.getView().getBoxBonus().setSelectedItem(bonus);

        presenter.getView().getTextNome().setText(funcionario.getNome());
        presenter.getView().getBoxCargo().setSelectedItem(funcionario.getCargo());
        presenter.getView().getTextSalario().setText(String.valueOf(funcionario.getSalario()));
        presenter.getView().getTextFaltas().setText(String.valueOf(funcionario.getFaltas()));
        presenter.getView().getBoxRegiao().setSelectedItem(funcionario.getRegiao());

        presenter.getView().getTextNome().setEnabled(true);
        presenter.getView().getBoxCargo().setEnabled(true);
        presenter.getView().getTextSalario().setEnabled(true);
        presenter.getView().getTextFaltas().setEnabled(true);
        presenter.getView().getBoxRegiao().setEnabled(true);
        presenter.getView().getBoxBonus().setEnabled(true);
    }

    private IBonusStrategy calcularBonus(String tipo) {
        if (tipo.equalsIgnoreCase("Normal")) {
            return new BonusNormalStrategy();
        } else {
            return new BonusGenerosoStrategy();
        }
    }

}
