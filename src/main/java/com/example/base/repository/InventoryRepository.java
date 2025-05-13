package com.example.base.repository;

import com.example.base.domain.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository <Inventario, Long>{
}
