package com.mora.apirest.apirest.Controllers;

import com.mora.apirest.apirest.Entities.Producto;
import com.mora.apirest.apirest.Repositories.ProductoRepository;
import com.mora.apirest.apirest.Services.ProductoService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/productos")
public class ProductoController {
    
    @Autowired 
    private ProductoService productoService;

    @GetMapping
    public List<Producto> getAllProductos(){
        return productoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Producto getProductoById(@PathVariable Long id){
        return productoService.obtenerPorId(id);
    }

    @PostMapping
    public Producto createProducto(@Valid @RequestBody Producto producto) {
        return productoService.crearProducto(producto);
    }

    @PutMapping("/{id}")
    public Producto updateProducto(@PathVariable Long id, @Valid @RequestBody Producto producto) {
        return productoService.actualizarProducto(id, producto);
    }

    @DeleteMapping("/{id}")
    public void deleteProducto(@PathVariable Long id){
        productoService.eliminarProducto(id);
    }
    
}