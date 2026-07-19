package com.talento.articulos.model;

import java.util.List;

public record ArticuloDTO(
    Long id,
    String nombre,
    Double precio,
    String categoria,
    List<String> proveedores
) {}
