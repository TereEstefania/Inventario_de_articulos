package com.talento.articulos.service;

import com.talento.articulos.model.ArticuloModel;
import com.talento.articulos.model.CategoriaModel;

import java.util.List;
import java.util.Optional;

public interface ArticuloService {
    
    //Devuelve la lista completa de articulos
    List<ArticuloModel> listarArticulos();

    //Busca un articulo por su id
    Optional<ArticuloModel> obtenerArticuloPorId(Long id);

    //Guarda un nuevo articulo
    ArticuloModel guardarArticulo(ArticuloModel articulo, CategoriaModel categoria);

    //Actualiza un articulo existente 
    ArticuloModel actualizarArticulo(Long id, ArticuloModel articulo);

    //elimina un articulo por su id
    void eliminarArticulo(Long id);

  
}
