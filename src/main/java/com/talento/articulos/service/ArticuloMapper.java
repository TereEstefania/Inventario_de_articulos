package com.talento.articulos.service;

import com.talento.articulos.model.ArticuloModel;
import com.talento.articulos.model.ProveedorModel;
import com.talento.articulos.model.ArticuloDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import java.util.List;

@Mapper(componentModel = "spring") // Lo registra como un Bean de Spring
public interface ArticuloMapper {

    @Mapping(source = "categoria.nombre", target = "categoria")
    @Mapping(source = "proveedores", target = "proveedores", qualifiedByName = "mapProveedores")
    ArticuloDTO toDTO(ArticuloModel articulo);

    @Mapping(source = "categoria.nombre", target = "categoria")
    @Mapping(source = "proveedores", target = "proveedores", qualifiedByName = "mapProveedores")
    List<ArticuloDTO> toDTOList(List<ArticuloModel> articulo);

    // Método de ayuda para extraer solo los nombres de la lista de proveedores
    @Named("mapProveedores")
    default List<String> mapProveedores(List<ProveedorModel> proveedores) {
        if (proveedores == null) return List.of();
        return proveedores.stream()
                .map(ProveedorModel::getNombre)
                .toList();
    }
}
