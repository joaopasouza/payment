/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafico.builder;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;

/**
 *
 * @author joaopaulo
 */
public abstract class GraficoBuilder {

    protected ChartPanel painel;
    protected JFreeChart grafico;

    public ChartPanel getPainel() {
        return painel;
    }

    public abstract CategoryDataset createDataset();

    public abstract void setGrafico();

    public abstract void setPainel();

}
