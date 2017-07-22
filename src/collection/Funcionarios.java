/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collection;

import collection.observer.Sujeito;
import dao.GsonDAOFuncionario;
import dao.IDAO;
import java.io.IOException;
import java.util.TreeSet;
import model.Funcionario;

/**
 *
 * @author joaopaulo
 */
public class Funcionarios extends Sujeito {

    private static Funcionarios instance;
    private final IDAO dao;

    private Funcionarios() throws IOException {
        dao = new GsonDAOFuncionario("src/data/source.json");
    }

    public static Funcionarios getInstance() throws IOException {
        if (instance == null) {
            instance = new Funcionarios();
        }

        return instance;
    }

    public boolean insert(Funcionario f) throws Exception {
        boolean insert = dao.insert(f);

        if (insert) {
            notifyObservers();
        }

        return insert;
    }

    public void update(String name, Funcionario f) throws Exception {
        dao.update(name, f);
        notifyObservers();
    }

    public TreeSet<Funcionario> find() throws Exception {
        return dao.find();
    }

    public Funcionario findByName(String name) throws Exception {
        return (Funcionario) dao.findByName(name);
    }

    public int count() throws Exception {
        return dao.count();
    }

}
