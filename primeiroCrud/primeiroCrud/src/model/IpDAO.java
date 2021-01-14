package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

public class IpDAO {
	
	private Connection conexao;
    // Preparar o sql.
    private PreparedStatement prepararSQL;
    // guardar o resultado de um select
    private ResultSet resultado;
    
    public IpDAO() throws SQLException{
    	this.conexao = new Conexao().getConexao();
    }
	
    public void inserir(Ip ip) throws SQLException{
    	String sql = 
 "insert into  tabip(ip,nome,bloco,andar,sala) values (?,?,?,?,?)";
    	
 prepararSQL = conexao.prepareStatement(sql);
 prepararSQL.setInt(1,ip.getIp());
 prepararSQL.setString(2, ip.getNome());
 prepararSQL.setString(3, ip.getBloco());
 prepararSQL.setInt(4, ip.getAndar());
 prepararSQL.setInt(5, ip.getSala());
 prepararSQL.execute();
 prepararSQL.close();
    }
    
    public void atualizar(Ip ip1) throws SQLException{
    	String 
sql="update tabip set ip=?,nome=?,bloco=?,andar=?,sala=? where id=?";
    	prepararSQL = conexao.prepareStatement(sql);
    	prepararSQL.setInt(1, ip1.getIp());
    	prepararSQL.setString(2, ip1.getNome());
    	prepararSQL.setString(3, ip1.getBloco());
    	prepararSQL.setInt(4, ip1.getSala());
    	prepararSQL.setInt(5, ip1.getId());
    	prepararSQL.execute();
    	prepararSQL.close();
    }
    
    public void excluir(Ip ip2) throws SQLException{
    	String sql = "delete from tabip where id=?";
    	prepararSQL = conexao.prepareStatement(sql);
    	prepararSQL.setInt(1, ip2.getId());
    	prepararSQL.execute();
    	prepararSQL.close();
    }
    
   
    public DefaultTableModel listaIp() throws SQLException{
    	String sql = "select * from tabip order by nome";
    	DefaultTableModel tabela = new DefaultTableModel();
    	
    	prepararSQL = conexao.prepareStatement(sql);
    	
    	resultado = prepararSQL.executeQuery();

    	tabela.addColumn("ID");
    	tabela.addColumn("Ip");
    	tabela.addColumn("Nome");
    	tabela.addColumn("Bloco");
    	tabela.addColumn("Andar");
    	tabela.addColumn("Sala");
    	
    	String tituloColunas[] = {"ID","Ip","Nome","Bloco","Andar","Sala"};
    	tabela.addRow(tituloColunas);
        
    	
    	while (resultado.next()){
    		tabela.addRow(new String[] {
    		     resultado.getString("id"),
    		     resultado.getString("nome"),
           		 resultado.getString("bloco"), 
           		 resultado.getString("andar"), 
           		 resultado.getString("sala"),
                    		 
            });
    	}
        return tabela;    	
    }

}
