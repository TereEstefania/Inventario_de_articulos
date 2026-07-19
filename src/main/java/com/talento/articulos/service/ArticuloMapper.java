package com.talento.articulos.service;

import com.talento.articulos.model.ArticuloModel;
import com.talento.articulos.model.ProveedorModel;
import com.talento.articulos.model.ArticuloDTO;
import com.talento.articulos.model.ArticuloCreateDTO;
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

    // El nuevo método para el POST
    @Mapping(target = "id", ignore = true) // La BD genera el ID autoincremental
    @Mapping(target = "categoria", ignore = true) // Lo cargamos manualmente en el Service
    @Mapping(target = "proveedores", ignore = true) // Lo cargamos manualmente en el Service
    ArticuloModel toEntity(ArticuloCreateDTO dto);

    // Método de ayuda para extraer solo los nombres de la lista de proveedores
    @Named("mapProveedores")
    default List<String> mapProveedores(List<ProveedorModel> proveedores) {
        if (proveedores == null) return List.of();
        return proveedores.stream()
                .map(ProveedorModel::getNombre)
                .toList();
    }
}
