package com.example.demo.repository;

import com.example.demo.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.sql.Date;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, String> {
    List<Booking> findByBookingId(Integer Id);
    @Query(value = "SELECT count(1) FROM BOOKING as a WHERE a.DATE = :date", nativeQuery = true)
    Integer countByDate(@Param("date") Date date);
    @Query(value = "SELECT count(1) FROM BOOKING as a WHERE a.CLIENT_ID = :clientId", nativeQuery = true)
    Integer countByClient(@Param("clientId") Integer clientId);
    @Query(value = "SELECT * FROM BOOKING as a WHERE a.DATE = :date", nativeQuery = true)
    List<Booking> findByDate(@Param("date") Date date);
}
