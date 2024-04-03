package com.example.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.backend.model.Signup;

import java.util.List;
import java.util.Optional;

public interface BackEndRepository extends JpaRepository<Signup, String> {

    Optional<Signup> findByUsername(String username);

    List<Signup> findByEmail(String email);

    List<Signup> findByPhoneno(String phoneno);

    List<Signup> findByAddress(String address);
    @Query("SELECT s FROM Signup s WHERE s.username LIKE %:keyword% OR s.email LIKE %:keyword%")
    List<Signup> search(@Param("keyword") String keyword);

    @Query("SELECT COUNT(s) FROM Signup s")
    long countUsers();
}
