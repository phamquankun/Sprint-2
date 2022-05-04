package net.sparkminds.service.serviceImpl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.sparkminds.dto.CategoryRequestDTO;
import net.sparkminds.entity.Category;
import net.sparkminds.responsitory.CategoryRepository;
import net.sparkminds.service.CategoryService;

@Service
@Transactional(readOnly = true)
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	@Transactional
	public Category createCategory(CategoryRequestDTO categoryRequestDto) {
		Category category = new Category();
		category.setName(categoryRequestDto.getName());
		category.setDescription(categoryRequestDto.getDescription());
		category.setStatus(categoryRequestDto.getStatus());
		return categoryRepository.save(category);
	}

	@Override
	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}

	@Override
	@Transactional
	public void updateCategory(CategoryRequestDTO categoryRequestDto, Long id) {
		Category category = categoryRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Category is not exist"));

		category.setName(categoryRequestDto.getName());
		category.setDescription(categoryRequestDto.getDescription());
		category.setStatus(categoryRequestDto.getStatus());

	}

	@Override
	@Transactional
	public void deleteCategory(Long id) {
		// TODO Auto-generated method stub
		Category category = categoryRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Category is not exist"));

		categoryRepository.delete(category);

	}
}
