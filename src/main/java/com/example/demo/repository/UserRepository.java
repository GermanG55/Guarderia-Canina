package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.demo.controller.dto.UserDTO;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserDTO, String>{
    @Query(value = "SELECT a.* FROM CLIENT as a INNER JOIN BOOKING as b ON a.DOCUMENT = b.CLIENT_ID WHERE a.DOCUMENT = ?1",
            nativeQuery = true)
    public List<UserDTO> findBookingByDocument(Integer Id);
    @Query(value = "SELECT a.* FROM CLIENT as a INNER JOIN PET as b ON a.DOCUMENT = b.CLIENT WHERE a.DOCUMENT = ?1",
            nativeQuery = true)
    public List<UserDTO> findPetsByDocument(Integer Id);
}
