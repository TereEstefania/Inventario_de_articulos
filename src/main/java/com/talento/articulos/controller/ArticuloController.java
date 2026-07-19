package com.talento.articulos.controller;

import com.talento.articulos.model.ArticuloModel;
import com.talento.articulos.model.ArticuloDTO;
import com.talento.articulos.service.ArticuloService;
import com.talento.articulos.service.ArticuloServiceImpl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/articulos")
public class ArticuloController {

    private final ArticuloServiceImpl articuloService;

    public ArticuloController(ArticuloServiceImpl articuloService){
        this.articuloService = articuloService;
    }
    
    @GetMapping
    public List<ArticuloDTO> listar(){
        return articuloService.listarArticulos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticuloDTO> obtenerPorId(@PathVariable Long id){
        
        ArticuloDTO articuloDTO = articuloService.obtenerArticuloPorId(id);
    
        return ResponseEntity.ok(articuloDTO);
    }

    @PostMapping
    public ArticuloModel crear(@RequestBody ArticuloModel articulo){
        return articuloService.guardarArticulo(articulo);
    }

    // @PutMapping("/{id}")
    // public ResponseEntity<ArticuloDTO> actualizar(@PathVariable Long id, @RequestBody ArticuloDTO articulo){
    //     if(articuloService.obtenerArticuloPorId(id).isEmpty()){
    //         return ResponseEntity.ok(articuloDTO);
    //     }

    //     ArticuloDTO articuloActualizado = articuloService.actualizarArticulo(id, articulo);
    //     return ResponseEntity.ok(articuloActualizado);
    // }

    // @DeleteMapping("/{id}")
    // public ResponseEntity<Void> eliminar(@PathVariable Long id){
    //     if(articuloService.obtenerArticuloPorId(id).isEmpty()){
    //         return ResponseEntity.notFound().build();
    //     }

    //     articuloService.eliminarArticulo(id);
    //     return ResponseEntity.noContent().build();
    // }
}
