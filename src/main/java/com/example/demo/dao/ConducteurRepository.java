package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Conducteur;

public interface ConducteurRepository extends JpaRepository<Conducteur, Long>{

}
