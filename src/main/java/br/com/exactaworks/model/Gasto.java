package br.com.exactaworks.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Gasto implements Serializable {

	private static final long serialVersionUID = 1892915971510890201L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idGasto;

	@Column(nullable = false, length = 50)
	private String nomePessoa;

	@Column(length = 100)
	private String descricao;

	
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDate dataHora;

	@Column(nullable = false, length = 50)
	private BigDecimal valor;

	@Column(length = 150)
	private String tags;

	public Gasto() {

	}

	public Gasto(Long idGasto, String nomePessoa, String descricao, LocalDate dataHora, BigDecimal valor, String tags) {
		this.idGasto = idGasto;
		this.nomePessoa = nomePessoa;
		this.descricao = descricao;
		this.dataHora = dataHora;
		this.valor = valor;
		this.tags = tags;
	}

	public Long getIdGasto() {
		return idGasto;
	}

	public void setIdGasto(Long idGasto) {
		this.idGasto = idGasto;
	}

	public String getNomePessoa() {
		return nomePessoa;
	}

	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDate dataHora) {
		this.dataHora = dataHora;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idGasto == null) ? 0 : idGasto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Gasto other = (Gasto) obj;
		if (idGasto == null) {
			if (other.idGasto != null)
				return false;
		} else if (!idGasto.equals(other.idGasto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Gasto [idGasto=" + idGasto + ", nomePessoa=" + nomePessoa + ", descricao=" + descricao + ", dataHora="
				+ dataHora + ", valor=" + valor + ", tags=" + tags + "]";
	}

}
