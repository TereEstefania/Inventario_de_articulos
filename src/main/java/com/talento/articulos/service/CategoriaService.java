package com.talento.articulos.service;

import com.talento.articulos.model.CategoriaModel;

import java.util.List;
import java.util.Optional;

public interface CategoriaService {

    //Devuelve la lista completa de articulos
    List<CategoriaModel> listarCategorias();

    //Busca un articulo por su id
    Optional<CategoriaModel> obtenerCategoriaPorId(Long id);

    //Guarda un nuevo articulo
    CategoriaModel guardarCategoria(CategoriaModel categoria);

    //Actualiza un articulo existente 
    CategoriaModel actualizarCategoria(Long id, CategoriaModel categoria);

    //elimina un articulo por su id
    void eliminarCategoria(Long id);
 
}
