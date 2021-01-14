package model;

public class Ip {
	
	private int id, ip, andar, sala;
	private String nome, bloco;
	
	public Ip() {
		
	}
	
	public Ip(int id, int ip, int andar, int sala, String nome, String bloco) {
		super();
		this.id = id;
		this.ip = ip;
		this.andar = andar;
		this.sala = sala;
		this.nome = nome;
		this.bloco = bloco;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIp() {
		return ip;
	}
	public void setIp(int ip) {
		this.ip = ip;
	}
	public int getAndar() {
		return andar;
	}
	public void setAndar(int andar) {
		this.andar = andar;
	}
	public int getSala() {
		return sala;
	}
	public void setSala(int sala) {
		this.sala = sala;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getBloco() {
		return bloco;
	}
	public void setBloco(String bloco) {
		this.bloco = bloco;
	}
	@Override
	public String toString() {
		return "Ip [id=" + id + ", ip=" + ip + ", andar=" + andar + ", sala=" + sala + ", nome=" + nome + ", bloco="
				+ bloco + "]";
	}
	
	

}
