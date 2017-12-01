package com.genericrest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author carlos
 */
@Entity
@Table(name = "ControlePeca")
@XmlRootElement(name = "ControlePeca")
public class ControlePeca extends AbstractEntity  {

    @Column(nullable = false)
    private Integer codigoPeca;

    @Column(length = 255, nullable = false)
    private String tipoPeca;
    
    @Column(length = 255, nullable = false)
    private String nomePeca;

    @Column(nullable = false)
    private Integer tempoManutencao;

    public ControlePeca() {
    }
    
    public ControlePeca(Integer codigoPeca, String tipoPeca, String nomePeca, Integer tempoManutencao) {
        this.codigoPeca = codigoPeca;
        this.tipoPeca = tipoPeca;
        this.nomePeca = nomePeca;
        this.tempoManutencao = tempoManutencao;
    }

    public Integer getCodigoPeca() {
        return codigoPeca;
    }

    public void setCodigoPeca(Integer codigoPeca) {
        this.codigoPeca = codigoPeca;
    }

    public String getTipoPeca() {
        return tipoPeca;
    }

    public void setTipoPeca(String tipoPeca) {
        this.tipoPeca = tipoPeca;
    }

    public String getNomePeca() {
        return nomePeca;
    }

    public void setNomePeca(String nomePeca) {
        this.nomePeca = nomePeca;
    }

    public Integer getTempoManutencao() {
        return tempoManutencao;
    }

    public void setTempoManutencao(Integer tempoManutencao) {
        this.tempoManutencao = tempoManutencao;
    } 
    
    @Override
    public void updateParameters(Object entity) {
       ControlePeca other = (ControlePeca) entity;
       this.codigoPeca = other.codigoPeca;
       this.nomePeca = other.nomePeca;
       this.tempoManutencao = other.tempoManutencao;
       this.tipoPeca = other.tipoPeca;
    }
    
}
