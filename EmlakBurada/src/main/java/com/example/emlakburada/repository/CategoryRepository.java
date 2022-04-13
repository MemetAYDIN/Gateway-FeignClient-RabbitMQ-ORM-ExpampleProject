package com.example.emlakburada.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.emlakburada.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

}
