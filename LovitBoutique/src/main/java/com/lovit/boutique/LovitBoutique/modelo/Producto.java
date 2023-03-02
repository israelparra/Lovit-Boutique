package com.lovit.boutique.LovitBoutique.modelo;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_producto")
    private Integer id;

    @NotBlank
    private String titulo;

    @NotBlank
    private String descripcion;

    @NotNull
    private Double largo;

    @NotNull
    private Double ancho;

    @NotNull
    private Double peso;

    @NotNull
    private Double precio;

    @NotBlank
    private String color;

    @NotNull
    private Integer minimoVenta;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fechaRegistro;

    private String rutaPortada;

    @NotEmpty
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="tipo_producto", joinColumns = @JoinColumn(name="id_producto"),inverseJoinColumns = @JoinColumn(name = "id_tipo"))
    private List<Tipo> tipos;

    @Transient
    private MultipartFile portada;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getLargo() {
        return largo;
    }

    public void setLargo(Double largo) {
        this.largo = largo;
    }

    public Double getAncho() {
        return ancho;
    }

    public void setAncho(Double ancho) {
        this.ancho = ancho;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getMinimoVenta() {
        return minimoVenta;
    }

    public void setMinimoVenta(Integer minimoVenta) {
        this.minimoVenta = minimoVenta;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getRutaPortada() {
        return rutaPortada;
    }

    public void setRutaPortada(String rutaPortada) {
        this.rutaPortada = rutaPortada;
    }

    public List<Tipo> getTipos() {
        return tipos;
    }

    public void setTipos(List<Tipo> tipos) {
        this.tipos = tipos;
    }

    public MultipartFile getPortada() {
        return portada;
    }

    public void setPortada(MultipartFile portada) {
        this.portada = portada;
    }

    public Producto() {
        super();
    }

    public Producto(Integer id, @NotBlank String titulo, @NotBlank String descripcion, @NotNull Double largo,
                    @NotNull Double ancho, @NotNull Double peso, @NotNull Double precio, @NotBlank String color,
                    @NotNull Integer minimoVenta, @NotNull LocalDate fechaRegistro, String rutaPortada,
                    @NotEmpty List<Tipo> tipos, MultipartFile portada) {
        super();
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.largo = largo;
        this.ancho = ancho;
        this.peso = peso;
        this.precio = precio;
        this.color = color;
        this.minimoVenta = minimoVenta;
        this.fechaRegistro = fechaRegistro;
        this.rutaPortada = rutaPortada;
        this.tipos = tipos;
        this.portada = portada;
    }


    public Producto(@NotBlank String titulo, @NotBlank String descripcion, @NotNull Double largo,
                    @NotNull Double ancho, @NotNull Double peso, @NotNull Double precio, @NotBlank String color,
                    @NotNull Integer minimoVenta, @NotNull LocalDate fechaRegistro, String rutaPortada,
                    @NotEmpty List<Tipo> tipos, MultipartFile portada) {
        super();
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.largo = largo;
        this.ancho = ancho;
        this.peso = peso;
        this.precio = precio;
        this.color = color;
        this.minimoVenta = minimoVenta;
        this.fechaRegistro = fechaRegistro;
        this.rutaPortada = rutaPortada;
        this.tipos = tipos;
        this.portada = portada;
    }


}
