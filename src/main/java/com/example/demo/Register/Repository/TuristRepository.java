package com.example.demo.Register.Repository;

import com.example.demo.Register.Models.Turisti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface TuristRepository extends JpaRepository<Turisti, Integer> {
    
    @Query("delete t from Turist t where t.id=?1")
    public void deleteById (int id);
}
