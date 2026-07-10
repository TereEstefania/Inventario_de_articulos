package com.talento.articulos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "proveedores")
public class ProveedorModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name =  "nombre", nullable = false, length = 200)
    private String nombre;

    @ManyToMany(mappedBy = "proveedores", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("proveedores")
    private List<ArticuloModel> articulos;

    public ProveedorModel(){

    }

    public ProveedorModel(Long id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public List<ArticuloModel> getArticulos(){
        return articulos;
    }

    public void setArticulos(List<ArticuloModel> articulos){
        this.articulos = articulos;
    }

}
