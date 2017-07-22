/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 *
 * @author joaopaulo
 * @param <T>
 */
public interface IDAO<T> {

    public boolean insert(T entity) throws Exception;

    public void update(String name, T entity) throws Exception;

    public boolean delete(T entity) throws Exception;

    public TreeSet<T> find() throws Exception;

    public T findByName(String name) throws Exception;

    public int count() throws Exception;

}
