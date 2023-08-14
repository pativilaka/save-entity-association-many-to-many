package com.vilaka.saveentityassociationmanytomany.repositories;

import com.vilaka.saveentityassociationmanytomany.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
