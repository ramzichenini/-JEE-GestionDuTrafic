package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Station;

public interface StationRepository extends JpaRepository<Station, Long>{

}
