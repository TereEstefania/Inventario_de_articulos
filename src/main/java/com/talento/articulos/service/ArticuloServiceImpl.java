package com.talento.articulos.service;

import com.talento.articulos.model.*;
// import com.talento.articulos.model.ArticuloDTO;
// import com.talento.articulos.model.ArticuloModel;
// import com.talento.articulos.model.CategoriaModel;
// import com.talento.articulos.model.ProveedorModel;

import com.talento.articulos.service.ArticuloMapper;

import jakarta.persistence.EntityNotFoundException;

import com.talento.articulos.repository.ArticuloRepository;
import com.talento.articulos.repository.CategoriaRepository;
import com.talento.articulos.repository.ProveedorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//import java.util.Optional;

@Service
public class ArticuloServiceImpl implements ArticuloService{
    
    @Autowired
    private ArticuloRepository articuloRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Autowired
    private ArticuloMapper articuloMapper;

    public ArticuloServiceImpl(ArticuloRepository articuloRepository){
        this.articuloRepository = articuloRepository;
    }
 
    @Override
    public List<ArticuloDTO> listarArticulos(){
        List<ArticuloModel> articulos = articuloRepository.findAll();

        return articuloMapper.toDTOList(articulos);
    }

    
    public ArticuloDTO obtenerArticuloPorId(Long id){
        ArticuloModel articulo = articuloRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("No encontrado"));
            
        return articuloMapper.toDTO(articulo);
    }

    @Override
    public ArticuloDTO guardarArticulo(ArticuloCreateDTO dto){
        // 1. Convertimos los campos básicos del DTO a la Entidad usando MapStruct
        ArticuloModel articulo = articuloMapper.toEntity(dto);

        // 2. Buscamos la categoría por ID y se la asignamos
        CategoriaModel categoria = categoriaRepository.findById(dto.categoriaId())
            .orElseThrow(() -> new EntityNotFoundException("Categoría no encontrada"));
        articulo.setCategoria(categoria);

        // 3. Buscamos los proveedores por sus IDs y los asociamos
        if (dto.proveedoresIds() != null && !dto.proveedoresIds().isEmpty()) {
            List<ProveedorModel> proveedores = proveedorRepository.findAllById(dto.proveedoresIds());
            articulo.setProveedores(proveedores);
        }

        // 4. Guardamos en la base de datos
        ArticuloModel articuloGuardado = articuloRepository.save(articulo);

        // 5. Retornamos el DTO de salida (el mismo del GET) para confirmar la creación
        return articuloMapper.toDTO(articuloGuardado);
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
