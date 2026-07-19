package com.talento.articulos.service;

import com.talento.articulos.model.*;

import java.util.List;
//import java.util.Optional;

public interface ArticuloService {
    
    //Devuelve la lista completa de articulos
    List<ArticuloDTO> listarArticulos();

    //Busca un articulo por su id
    //Optional<ArticuloModel> obtenerPorId(Long id);

    //Guarda un nuevo articulo
    ArticuloDTO guardarArticulo(ArticuloCreateDTO articulo);

    //Actualiza un articulo existente 
    ArticuloModel actualizarArticulo(Long id, ArticuloModel articulo);

    //elimina un articulo por su id
    void eliminarArticulo(Long id);

  
}
