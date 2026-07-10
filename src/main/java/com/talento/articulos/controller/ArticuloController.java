package com.talento.articulos.controller;

import com.talento.articulos.model.ArticuloModel;
import com.talento.articulos.model.CategoriaModel;
import com.talento.articulos.service.ArticuloService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/articulos")
public class ArticuloController {

    private final ArticuloService articuloService;

    public ArticuloController(ArticuloService articuloService){
        this.articuloService = articuloService;
    }
    
    @GetMapping
    public List<ArticuloModel> listar(){
        return articuloService.listarArticulos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticuloModel> obtenerPorId(@PathVariable Long id){
        return articuloService.obtenerArticuloPorId(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ArticuloModel crear(@RequestBody ArticuloModel articulo, CategoriaModel categoria){
        return articuloService.guardarArticulo(articulo, categoria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArticuloModel> actualizar(@PathVariable Long id, @RequestBody ArticuloModel articulo){
        if(articuloService.obtenerArticuloPorId(id).isEmpty()){
            return ResponseEntity.notFound().build();
        }

        ArticuloModel articuloActualizado = articuloService.actualizarArticulo(id, articulo);
        return ResponseEntity.ok(articuloActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        if(articuloService.obtenerArticuloPorId(id).isEmpty()){
            return ResponseEntity.notFound().build();
        }

        articuloService.eliminarArticulo(id);
        return ResponseEntity.noContent().build();
    }
}
