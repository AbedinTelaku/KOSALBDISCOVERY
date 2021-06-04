package com.example.demo.Register.Repository;

import com.example.demo.Register.Models.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City,Integer> {

    @Modifying
    @Transactional
    @Query(value = "select name from city", nativeQuery = true)
    public List<String> getCitiesNames();

}
