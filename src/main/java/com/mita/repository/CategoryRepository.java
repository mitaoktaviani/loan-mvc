package com.mita.repository;

import com.mita.entity.Category;
import com.mita.utility.DropDown;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    @Query("""
            SELECT new com.mita.utility.DropDown(
            cat.id, cat.categoryName)
            FROM Category AS cat
            """)
    List<DropDown> getCategoryDropDown();
}