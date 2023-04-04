package com.example.demo.repository;

import com.example.demo.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet, String>{
    public List<Pet> findByOwnerDocument(Integer Id);
    @Query(value = "SELECT count(1) FROM PET as a WHERE a.CLIENT = :ownerDocument", nativeQuery = true)
    Integer countByClient(@Param("ownerDocument") Integer ownerDocument);
}
