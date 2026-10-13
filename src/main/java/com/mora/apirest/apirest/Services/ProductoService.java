package com.mora.apirest.apirest.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mora.apirest.apirest.Entities.Producto;
import com.mora.apirest.apirest.Repositories.ProductoRepository;

@Service // Indica que es un Servicio
public class ProductoService {
    
    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> obtenerTodos(){
        return productoRepository.findAll();
    }

    public Producto obtenerPorId(Long id){
        return productoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("No se encontró el producto con el ID: " + id));
    }

    public Producto crearProducto(Producto producto){
        return productoRepository.save(producto);
    }

    public Producto actualizarProducto(Long id, Producto productoDetalles){
        Producto producto = obtenerPorId(id);
        producto.setNombre(productoDetalles.getNombre());
        producto.setPrecio(productoDetalles.getPrecio());
        return productoRepository.save(producto);
    }

    public void eliminarProducto(Long id){
        Producto producto = obtenerPorId(id);
        productoRepository.delete(producto);
    }
}
