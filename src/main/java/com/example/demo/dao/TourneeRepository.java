package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Tournee;

public interface TourneeRepository extends JpaRepository<Tournee, Long>{

}
