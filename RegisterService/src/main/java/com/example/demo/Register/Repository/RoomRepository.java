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

    @Query(value = "select * from room r where r.is_available=1 and r.room_type=?1", nativeQuery = true)
    public List<Room> findAllAvailableRooms(String roomType);

    @Query(value = "select * from room r where r.room_type=?1", nativeQuery = true)
    public List<Room> getAllRoomsByType(String roomType);

    @Modifying
    @Transactional
    @Query(value = "update room  set is_available=0 where room_number=?1", nativeQuery = true)
    public void setReservedRoomUnavailable(int roomNumber);

    @Modifying
    @Transactional
    @Query(value = "update room  set is_available=1 where room_number=?1", nativeQuery = true)
    public void setRoomAvailable(int roomNumber);

    @Query(value = "select * from room r where r.room_number=?1", nativeQuery = true)
    public Room getRoomByRoomNumber(int roomNumber);
}
