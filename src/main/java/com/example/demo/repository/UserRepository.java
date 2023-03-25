package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.controller.dto.UserDTO;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserDTO, String>{
    public List<UserDTO> findByDocument(Integer Id);
}
