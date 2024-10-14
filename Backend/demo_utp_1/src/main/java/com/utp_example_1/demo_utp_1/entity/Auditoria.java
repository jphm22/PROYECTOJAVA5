package com.utp_example_1.demo_utp_1.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tt_auditoria", schema="public")

public class Auditoria {

    private static final long serialVersionUID = -4404733423008657622L;

    @GeneratedValue(strategy = GenerationType.AUTO, generator = "tt_auditoria_seq")
    @SequenceGenerator(name="tt_auditoria_seq", sequenceName="tt_auditoria_seq", allocationSize=1)
    @Id
    @Column(name = "idauditoria")
    private Long idaudi;

    @Column(name = "usuario")
    private String usuario;

    @PrePersist
    protected void onCreate() {
        fecha_registro = new Date();
    }


    @Column(name = "fecha_registro")
    private Date fecha_registro;

    @Column(name = "ip_maquina")
    private String ip_maquina;


    @Column(name = "IDPERSONA")
    private Long idpersona;


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

    public Long getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(Long idpersona) {
        this.idpersona = idpersona;
    }
}

