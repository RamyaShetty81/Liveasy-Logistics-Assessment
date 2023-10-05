package com.example.Liveeasy.assignment;

;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface LoadRepository extends JpaRepository<Load,Integer>{
    List<Load> findByShipperId(String shipperId);
}
