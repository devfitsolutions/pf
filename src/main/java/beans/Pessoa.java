package beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pessoa")
public class Pessoa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pes_id")
	private int id;
	@Column(name = "pes_nome", length = 60, nullable = true)
	private String nome;
	@Column(name = "pes_cpf", length = 11, nullable = true)
	private char cpf;
	@Column(name = "pes_rg", length = 15, nullable = true)
	private String rg;
	@Column(name = "pes_data_nasc", nullable = true)
	private Date dataNasc;
	@Column(name = "pes_rua", length = 45, nullable = true)
	private String rua;
	@Column(name = "pes_bairro", length = 60, nullable = true)
	private String bairro;
	@Column(name = "pes_cidade", length = 30, nullable = true)
	private String cidade;
	@Column(name = "pes_uf", length = 2, nullable = true)
	private String uf;
	@Column(name = "pes_cep", length = 9, nullable = true)
	private int cep;
	@Column(name = "pes_email", length = 60, nullable = true)
	private String email;
	@Column(name = "pes_senha", length = 60, nullable = true)
	private String senha;
	@Column(name = "pes_tipo", length = 60, nullable = true)
	private String tipo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public char getCpf() {
		return cpf;
	}

	public void setCpf(char cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	// Alterado 13/03/17

	@OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Fone> fones = new ArrayList<Fone>();

	public List<Fone> getFones() {
		return fones;
	}

	public void setFones(List<Fone> fones) {
		this.fones = fones;
	}
}
