/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.dao;

import br.edu.utfpr.modelo.Pessoa;

/**
 *
 * @author Your Name <your.name at your.org>
 */
public interface Dao {
    //ctrl + shift + i  para corrigir os imports
    public void adicionar(Pessoa p);
    public void remover(Pessoa p);
    public void listarTudo();
}
