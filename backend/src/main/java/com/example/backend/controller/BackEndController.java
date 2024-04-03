package com.example.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.backend.model.Signup;
import com.example.backend.service.BackEndService;

import java.util.List;

@RestController
public class BackEndController {

    @Autowired
    BackEndService bes;
    
    @PostMapping("/signup")
    public ResponseEntity<Signup> add(@RequestBody Signup sp) {
        Signup newuser = bes.create(sp);
        return new ResponseEntity<>(newuser, HttpStatus.CREATED);
    }

    @GetMapping("/getsignup")
   
   
    public ResponseEntity<List<Signup>> showinfo()
    {
        return new ResponseEntity<>(bes.getAll(),HttpStatus.OK);
    }

    @PutMapping("/signup/{username}")
    public ResponseEntity<Signup> update(@PathVariable String username, @RequestBody Signup sp) {
        Signup updatedUser = bes.update(username, sp);
        if (updatedUser != null) {
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/signup/{username}")
    public ResponseEntity<Void> delete(@PathVariable String username) {
        boolean deleted = bes.delete(username);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/signup")
    public ResponseEntity<List<Signup>> getAll() {
        List<Signup> users = bes.getAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
