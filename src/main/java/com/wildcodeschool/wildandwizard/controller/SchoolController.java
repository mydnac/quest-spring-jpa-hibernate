package com.wildcodeschool.wildandwizard.controller;

import com.wildcodeschool.wildandwizard.entity.School;
import com.wildcodeschool.wildandwizard.entity.Wizard;
import com.wildcodeschool.wildandwizard.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/schools")
public class SchoolController {

    @Autowired
    private SchoolRepository repository;

    @GetMapping()
    public List<School> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public School getSchoolById(@PathVariable Long id) {

        return repository.findById(id).get();
    }

    @PostMapping()
    public School postSchool(@RequestBody School school) {

        return repository.save(school);
    }

    @DeleteMapping("/{id}")
    public boolean deleteSchool(@PathVariable Long id) {

         repository.deleteById(id);
         return true;
    }
}
