package com.example.demo.repository;

import com.example.demo.controller.dto.PetDTO;
import com.example.demo.controller.dto.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<PetDTO, String>{
    public List<PetDTO> findByOwnerDocument(Integer Id);
}
