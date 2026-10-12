package com.mora.apirest.apirest.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.mora.apirest.apirest.Entities.Producto;
public interface ProductoRepository extends JpaRepository<Producto, Long>{

}
