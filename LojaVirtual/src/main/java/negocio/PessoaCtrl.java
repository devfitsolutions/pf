package negocio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import beans.Cidade;
import beans.Estado;
import beans.Fone;
import beans.Pessoa;
import persistencia.CidadeDAO;
import persistencia.EstadoDAO;
import persistencia.PessoaDAO;

@ManagedBean
@SessionScoped
public class PessoaCtrl implements Serializable {

	private static final long serialVersionUID = 1L;

	private Pessoa pessoa;
	private Estado estado;

	private List<Estado> estados;
	private List<Cidade> cidades;

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getListagem() {
		return PessoaDAO.listagem("");
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	public String actionGravar() {

		try {
			if (pessoa.getId() == 0) {

				pessoa.setUf(estado.getSigla());

				System.out.println("Pessoa UF: " + pessoa.getUf());
				System.out.println("Pessoa Cidade: " + pessoa.getCidade());

				PessoaDAO.inserir(pessoa);
				return actionInserir();
			} else {
				PessoaDAO.alterar(pessoa);
				return "admin/lista_pessoa";
			}

		} catch (RuntimeException erro) {
			System.out.println("Erro ao tentar gravar uma nova pessoa.");
			erro.printStackTrace();

			return null;
		}
	}

	public String actionInserir() {

		try {
			pessoa = new Pessoa();

			EstadoDAO estadodao = new EstadoDAO();
			estados = estadodao.listagem();

			cidades = new ArrayList<>();

			return "form_pessoa";
		} catch (RuntimeException erro) {
			System.out.println("Erro ao tentar carregar Estados ao abrir o formulário de pessoa.");
			erro.printStackTrace();
			return null;
		}
	}

	public String actionAlterar(Pessoa p) {
		pessoa = p;
		return "user/form_pessoa";
	}

	public String actionExcluir(Pessoa p) {
		PessoaDAO.excluir(p);
		return "admin/lista_pessoa";
	}

	// Alterado 13/03/17

	public String actionInserirFone() {
		Fone fone = new Fone();
		fone.setPessoa(pessoa);
		pessoa.getFones().add(fone);
		return "user/form_pessoa";
	}

	public String actionExcluirFone(Fone f) {
		PessoaDAO.excluirFone(f);
		pessoa.getFones().remove(f);
		return "user/form_pessoa";
	}

	public void popularCidade() {
		try {
			if (estado != null) {
				CidadeDAO cidadedao = new CidadeDAO();
				cidades = cidadedao.buscaPorEstado(estado.getId());
			} else {
				cidades = new ArrayList<>();
			}
		} catch (RuntimeException erro) {
			System.out.println("Combo Cidade não pode ser carregada.");
			erro.printStackTrace();
		}
	}
}
