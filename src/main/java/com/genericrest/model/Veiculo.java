package com.genericrest.model;

import javax.persistence.Column;
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
@Table(name = "veiculo")
@XmlRootElement(name = "veiculo")
public class Veiculo extends AbstractEntity {
    
    @Column(nullable = false)
    private Integer codigoVeiculo ;

    @Column(length = 255, nullable = false)
    private String nomeVeiculo;
    
    @Column(nullable = false)
    private Integer kilometragem;
    
    @Column(length = 500, nullable = false)
    private String defeito;
    
    @Column(length = 10, nullable = false)
    private String placaVeiculo;
    
    @ManyToOne
    private Cliente cliente;

    public Veiculo() {
    }
   
    public Veiculo(Integer codigoVeiculo, String nomeVeiculo, Integer kilometragem, String defeito, String placaVeiculo, Cliente cliente) {
        this.codigoVeiculo = codigoVeiculo;
        this.nomeVeiculo = nomeVeiculo;
        this.kilometragem = kilometragem;
        this.defeito = defeito;
        this.placaVeiculo = placaVeiculo;
        this.cliente = cliente;
    }

    @XmlTransient
    public Cliente getCliente() {
        return cliente;
    }

    @XmlTransient
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Integer getCodigoVeiculo() {
        return codigoVeiculo;
    }

    public void setCodigoVeiculo(Integer codigoVeiculo) {
        this.codigoVeiculo = codigoVeiculo;
    }

    public String getNomeVeiculo() {
        return nomeVeiculo;
    }

    public void setNomeVeiculo(String nomeVeiculo) {
        this.nomeVeiculo = nomeVeiculo;
    }

    public Integer getKilometragem() {
        return kilometragem;
    }

    public void setKilometragem(Integer kilometragem) {
        this.kilometragem = kilometragem;
    }

    public String getDefeito() {
        return defeito;
    }

    public void setDefeito(String defeito) {
        this.defeito = defeito;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }
    
   
    @Override
    public void updateParameters(Object entity) {
        Veiculo other = (Veiculo) entity;
        this.codigoVeiculo = other.codigoVeiculo;
        this.defeito = other.defeito;
        this.kilometragem = other.kilometragem;
        this.placaVeiculo = other.placaVeiculo;
        this.nomeVeiculo = other.nomeVeiculo;
        this.cliente = other.cliente;
    }
    
}
