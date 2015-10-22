/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.dao;

import java.util.ArrayList;
import br.edu.utfpr.modelo.Pessoa;

/**
 *
 * @author Your Name <your.name at your.org>
 */
public class PessoaDaoArrayList implements Dao {

    private ArrayList<Pessoa> lista;

    public PessoaDaoArrayList() {
        lista = new ArrayList<>();
    }

    @Override
    public void adicionar(Pessoa p) {
        lista.add(p);
        System.out.println("A pessoa \"" + p.getNome()
                + "\" foi adicionada");
    }

    @Override
    public void remover(Pessoa p) {
        lista.remove(p);
        System.out.println("A pessoa \"" + p.getNome()
                + "\" foi removida");
    }

    @Override
    public void listarTudo() {
        // temos que percorrer o ArrayList
        // de sua posição inicial até a final .. mas qual a final?
        // temos um topo?
        // vamos usar um for-each para resolver esse problema
        System.out.println(": Inicio da relação ::");
        for (Pessoa elementoDaLista : lista) {
            System.out.println(elementoDaLista);
        }
        System.out.println(": Final da relação ::");
    }

}
