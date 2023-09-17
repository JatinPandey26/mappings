package com.jatinpandey.mappings.Repository;

import com.jatinpandey.mappings.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface CategoryRepo extends JpaRepository<Category,Long> {
}
