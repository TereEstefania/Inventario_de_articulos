package com.talento.articulos.repository;

import com.talento.articulos.model.ProveedorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepository extends JpaRepository<ProveedorModel, Long> {

}
