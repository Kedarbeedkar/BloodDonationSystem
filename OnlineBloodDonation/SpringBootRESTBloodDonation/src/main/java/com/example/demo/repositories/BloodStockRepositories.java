package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.BloodStock;

public interface BloodStockRepositories extends JpaRepository<BloodStock, Integer> {

}
