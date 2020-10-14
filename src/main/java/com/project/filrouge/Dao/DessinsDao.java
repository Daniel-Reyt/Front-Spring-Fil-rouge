package com.project.filrouge.Dao;

import com.project.filrouge.Form.Dessins;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DessinsDao extends JpaRepository<Dessins, Integer> {
}
