package com.genericrest.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author carlos
 */
@Entity
@Table(name = "manutencao")
@XmlRootElement(name = "manutencao")
public class Manutencao extends AbstractEntity {

    @Column(nullable = false)
    private Integer codigoManutencao;

    @Column(length = 255, nullable = false)
    private String pecaTrocada;
    
    @Column(nullable = false)
    private Integer tempoManutencao;
    
    @ManyToOne
    private Veiculo veiculo;
    
    @OneToMany(mappedBy = "manutencao")
    private List<PecasManutencao> pecasManutencaos;

    public Manutencao() {
    }
    
    public Manutencao(Integer codigoManutencao, String pecaTrocada, Integer tempoManutencao, Veiculo veiculo) {
        this.codigoManutencao = codigoManutencao;
        this.pecaTrocada = pecaTrocada;
        this.tempoManutencao = tempoManutencao;
        this.veiculo = veiculo;
    }

    public Integer getCodigoManutencao() {
        return codigoManutencao;
    }

    public void setCodigoManutencao(Integer codigoManutencao) {
        this.codigoManutencao = codigoManutencao;
    }

    public String getPecaTrocada() {
        return pecaTrocada;
    }

    public void setPecaTrocada(String pecaTrocada) {
        this.pecaTrocada = pecaTrocada;
    }

    public Integer getTempoManutencao() {
        return tempoManutencao;
    }

    public void setTempoManutencao(Integer tempoManutencao) {
        this.tempoManutencao = tempoManutencao;
    }

    @XmlTransient
    public Veiculo getVeiculo() {
        return veiculo;
    }

    @XmlTransient
    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
    
    
    @Override
    public void updateParameters(Object entity) {
        Manutencao other = (Manutencao) entity;
        this.codigoManutencao = other.codigoManutencao;
        this.pecaTrocada = other.pecaTrocada;
        this.tempoManutencao = other.tempoManutencao;
        this.veiculo = other.veiculo; 
    }
    
}
