package com.juan.BestMeals.repository;

import com.juan.BestMeals.model.Prato;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PratoRepository extends JpaRepository<Prato, Long> {
}
