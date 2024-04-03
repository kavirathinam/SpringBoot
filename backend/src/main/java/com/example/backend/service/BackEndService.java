package com.example.backend.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.backend.model.Signup;
import com.example.backend.repository.BackEndRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BackEndService {

    @Autowired
    BackEndRepository ber;

    // Create operation
    public Signup create(Signup sp) {
        return ber.save(sp);
    }

    // Read operation
    public List<Signup> showDetails() {
        return ber.findAll();
    }

    // Read by username
    public Signup getByUsername(String username) {
        Optional<Signup> userOptional = ber.findById(username);
        return userOptional.orElse(null);
    }

    // Update operation
    public Signup update(String username, Signup updatedUser) {
        Optional<Signup> userOptional = ber.findById(username);
        if (userOptional.isPresent()) {
            Signup user = userOptional.get();
            user.setEmail(updatedUser.getEmail());
            user.setPassword(updatedUser.getPassword());
            user.setPhoneno(updatedUser.getPhoneno());
            user.setAddress(updatedUser.getAddress());
            return ber.save(user);
        } else {
            return null;
        }
    }

    // Delete operation
    public boolean delete(String username) {
        Optional<Signup> userOptional = ber.findById(username);
        if (userOptional.isPresent()) {
            ber.deleteById(username);
            return true;
        } else {
            return false;
        }
    }

    // Read all operation
    public List<Signup> getAll() {
        return ber.findAll();
    }
}
