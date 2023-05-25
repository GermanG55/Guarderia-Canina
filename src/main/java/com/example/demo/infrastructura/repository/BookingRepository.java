package com.example.demo.infrastructura.repository;

import com.example.demo.dominio.model.BookingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.sql.Date;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<BookingModel, String> {
    List<BookingModel> findByBookingId(Integer Id);

    @Query(value = "SELECT count(1) FROM BOOKING as a WHERE a.DATE = :date", nativeQuery = true)
    Integer countByDate(@Param("date") Date date);

    @Query(value = "SELECT count(1) FROM BOOKING as a WHERE a.CLIENT_ID = :clientId", nativeQuery = true)
    Integer countByClient(@Param("clientId") Integer clientId);

    @Query(value = "SELECT * FROM BOOKING as a WHERE a.DATE = :date", nativeQuery = true)
    List<BookingModel> findByDate(@Param("date") Date date);
}
