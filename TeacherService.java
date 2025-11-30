package com.example.schoolmanagement.teacher;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TeacherService {
    private final TeacherRepository repo;

    public TeacherService(TeacherRepository repo) {
        this.repo = repo;
    }

    public List<Teacher> listAll() {
        return repo.findAll();
    }

    public Teacher create(Teacher t) {
        return repo.save(t);
    }

    public Teacher update(Long id, Teacher t) {
        Teacher existing = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found"));
        existing.setName(t.getName());
        existing.setSubject(t.getSubject());
        existing.setEmail(t.getEmail());
        return repo.save(existing);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
