package com.utp_example_1.demo_utp_1.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="envio", schema="public")
public class Envio implements Serializable {
    private static final long serialVersionUID = -4404733423008657622L;

    @GeneratedValue(strategy = GenerationType.AUTO, generator = "envio_idenvios_seq")
    @SequenceGenerator(name="envio_idenvios_seq", sequenceName="envio_idenvios_seq", allocationSize=1)
    @Id
    @Column(name = "IDENVIOS")
    private Long idenvios;

    @Column(name = "NOMBREREMITENTE")
    private String nombreremitente;

    @Column(name = "DNI")
    private String dniremitente;

    @Column(name = "PESO")
    private Double peso;

    @Column(name = "VOLUMEN")
    private Double volumen;

    @Column(name = "LUGARENVIO")
    private String lugarenvio;

    @Column(name = "LUGARDESTINO")
    private String lugardestino;

    public Long getIdenvios() {
        return idenvios;
    }

    public void setIdenvios(Long idenvios) {
        this.idenvios = idenvios;
    }

    public String getNombreremitente() {
        return nombreremitente;
    }

    public void setNombreremitente(String nombreremitente) {
        this.nombreremitente = nombreremitente;
    }

    public String getDniremitente() {
        return dniremitente;
    }

    public void setDniremitente(String dniremitente) {
        this.dniremitente = dniremitente;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getVolumen() {
        return volumen;
    }

    public void setVolumen(Double volumen) {
        this.volumen = volumen;
    }

    public String getLugarenvio() {
        return lugarenvio;
    }

    public void setLugarenvio(String lugarenvio) {
        this.lugarenvio = lugarenvio;
    }

    public String getLugardestino() {
        return lugardestino;
    }

    public void setLugardestino(String lugardestino) {
        this.lugardestino = lugardestino;
    }
}
