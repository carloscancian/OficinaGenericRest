package com.genericrest.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author carlos
 */

@Entity
@Table(name = "PecasManutencao")
@XmlRootElement(name = "PecasManutencao")
public class PecasManutencao extends AbstractEntity {
    
    @ManyToOne
    private Manutencao manutencao;
    
    @ManyToOne
    private ControlePeca controlePeca;

    public PecasManutencao() {
    }
    
    public PecasManutencao(Manutencao manutencao, ControlePeca controlePeca) {
        this.manutencao = manutencao;
        this.controlePeca = controlePeca;
    }

    @XmlTransient
    public Manutencao getManutencao() {
        return manutencao;
    }

    @XmlTransient
    public void setManutencao(Manutencao manutencao) {
        this.manutencao = manutencao;
    }


    @XmlTransient
    public ControlePeca getControlePeca() {
        return controlePeca;
    }

    @XmlTransient
    public void setControlePeca(ControlePeca controlePeca) {
        this.controlePeca = controlePeca;
    }
    

    
    @Override
    public void updateParameters(Object entity) {
        PecasManutencao other = (PecasManutencao) entity;
        this.manutencao = other.manutencao;
        this.controlePeca = other.controlePeca;  
    }
    
}
