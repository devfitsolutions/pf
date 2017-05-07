package beans;

import javax.persistence.*;

@Entity
@Table(name = "end_cidade")
public class Cidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cid_id")
	private int id;
	@Column(name = "cid_nome", length = 80, nullable = true)
	private String nome;

	@ManyToOne
	@JoinColumn(name = "est_id")
	private Estado estado;

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

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

}