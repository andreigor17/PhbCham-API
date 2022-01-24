package com.irontech.phbchamp.generic;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.springframework.lang.Nullable;

@MappedSuperclass
public class ModeloGenerico implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Quando false, o objeto encontra-se excluido/cancelado. Caso contrário
     * encontra-se ativo
     */
    private Boolean ativo = true;
    /**
     * Controle de versionamento da entidade, faz o controle de alterações
     * concorrentes
     */
    @Version
    @Nullable
    private int versao;

    public ModeloGenerico() {
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = true;
    }

    public int getVersao() {
        return versao;
    }

    public void setVersao(int versao) {
        this.versao = versao;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
    

}
