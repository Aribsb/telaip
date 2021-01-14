package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.IpDAO;
import model.Ip;
import model.IpDAO;


public class JanelaIps extends JFrame implements ActionListener{
	
	private JLabel nomeIp, nomeNome, nomeBloco, nomeSala, nomeAndar;
	private JTextField textoIp, textoNome;
	private JComboBox bloco, sala, andar;
	private JButton btnSalvar, btnExcluir, btnEditar, btnAtualizar;
	private JTable tabela;
	private DefaultTableModel tbModel;
	private Ip ip;
	
	public JanelaIps() throws SQLException {
		
		super("Organizador de IPs!");//aqui vc põe um nome na janela
		setSize(600, 600);
				
		setLocationRelativeTo(null);//aqui vc põe a janela no centro da tela
		setLayout(null);//aqui vc deixa a forma do layout nulo para vc mesmo implementar
		
		initComponents();
		
		setVisible(true);//Aqui vc torna a janela visivel
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
		
		
	}
	
	public void initComponents() throws SQLException{
	
		//baixo
		
		nomeIp = new JLabel("IP: ");
		add(nomeIp);
		nomeIp.setBounds(21,25,100,20);		
		textoIp = new JTextField("Digite aqui o IP da máquina! ");
		textoIp.setBounds(90, 20, 200, 28);
		add(textoIp);		
		
		nomeNome = new JLabel(" Nome: ");//aqui se dá um nome ao label
		nomeNome.setBounds(19, 40, 100, 60);//aqui vc seta o local onde o label deve ficar em relação a janela
		add(nomeNome);//aqui você adiciona um nome de um campo na janelaIps		
		textoNome = new JTextField(" Digite aqui o nome da máquina! ");//aqui vc dá um nome para o campo de texto
		add(textoNome);//aqui vc adiciona o campo de texto a janela
		textoNome.setBounds(90, 55, 200, 28);//aqui vc ajusta aonde o campo de texto irá ficar
		
		nomeBloco = new JLabel(" Bloco: ");
		add(nomeBloco);
		nomeBloco.setBounds(20 , 70, 100, 60);
		bloco = new JComboBox();
		add(bloco);
		bloco.addItem("A");
		bloco.addItem("B");
		bloco.addItem("C");
		bloco.setBounds(90, 90, 70, 20);
		
		nomeSala = new JLabel(" Sala: ");
		add(nomeSala);
		nomeSala.setBounds(20 , 100, 100, 60);
		sala = new JComboBox();
		add(sala);
		sala.addItem("1");
		sala.addItem("2");
		sala.addItem("3");
		sala.addItem("4");
		sala.addItem("5");
		sala.setBounds(90, 120, 70, 20);
		
		nomeAndar = new JLabel(" Andar: ");
		add(nomeAndar);
		nomeAndar.setBounds(20 , 130, 100, 60);
		andar = new JComboBox();
		add(andar);
		andar.addItem("1");
		andar.addItem("2");
		andar.addItem("3");
		andar.addItem("4");
		andar.addItem("5");
		andar.setBounds(90, 150, 70, 20);
		
		btnSalvar = new JButton(" Salvar ");
		btnSalvar.addActionListener(this);
		add(btnSalvar);
		btnSalvar.setBounds(20, 190, 100, 30);
		
		btnExcluir = new JButton(" Excluir ");
		btnExcluir.addActionListener(this);
		add(btnExcluir);
		btnExcluir.setBounds(130, 190, 100, 30);
		
		btnEditar = new JButton(" Editar ");
		btnEditar.addActionListener(this);
		add(btnEditar);
		btnEditar.setBounds(130, 190, 100, 30);
		
		btnAtualizar = new JButton(" Atualizar ");
		btnAtualizar.addActionListener(this);
		add(btnAtualizar);
		btnAtualizar.setBounds(130, 190, 100, 30);
		
		//tabelas
		
		IpDAO dao = new IpDAO();
		tbModel = dao.listaIp();
		
		tabela = new JTable(tbModel);
		add(tabela);
		tabela.setBounds(100, 250, 400, 180);
		
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent evento) {
		
		if(btnSalvar==evento.getSource()){
			try {
				ip = new Ip();
				ip.setIp(Integer.parseInt(nomeIp.getText()));
			
				lutador.setPeso(Double.parseDouble(txtPeso.getText()));
				
				lutador.setAltura(
				Double.parseDouble(txtAltura.getText()));
				LutadorDAO dao = new LutadorDAO();
				dao.inserir(lutador);
				
				JOptionPane.showMessageDialog(null,
						"Gravado com sucesso");
				tbLutador.setModel(dao.listaLutador());
			} catch (SQLException e) {			
				JOptionPane.showMessageDialog(null,
						"Deu ruim...");
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null,
						"Preencha todos os campos e tipos corretos");
			}
			
		}else if(btnExcluir==evento.getSource()){
			int col=0,lin;
			lin = tbLutador.getSelectedRow();
			if (lin>=1) {
			String id = tbLutador.getValueAt(lin,col).toString();
			try {
				lutador = new Lutador(Integer.parseInt(id));
				LutadorDAO dao = new LutadorDAO();
				
				
				int resultado = JOptionPane.showConfirmDialog(
						null,"Deseja excluir?");
				if (resultado==0){
					dao.excluir(lutador);	
					JOptionPane.showMessageDialog(null, "Excluido");
					tbLutador.setModel(dao.listaLutador());
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}else {
				JOptionPane.showMessageDialog(null,"Selecione um lutador");
			}
		}else if(btnEditar==evento.getSource()){
			int lin;
			lin = tbLutador.getSelectedRow();
			if (lin>=1) {
			
			int id = Integer.parseInt(tbLutador.getValueAt(lin,0).toString());
			String nome = tbLutador.getValueAt(lin,1).toString();
			double peso = Double.parseDouble(tbLutador.getValueAt(lin,2).toString());
			double altura = Double.parseDouble(tbLutador.getValueAt(lin,3).toString());
		
			txtNome.setText(nome);
			txtAltura.setText(""+altura);
			txtPeso.setText(""+peso);
			
			btnSalvar.setVisible(false);
			btnEditar.setVisible(false);
			btnAtualizar.setVisible(true);
			}else {
				JOptionPane.showMessageDialog(null,"Selecione um lutador");
			}
			
		}else if(btnAtualizar==evento.getSource()) {
			try {
				String nome = txtNome.getText();
				double peso = Double.parseDouble(txtPeso.getText());
				double altura =	Double.parseDouble(txtAltura.getText());
				lutador=new Lutador(nome,peso,altura);
				
				int lin = tbLutador.getSelectedRow();
				int id = Integer.parseInt(tbLutador.getValueAt(lin,0).toString());
				lutador.setId(id);
				LutadorDAO dao = new LutadorDAO();
				dao.atualizar(lutador);
				JOptionPane.showMessageDialog(null,"Atualizado com sucesso: "+lutador);
				tbLutador.setModel(dao.listaLutador());
				btnSalvar.setVisible(true);
				btnEditar.setVisible(true);
				btnAtualizar.setVisible(false);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		
		
	}
	
	public static void main(String[] args) throws SQLException {
		JanelaIps janela = new JanelaIps();
	}

	

}
