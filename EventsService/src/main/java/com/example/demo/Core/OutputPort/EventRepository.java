package com.example.demo.Core.OutputPort;

import com.example.demo.Core.Entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

import javax.transaction.Transactional;

@Repository
public interface EventRepository extends JpaRepository<Event,Integer> {

    @Modifying
    @Transactional

    @Query(value = "select * from event where status=:status ", nativeQuery = true)
    public List<Event> findByStatus(@Param("status") String status);

    //order by startDate desc

}
