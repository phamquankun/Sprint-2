package net.sparkminds.responsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.sparkminds.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}