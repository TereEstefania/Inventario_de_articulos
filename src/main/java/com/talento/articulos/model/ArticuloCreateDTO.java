package com.talento.articulos.model;

import java.util.List;

public record ArticuloCreateDTO(
    String nombre,
    Double precio,
    Long categoriaId,
    List<Long> proveedoresIds
) {}
