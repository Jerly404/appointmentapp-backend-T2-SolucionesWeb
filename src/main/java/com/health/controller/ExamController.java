package com.health.controller;

import com.health.model.Exam;
import com.health.service.IExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exams")
@RequiredArgsConstructor
public class ExamController {
    private final IExamService service;

    @GetMapping
    public List<Exam> findAll() throws Exception{
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Exam findById(@PathVariable("id") Integer id) throws Exception{
        return service.findById(id);
    }

    @PostMapping
    public Exam save(@RequestBody Exam exam) throws Exception{
        return service.save(exam);
    }

    @PutMapping("/{id}")
    public Exam update(@PathVariable("id") Integer id, @RequestBody Exam exam) throws Exception{
        return service.update(exam, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
    }
}
