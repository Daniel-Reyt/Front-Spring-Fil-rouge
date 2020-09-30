package com.project.filrouge.dao;

import com.project.filrouge.models.Square;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SquareDao extends JpaRepository<Square, Integer> {
    Square findById(int id);
    Square deleteById(int id);
}
