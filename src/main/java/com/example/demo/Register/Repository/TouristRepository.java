package com.example.demo.Register.Repository;

import com.example.demo.Register.Models.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

@Repository
public interface TouristRepository extends JpaRepository<Tourist, Integer> {
    
    @Query("delete t from Tourist t where t.id=?1")
    public void deleteById (int id);

    @Query("select t from Tourist t where t.username=?1 and t.password=?2")
    Optional<Tourist> findTouristByUsernameAndPassword(String username, String pass);
}
