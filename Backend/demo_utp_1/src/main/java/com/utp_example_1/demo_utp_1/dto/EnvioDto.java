package com.utp_example_1.demo_utp_1.dto;

import jakarta.persistence.Column;

import java.util.Date;

public class EnvioDto {

    private Long idEnvio;
    private String nombreRemitente;
    private String dniRemitente;
    private Double peso;
    private Double volumen;
    private String lugarEnvio;
    private String lugarDestino;
    private Long idaudi;
    private String usuario;
    private Date fecha_registro;
    private String ip_maquina;

    public Long getIdEnvio() {
        return idEnvio;
    }

    public void setIdEnvio(Long idEnvio) {
        this.idEnvio = idEnvio;
    }

    public String getNombreRemitente() {
        return nombreRemitente;
    }

    public void setNombreRemitente(String nombreRemitente) {
        this.nombreRemitente = nombreRemitente;
    }

    public String getDniRemitente() {
        return dniRemitente;
    }

    public void setDniRemitente(String dniRemitente) {
        this.dniRemitente = dniRemitente;
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
        return lugarEnvio;
    }

    public void setLugarEnvio(String lugarEnvio) {
        this.lugarEnvio = lugarEnvio;
    }

    public String getLugarDestino() {
        return lugarDestino;
    }

    public void setLugarDestino(String lugarDestino) {
        this.lugarDestino = lugarDestino;
    }

    public Long getIdaudi() {
        return idaudi;
    }

    public void setIdaudi(Long idaudi) {
        this.idaudi = idaudi;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public String getIp_maquina() {
        return ip_maquina;
    }

    public void setIp_maquina(String ip_maquina) {
        this.ip_maquina = ip_maquina;
    }
}
