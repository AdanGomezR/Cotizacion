package com.CotizaCreditos.CotizaCreditos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CotizaCreditos.CotizaCreditos.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
	
	Optional<Producto> findByNombre_producto(String nombre_producto);

}
