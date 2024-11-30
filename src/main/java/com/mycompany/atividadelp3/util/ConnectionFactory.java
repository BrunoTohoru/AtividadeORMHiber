package com.mycompany.atividadelp3.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    // Nome do usuário do MySQL 
    private static final String USERNAME = "root";
    
    // Senha do Mysql
    private static final String PASSWORD = "";
    
    // String de conexão com o banco de dados
    // Porta e nome do banco de dados no qual pretende-se se conectar
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3312/ifpr";
    
    public static Connection createConnectionToMySQL() {
        
        try {
            // Cria a conexão com banco de dados.
            Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            return connection;
            
        } catch (SQLException e) {
            System.out.println("Não foi possível conectar-se ao Banco de Dados");
            System.out.println(DATABASE_URL);
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public static void main(String[] args) {
        
        Connection con = createConnectionToMySQL();
        
        if (con != null) {
            System.out.println("Conexão obtida com sucesso!" + con);
        } else {
            System.out.println("Não foi possível fazer a conexão.");
        }
        
    }
}
