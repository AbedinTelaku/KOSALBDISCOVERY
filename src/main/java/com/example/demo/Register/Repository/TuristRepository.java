package com.example.demo.Register.Repository;

import com.example.demo.Register.Models.Turisti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TuristRepository extends JpaRepository<Turisti, Integer> {
    
}
