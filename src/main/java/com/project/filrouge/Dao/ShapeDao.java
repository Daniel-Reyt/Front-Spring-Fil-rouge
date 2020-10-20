package com.project.filrouge.Dao;

import com.project.filrouge.Form.Shape;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShapeDao extends JpaRepository<Shape, Integer> {
}
