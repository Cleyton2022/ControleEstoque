
package br.com.ec.dao;

import java.sql.*;

public class ModuloConexao {
 
    //Criar metodo de Conexão
    public static Connection conector(){
    Connection conexao = null;
    
    String driver = "com.mysql.cj.jdbc.Driver";
    
    String url="jdbc:mysql://localhost:3306/dbvendas";
    String user = "root";
    String password = "";
    
    //conexão
        try {
            //execução do arquivo do Driver mysql
            Class.forName(driver);
            conexao = DriverManager.getConnection(url,user,password);
            return conexao;
        } catch (Exception e) {
            return conexao;
        }
    }
}
