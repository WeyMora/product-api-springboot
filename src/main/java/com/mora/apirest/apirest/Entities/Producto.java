package com.mora.apirest.apirest.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity 
@Table(name = "productos") // Tabla exacta en PostgreSQL   
public class Producto {

    @Id 
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre del producto no puede estar vacío")
    private String nombre;

    @NotNull (message = "El precio del producto no puede ser nulo")
    @Min (value = 0, message = "El precio del producto debe ser mayor o igual a cero")
    private Double precio;
    
    
    
    // Getters And Setters

    public void setId(Long id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setPrecio(Double precio) { this.precio = precio; }

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public Double getPrecio() { return precio; }

    
}
