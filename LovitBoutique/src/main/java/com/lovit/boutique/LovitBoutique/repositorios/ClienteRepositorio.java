package com.lovit.boutique.LovitBoutique.repositorios;

import com.lovit.boutique.LovitBoutique.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepositorio extends JpaRepository<Cliente, Integer> {
}
