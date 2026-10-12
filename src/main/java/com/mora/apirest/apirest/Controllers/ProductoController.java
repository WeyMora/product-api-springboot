package com.mora.apirest.apirest.Controllers;

import java.util.List;

import com.mora.apirest.apirest.ApirestApplication;
import com.mora.apirest.apirest.Entities.Producto;
import com.mora.apirest.apirest.Repositories.ProductoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;





@RestController 
@RequestMapping ("/productos")
public class ProductoController {

    private final ApirestApplication apirestApplication;
    @Autowired  // Sirve para inyectar dependencias, en este caso el repositorio de productos
    private ProductoRepository productoRepository; // Inyecta el repositorio de productos para poder acceder a la base de datos

    ProductoController(ApirestApplication apirestApplication) {
        this.apirestApplication = apirestApplication;
    }

    @GetMapping
    public List<Producto> getAllProductos(){
        return productoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Producto getProductoById(@PathVariable Long id){
        return productoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se encontro el producto con el Id: " + id));
    }

    @PostMapping 
    public Producto createProducto(@RequestBody Producto product){
        return productoRepository.save(product);
    }

    @PutMapping("/{id}")
    public Producto updateProducto(@PathVariable Long id, @RequestBody Producto productoDetails){
        Producto producto = productoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se encontro el producto con el Id: " + id));
    
        producto.setNombre(productoDetails.getNombre());
        producto.setPrecio(productoDetails.getPrecio());

        return productoRepository.save(producto);
    }

    @DeleteMapping("/{id}")
    public String deleteProducto(@PathVariable Long id){
        Producto producto = productoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se encontro el producto con el Id: " + id));
        productoRepository.delete(producto);
        return "El producto con el Id: " + id + " fue eliminado correctamente";

    }

    
}
