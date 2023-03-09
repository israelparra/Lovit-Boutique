package com.lovit.boutique.LovitBoutique.modelo;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_cliente")
    private Integer id;

    @NotBlank
    private String nombre;

    @NotBlank
    private String correo;

    @NotBlank
    private String direccion;

    @NotBlank
    private String numTelefono;

    @NotBlank
    private String mensaje;

    public Cliente() {
    }

    public Cliente(String nombre, String correo, String direccion, String numTelefono, String mensaje) {
        this.nombre = nombre;
        this.correo = correo;
        this.direccion = direccion;
        this.numTelefono = numTelefono;
        this.mensaje = mensaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(String numTelefono) {
        this.numTelefono = numTelefono;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
