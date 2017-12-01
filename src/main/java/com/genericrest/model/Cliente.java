package com.genericrest.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author carlos
 */

@Entity
@Table(name = "cliente")
@XmlRootElement(name = "cliente")
public class Cliente extends AbstractEntity {

    @Column(nullable = false)
    private Integer codigoCliente ;

    @Column(length = 255, nullable = false)
    private String nomeCliente ;
    
    @Column(length = 255, nullable = false)
    private String endereco;
    
    @Column(length = 12, nullable = false)
    private String telefone;

    @Column(nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataNascimento;

    public Cliente() {
    }
    
    public Cliente(Integer codigoCliente, String nomeCliente, String endereco, String telefone, Date dataNascimento) {
        this.codigoCliente = codigoCliente;
        this.nomeCliente = nomeCliente;
        this.endereco = endereco;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
    }

    public Integer getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(Integer codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    @Override
    public void updateParameters(Object entity) {
       Cliente other = (Cliente) entity;
       this.codigoCliente = other.codigoCliente;
       this.dataNascimento = other.dataNascimento;
       this.endereco = other.endereco;
       this.nomeCliente = other.nomeCliente;
       this.telefone = other.telefone;
    }
    
}
