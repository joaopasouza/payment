/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafico;

import grafico.builder.GraficoBuilder;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;
import model.Funcionario;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author joaopaulo
 */
public class GraficoPadrao extends GraficoBuilder {

    private final Map<String, Double> salarios;
    private final TreeSet<Funcionario> funcionarios;

    public GraficoPadrao(TreeSet<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
        salarios = new HashMap<>();

        carregarDados();
    }

    @Override
    public CategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (Map.Entry<String, Double> entry : salarios.entrySet()) {
            dataset.addValue(entry.getValue(), "Região", entry.getKey());
        }
        return dataset;
    }

    @Override
    public void setGrafico() {
        this.grafico = ChartFactory.createBarChart("Salários por Região", "Região", "Salários", createDataset(), PlotOrientation.VERTICAL, true, true, false);
    }

    @Override
    public void setPainel() {
        this.painel = new ChartPanel(this.grafico);
    }

    private void carregarDados() {
        double salariosBrasil = 0;
        double salariosSiria = 0;
        double salariosCaribe = 0;

        for (Funcionario f : funcionarios) {
            if (f.getRegiao().equalsIgnoreCase("Brasil")) {
                salariosBrasil += f.getSalario();
            } else if (f.getRegiao().equalsIgnoreCase("Siria")) {
                salariosSiria += f.getSalario();
            } else {
                salariosCaribe += f.getSalario();
            }
        }

        salarios.put("Brasil", salariosBrasil);
        salarios.put("Siria", salariosSiria);
        salarios.put("Caribe", salariosCaribe);
    }

}
