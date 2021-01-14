package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	// Constante usado para string de conexao
			private static final String 
			SCONEXAO="jdbc:mysql://localhost:3306/ip";
			private static final String USUARIO="root";
			private static final String SENHA="";
		// Classe de conexao JAVA
			private Connection conectar;
		// Construtor para criar a conexao	
			public Conexao() throws SQLException  {
				// Configurar o driver de conexao
				conectar = DriverManager.getConnection(
						SCONEXAO,USUARIO,SENHA);
				
			}	
			
			public Connection getConexao(){
				return conectar;
				
			}

}
