package com.talento.articulos.controller;

import com.talento.articulos.model.CategoriaModel;
import com.talento.articulos.service.CategoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/articulos/categorias")
public class CategoriaController {
    
    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService){
        this.categoriaService = categoriaService;
    }
    
    @GetMapping
    public List<CategoriaModel> listar(){
        return categoriaService.listarCategorias();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaModel> obtenerPorId(@PathVariable Long id){
        return categoriaService.obtenerCategoriaPorId(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public CategoriaModel crear(@RequestBody CategoriaModel categoria){
        return categoriaService.guardarCategoria(categoria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaModel> actualizar(@PathVariable Long id, @RequestBody CategoriaModel categoria){
        if(categoriaService.obtenerCategoriaPorId(id).isEmpty()){
            return ResponseEntity.notFound().build();
        }

        CategoriaModel categoriaActualizada = categoriaService.actualizarCategoria(id, categoria);
        return ResponseEntity.ok(categoriaActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        if(categoriaService.obtenerCategoriaPorId(id).isEmpty()){
            return ResponseEntity.notFound().build();
        }

        categoriaService.eliminarCategoria(id);
        return ResponseEntity.noContent().build();
    }
}
