package com.project.filrouge.dao;

import com.project.filrouge.models.Circle;
import com.project.filrouge.models.Rectangle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RectangleDao extends JpaRepository<Rectangle, Integer> {
    Rectangle findById(int id);
    Rectangle deleteById(int id);
}
