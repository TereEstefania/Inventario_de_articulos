package com.talento.articulos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import java.util.List;

@Entity
@Table(name = "articulos")
public class ArticuloModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre", nullable = false, length = 200)
    private String nombre;

    @Column(name = "precio", nullable = false)
    private Double precio;


    @ManyToOne(fetch = FetchType.LAZY) // LAZY por rendimiento, carga la categoría solo si la necesitas
    @JoinColumn(name = "categoria_id", nullable = false) // Define el nombre de la FK en la BD
    @JsonIgnoreProperties("articulos")
    private CategoriaModel categoria;

    @ManyToMany
    @JoinTable(
    name = "articulos_proveedores",
    joinColumns = @JoinColumn(name = "articulo_id"),
    inverseJoinColumns = @JoinColumn(name = "proveedor_id")
    )
    private List<ProveedorModel> proveedores;

    public ArticuloModel(){

    }

    public ArticuloModel(Long id, String nombre, Double precio, CategoriaModel categoria, List<ProveedorModel> proveedores){
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
        this.proveedores = proveedores;
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

    public Double getPrecio(){
        return precio;
    }

    public void setPrecio(Double precio){
        this.precio = precio;
    }

    public CategoriaModel getCategoria(){
        return categoria; 
    }

    public void setConcentria(CategoriaModel categoria){ 
        this.categoria = categoria; 
    }

    public List<ProveedorModel> getProveedores(){
        return proveedores;
    }

    public void setProveedores(List<ProveedorModel> proveedores){
        this.proveedores = proveedores;
    }

}
