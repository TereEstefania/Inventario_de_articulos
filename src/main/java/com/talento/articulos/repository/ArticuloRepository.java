package com.talento.articulos.repository;

import com.talento.articulos.model.ArticuloModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//import java.util.List;

@Repository
public interface ArticuloRepository extends JpaRepository<ArticuloModel, Long> {

} 
