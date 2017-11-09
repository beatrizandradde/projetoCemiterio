package Entidades;

import java.util.Date;

public class Falecido {
		
	private int numero_processo_obito;
	private Date obito_data;
	private String nome_falecido;
	private String nome_pai;
	private String nome_mae;
	private int idade;
	private String sexo;
	private String raca_cor;
	private String estado_civil;	
	private String causa_morte;
	private String medico_nome;
	private int medico_crm;
	public int getNumero_processo_obito() {
		return numero_processo_obito;
	}
	public void setNumero_processo_obito(int numero_processo_obito) {
		this.numero_processo_obito = numero_processo_obito;
	}
	public Date getObito_data() {
		return obito_data;
	}
	public void setObito_data(java.util.Date date) {
		this.obito_data = date;
	}
	public String getNome_falecido() {
		return nome_falecido;
	}
	public void setNome_falecido(String nome_falecido) {
		this.nome_falecido = nome_falecido;
	}
	public String getNome_pai() {
		return nome_pai;
	}
	public void setNome_pai(String nome_pai) {
		this.nome_pai = nome_pai;
	}
	public String getNome_mae() {
		return nome_mae;
	}
	public void setNome_mae(String nome_mae) {
		this.nome_mae = nome_mae;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getRaca_cor() {
		return raca_cor;
	}
	public void setRaca_cor(String raca_cor) {
		this.raca_cor = raca_cor;
	}
	public String getEstado_civil() {
		return estado_civil;
	}
	public void setEstado_civil(String estado_civil) {
		this.estado_civil = estado_civil;
	}
	public String getCausa_morte() {
		return causa_morte;
	}
	public void setCausa_morte(String causa_morte) {
		this.causa_morte = causa_morte;
	}
	public String getMedico_nome() {
		return medico_nome;
	}
	public void setMedico_nome(String medico_nome) {
		this.medico_nome = medico_nome;
	}
	public int getMedico_crm() {
		return medico_crm;
	}
	public void setMedico_crm(int medico_crm) {
		this.medico_crm = medico_crm;
	}

}