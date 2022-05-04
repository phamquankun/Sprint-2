package net.sparkminds.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.sparkminds.dto.CategoryRequestDTO;
import net.sparkminds.entity.Category;
import net.sparkminds.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	private final CategoryService categoryService;
	
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@GetMapping
	public ResponseEntity<List<Category>> getCategory() {
		return ResponseEntity.ok().body(categoryService.getAllCategory());
	};
	
	@PostMapping
	public ResponseEntity<Category> createCategory(@RequestBody CategoryRequestDTO categoryRequestDto) {
		Category category = categoryService.createCategory(categoryRequestDto);
		return ResponseEntity.ok(category);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateCategory(@PathVariable("id") Long id, @RequestBody CategoryRequestDTO categoryRequestDto) {
		categoryService.updateCategory(categoryRequestDto, id);
		return ResponseEntity.noContent().build();	
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteCategory(@PathVariable("id") Long id) {
		categoryService.deleteCategory(id);
		return ResponseEntity.noContent().build();
	}
	
}
