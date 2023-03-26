package com.example.demo.repository;

import com.example.demo.controller.dto.BookingDTO;
import com.example.demo.controller.dto.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<BookingDTO, String>{
    public List<BookingDTO> findByBookedDocument(Integer Id);
}
