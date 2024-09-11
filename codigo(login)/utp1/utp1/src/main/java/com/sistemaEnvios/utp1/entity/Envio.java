package com.sistemaEnvios.utp1.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "envios", schema="public")
public class Envio implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Envio")
    private Long idEnvio;

    @Column(name = "Nombre_Remitente", nullable = false)
    private String nombreRemitente;

    @Column(name = "DNI_Remitente", nullable = false)
    private String dniRemitente;

    @Column(name = "Peso", nullable = false)
    private Double peso;

    @Column(name = "Volumen", nullable = false)
    private Double volumen;

    @Column(name = "Lugar_Envio", nullable = false)
    private String lugarEnvio;

    @Column(name = "Lugar_Destino", nullable = false)
    private String lugarDestino;

    // Getters y setters
    public Long getIdEnvio() { return idEnvio; }
    public void setIdEnvio(Long idEnvio) { this.idEnvio = idEnvio; }

    public String getNombreRemitente() { return nombreRemitente; }
    public void setNombreRemitente(String nombreRemitente) { this.nombreRemitente = nombreRemitente; }

    public String getDniRemitente() { return dniRemitente; }
    public void setDniRemitente(String dniRemitente) { this.dniRemitente = dniRemitente; }

    public Double getPeso() { return peso; }
    public void setPeso(Double peso) { this.peso = peso; }

    public Double getVolumen() { return volumen; }
    public void setVolumen(Double volumen) { this.volumen = volumen; }

    public String getLugarEnvio() { return lugarEnvio; }
    public void setLugarEnvio(String lugarEnvio) { this.lugarEnvio = lugarEnvio; }

    public String getLugarDestino() { return lugarDestino; }
    public void setLugarDestino(String lugarDestino) { this.lugarDestino = lugarDestino; }
}

