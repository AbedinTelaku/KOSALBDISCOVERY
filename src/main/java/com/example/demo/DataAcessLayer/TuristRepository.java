package com.example.demo.DataAccessLayer;

import com.example.demo.Register.Models.Turist;
import org.springframework.stereotype.Repository;

@Repository
public interface TuristRepository implements JpaRepository<Turist,Integer>{
    
}
