/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafico.builder;

import org.jfree.chart.ChartPanel;

/**
 *
 * @author joaopaulo
 */
public class GraficoDirector {

    GraficoBuilder builder;

    public GraficoDirector(GraficoBuilder builder) {
        this.builder = builder;
    }

    public ChartPanel construir() {
        builder.setGrafico();
        builder.setPainel();
        return builder.getPainel();
    }

}
