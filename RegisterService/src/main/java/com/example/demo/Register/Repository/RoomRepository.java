package com.example.demo.Register.Repository;

import com.example.demo.Register.Models.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room,Integer> {

    @Modifying
    @Transactional
    @Query(value = "select * from room r where r.business_id=?1", nativeQuery = true)
    public List<Room> getRoomsByBusinessId(int businessId);
}
