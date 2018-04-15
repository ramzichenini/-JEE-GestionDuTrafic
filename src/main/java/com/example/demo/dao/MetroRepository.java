package com.example.demo.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;



import com.example.demo.entities.Metro;

public interface MetroRepository extends JpaRepository<Metro, Long>{
	
	
	
	public List<Metro> findByligne(int n);
	public Page<Metro> findByligne(int n, Pageable pageable);
	
	
	
}
