/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import collection.Funcionarios;
import collection.observer.IObservador;
import grafico.GraficoPadrao;
import grafico.builder.GraficoDirector;
import java.awt.event.ActionEvent;
import java.util.TreeSet;
import model.Funcionario;
import org.jfree.chart.ChartPanel;
import view.GraficoView;

/**
 *
 * @author joaopaulo
 */
public class GraficoPresenter implements IObservador {

    private final GraficoView view;
    private final Funcionarios collection;
    private final TreeSet<Funcionario> funcionarios;

    public GraficoPresenter() throws Exception {
        view = new GraficoView();
        view.setTitle("Gráfico - Salários por Região");
        view.setClosable(true);
        view.setSize(1024, 600);

        collection = Funcionarios.getInstance();
        collection.addObserver(this);

        this.funcionarios = collection.find();

        view.getBtnFechar().addActionListener((ActionEvent e) -> {
            view.dispose();
        });

        plotar();

        view.setVisible(true);
    }

    public GraficoView getView() {
        return view;
    }

    private void plotar() {
        GraficoDirector director = new GraficoDirector(new GraficoPadrao(funcionarios));
        ChartPanel grafico = director.construir();
        grafico.setSize(view.getPainel().getWidth(), view.getPainel().getHeight());
        grafico.setVisible(true);
        view.getPainel().add(grafico);
        view.getPainel().validate();
    }

    @Override
    public void update() {
        view.getPainel().removeAll();
        plotar();
    }

}
