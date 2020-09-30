package com.project.filrouge.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.filrouge.models.Circle;

@Repository
public interface CircleDao extends JpaRepository<Circle, Integer> {
    Circle findById(int id);
    Circle deleteById(int id);
}
