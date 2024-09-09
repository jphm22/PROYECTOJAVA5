package com.utp_example_1.demo_utp_1.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="envios", schema="public")
public class Envio implements Serializable {
    private static final long serialVersionUID = 1L;

    @GeneratedValue(strategy = GenerationType.AUTO, generator = "envios_id_envios_seq")
    @SequenceGenerator(name="envios_id_envios_seq", sequenceName="envios_id_envios_seq", allocationSize=1)
    @Id
    @Column(name = "IDENVIOS")
    private Long id_envios;

    @Column(name = "NOMBREREMITENTE")
    private String nombre_remitente;

    @Column(name = "DNI")
    private String dni_remitente;

    @Column(name = "PESO")
    private Double peso;

    @Column(name = "VOLUMEN")
    private Double volumen;

    @Column(name = "LUGARENVIO")
    private String lugar_envio;

    @Column(name = "LUGARDESTINO")
    private String lugar_destino;

    public Long getIdEnvios() {
        return id_envios;
    }

    public void setIdEnvios(Long idEnvios) {
        this.id_envios = idEnvios;
    }

    public String getNombreRemitente() {
        return nombre_remitente;
    }

    public void setNombreRemitente(String nombreRemitente) {
        this.nombre_remitente = nombreRemitente;
    }

    public String getDniRemitente() {
        return dni_remitente;
    }

    public void setDniRemitente(String dniRemitente) {
        this.dni_remitente = dniRemitente;
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

    public String getLugarEnvio() {
        return lugar_envio;
    }

    public void setLugarEnvio(String lugarEnvio) {
        this.lugar_envio = lugarEnvio;
    }

    public String getLugarDestino() {
        return lugar_destino;
    }

    public void setLugarDestino(String lugarDestino) {
        this.lugar_destino = lugarDestino;
    }

}
