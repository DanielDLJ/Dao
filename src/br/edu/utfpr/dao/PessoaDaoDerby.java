/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.dao;

import br.edu.utfpr.modelo.Pessoa;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author UTFPR
 */
public class PessoaDaoDerby implements Dao{
   
    Statement stmt;
    
    //quando eu construir um objeto dessa classe, vou conectar ao banco
    public PessoaDaoDerby(){
        //lembrem-se de usar suas credenciais;
        String username = "romario";
        String password = "123";
        String url= "jdbc:derby://localhost:1527/MeuBancoDeDados";
        
        //depois disso, posso mandar conectar
        
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            stmt = con.createStatement();
            System.out.println("Conexão estabelecida");
        } catch (SQLException se) {
            System.out.println("Mensagem: "+ se.getMessage());
        }
        
    }
    
    @Override
    public void adicionar(Pessoa p) {
        String instrucao = "INSERT INTO PESSOA(NOME,SOBRENOME,IDADE) VALUES (" 
                +"'" + p.getNome()+ "',"
                +"'" + p.getSobrenome()+ "',"
                + p.getIdade()+")"; 
        System.out.println(instrucao);
        try{
            stmt.executeUpdate(instrucao);
        }catch (SQLException se) {
            System.out.println(se);
            
        }
    }

    @Override
    public void remover(Pessoa p) {
        String instrucao = "DELETE FROM PESSOA WHERE NOME LIKE '%" + p.getNome()+"%'";
        
        System.out.println(instrucao);
        try{
            stmt.executeUpdate(instrucao);
        }catch (SQLException se) {
            System.out.println(se);
            
        }
    }

    @Override
    public void listarTudo() {
        String instrucao = "SELECT* FROM PESSOA";
        try {
            
            ResultSet rs = stmt.executeQuery(instrucao);
            
            while(rs.next()){
                System.out.println("Nome: " + rs.getString("NOME")
                        + "   Sobrenome: " + rs.getString("SOBRENOME")
                        + "   Idade: " + rs.getString("IDADE"));
            }
            
        } catch (SQLException se) {
            System.out.println(se);
        }
        
    }
    
}
