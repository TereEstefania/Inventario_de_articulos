package com.talento.articulos.service;

import com.talento.articulos.model.CategoriaModel;
import com.talento.articulos.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService {
    
    private final CategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository){
        this.categoriaRepository = categoriaRepository;
    }
    
    @Override
    public List<CategoriaModel> listarCategorias(){
        return categoriaRepository.findAll();
    }

    @Override
    public Optional<CategoriaModel> obtenerCategoriaPorId(Long id){
        return categoriaRepository.findById(id);
    }

    @Override
    public CategoriaModel guardarCategoria(CategoriaModel categoria){
        return categoriaRepository.save(categoria);
    }

    @Override
    public CategoriaModel actualizarCategoria(Long id, CategoriaModel categoria){
        return categoriaRepository.save(categoria);
    }

    @Override
    public void eliminarCategoria(Long id){
        categoriaRepository.deleteById(id);
    }
}
