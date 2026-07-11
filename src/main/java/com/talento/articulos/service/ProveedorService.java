package com.talento.articulos.service;

import com.talento.articulos.model.ProveedorModel;

import java.util.List;
import java.util.Optional;

public interface ProveedorService {

    List<ProveedorModel> listarProveedores();

    Optional<ProveedorModel> obtenerProveedorPorId(Long id);

    ProveedorModel guardarProveedor(ProveedorModel proveedor);

    ProveedorModel actualizarProveedor(Long id, ProveedorModel proveedor);

    void eliminarProveedor(Long id);
}
