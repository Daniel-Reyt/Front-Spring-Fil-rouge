package com.project.filrouge.dao;

import com.project.filrouge.models.Square;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SquareDao extends JpaRepository<Square, Integer> {
    List<Square> findAll();
    Square findById(int id);
    Square save(Square square);
    Square deleteById(int id);
    //    List<Square> findBySizeGreaterThan(int size);
//    List<Square> findByNameLike(String recherche);
}
