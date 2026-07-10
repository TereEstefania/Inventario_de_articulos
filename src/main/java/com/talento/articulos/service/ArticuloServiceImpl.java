package com.talento.articulos.service;

import com.talento.articulos.model.ArticuloModel;
import com.talento.articulos.model.CategoriaModel;
import com.talento.articulos.repository.ArticuloRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticuloServiceImpl implements ArticuloService{
    
    private final ArticuloRepository articuloRepository;

    public ArticuloServiceImpl(ArticuloRepository articuloRepository){
        this.articuloRepository = articuloRepository;
    }
 
    @Override
    public List<ArticuloModel> listarArticulos(){
        return articuloRepository.findAll();
    }

    @Override
    public Optional<ArticuloModel> obtenerArticuloPorId(Long id){
        return articuloRepository.findById(id);
    }

    @Override
    public ArticuloModel guardarArticulo(ArticuloModel articulo, CategoriaModel categoria){
        return articuloRepository.save(articulo);
    }

    @Override
    public ArticuloModel actualizarArticulo(Long id, ArticuloModel articulo){
        articulo.setId(id);
        return articuloRepository.save(articulo);
    }

    @Override
    public void eliminarArticulo(Long id){
        articuloRepository.deleteById(id);
    }

}
