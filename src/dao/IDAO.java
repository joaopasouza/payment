/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;

/**
 *
 * @author joaopaulo
 * @param <T>
 */
public interface IDAO<T> {

    public boolean insert(T entity) throws Exception;

    public void update(int index, T entity) throws Exception;

    public boolean delete(T entity) throws Exception;

    public ArrayList<T> find() throws Exception;

    public T findByIndex(int index) throws Exception;

}
