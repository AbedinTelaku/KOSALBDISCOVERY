package com.example.demo.Register.Repository;

import com.example.demo.Register.Models.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessRepository extends JpaRepository<Business,Integer> {

    @Modifying

    @Query(value = "update business set business_id=:businessId,business_activity=:businessActivity,business_number=:businessNumber,email=:email,fiscal_Number=:fiscalNumber,name=:name,owner_id=:ownerId,password=:password,tel_number=:telNumber,username=:username,role=:role where business_id=:id",nativeQuery = true)
    public void updateBusiness(@Param("id") int id, @Param("businessId") String businessId, @Param("businessActivity") String businessActivity, @Param("businessNumber") String businessNumber,@Param("email") String email,@Param("fiscal_Number") String fiscal_Number,@Param("name") String name,@Param("ownerId") String ownerId,@Param("password") String password,@Param("telNumber") String telNumber,@Param("username") String username,@Param("role") String role);

    @Query(value = "select * from business where username=:username", nativeQuery = true)
    public Business findBusinessByUsername(@Param("username") String username);
}
