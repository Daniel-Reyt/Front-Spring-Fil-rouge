package com.project.filrouge.Dao;

import com.project.filrouge.Form.Shape;
import com.project.filrouge.draw.Draw;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrawDao extends JpaRepository<Draw, Integer> {
}
