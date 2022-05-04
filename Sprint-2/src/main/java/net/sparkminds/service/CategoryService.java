package net.sparkminds.service;

import java.util.List;

import net.sparkminds.dto.CategoryRequestDTO;
import net.sparkminds.entity.Category;

public interface CategoryService {
	Category createCategory(CategoryRequestDTO categoryRequestDto);
	
	List<Category> getAllCategory();
	
	void updateCategory(CategoryRequestDTO categoryRequestDto, Long id);

	void deleteCategory(Long id);
}
