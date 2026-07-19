package com.talento.articulos.controller;

import com.talento.articulos.model.ProveedorModel;
import com.talento.articulos.service.ProveedorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/articulos/proveedores")
public class ProveedorController {

    private final ProveedorService proveedorService;

    public ProveedorController(ProveedorService proveedorService){
        this.proveedorService = proveedorService;
    }

    @GetMapping
    public List<ProveedorModel> listar(){
        return proveedorService.listarProveedores();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProveedorModel> obtenerPorId(@PathVariable Long id){
        return proveedorService.obtenerProveedorPorId(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ProveedorModel crearProveedor(@RequestBody ProveedorModel proveedor){
        return proveedorService.guardarProveedor(proveedor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProveedorModel> actualizarProveedor(@PathVariable Long id, @RequestBody ProveedorModel proveedor){
        if(proveedorService.obtenerProveedorPorId(id).isEmpty()){
            return ResponseEntity.notFound().build();
        }

        ProveedorModel proveedorActualizado = proveedorService.actualizarProveedor(id, proveedor);
        return ResponseEntity.ok(proveedorActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProveedor(@PathVariable Long id){
        if(proveedorService.obtenerProveedorPorId(id).isEmpty()){
            return ResponseEntity.notFound().build();
        }

        proveedorService.eliminarProveedor(id);
        return ResponseEntity.noContent().build();
    }
    

}
