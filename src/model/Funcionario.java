/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import bonus.strategy.IBonusStrategy;
import java.util.Map;

/**
 *
 * @author joaopaulo
 */
public class Funcionario implements Comparable<Funcionario> {

    private String nome;
    private String cargo;
    private double salario;
    private int faltas;
    private String regiao;
    private Map<String, Double> bonus;
    private transient IBonusStrategy strategy;

    public Funcionario(String nome, String cargo, double salario, int faltas, String regiao) {
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
        this.faltas = faltas;
        this.regiao = regiao;
    }

    public String getNome() {
        return nome;
    }

    public String getCargo() {
        return cargo;
    }

    public double getSalario() {
        return salario;
    }

    public int getFaltas() {
        return faltas;
    }

    public String getRegiao() {
        return regiao;
    }

    public Map<String, Double> getBonus() {
        return bonus;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setFaltas(int faltas) {
        this.faltas = faltas;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public void setBonus(Map<String, Double> bonus) {
        this.bonus = bonus;
    }

    public void setStrategy(IBonusStrategy strategy) {
        this.strategy = strategy;
    }

    public void calcularBonus() throws Exception {
        this.strategy.calcularBonus(this);
    }

    public double calcularSalario() {
        double value = 0;

        for (Map.Entry<String, Double> entry : bonus.entrySet()) {
            value += entry.getValue();

        }

        return value + salario;
    }

    @Override
    public int compareTo(Funcionario f) {
        return nome.compareTo(f.getNome());
    }

}
