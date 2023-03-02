package com.lovit.boutique.LovitBoutique.repositorios;

import com.lovit.boutique.LovitBoutique.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepositorio extends JpaRepository<Producto, Integer> {
}
