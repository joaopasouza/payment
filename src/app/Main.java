/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import presenter.PrincipalPresenter;

/**
 *
 * @author joaopaulo
 */
public class Main {

    public static void main(String[] args) {
        try {
            PrincipalPresenter presenter = new PrincipalPresenter();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
