package com.project.filrouge.dao;

import com.project.filrouge.models.Rectangle;
import com.project.filrouge.models.Square;
import com.project.filrouge.models.Triangle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TriangleDao extends JpaRepository<Triangle, Integer> {
    Triangle findById(int id);
    Triangle deleteById(int id);
}
