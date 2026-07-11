package com.talento.articulos.service;

import com.talento.articulos.model.ProveedorModel;
import com.talento.articulos.repository.ProveedorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorServiceImpl implements ProveedorService{
    
    private final ProveedorRepository proveedorRepository;

    public ProveedorServiceImpl(ProveedorRepository proveedorRepository){
        this.proveedorRepository = proveedorRepository;
    }

    @Override
    public List<ProveedorModel> listarProveedores(){
        return proveedorRepository.findAll();
    }

    @Override
    public Optional<ProveedorModel> obtenerProveedorPorId(Long id){
        return proveedorRepository.findById(id);
    }

    @Override
    public ProveedorModel guardarProveedor(ProveedorModel proveedor){
        return proveedorRepository.save(proveedor);
    }

    @Override
    public ProveedorModel actualizarProveedor(Long id, ProveedorModel proveedor){
        proveedor.setId(id);
        return proveedorRepository.save(proveedor);
    }

    @Override
    public void eliminarProveedor(Long id){
        proveedorRepository.deleteById(id);
    }
}
