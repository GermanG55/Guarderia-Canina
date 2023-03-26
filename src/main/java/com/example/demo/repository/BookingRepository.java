package com.example.demo.repository;

import com.example.demo.controller.dto.BookingDTO;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<BookingDTO, String> {
    List<BookingDTO> findByBookingId(Integer Id);

    @Query(value = "SELECT * FROM BOOKING as a WHERE a.DATE = :date", nativeQuery = true)
    List<BookingDTO> findByDate(@Param("date") String date);
}
