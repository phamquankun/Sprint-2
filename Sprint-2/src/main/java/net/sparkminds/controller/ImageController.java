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

import net.sparkminds.dto.ImageRequestDTO;
import net.sparkminds.entity.Image;
import net.sparkminds.service.ImageService;

@RestController
@RequestMapping("/api/images")
public class ImageController {
	private final ImageService imageService;
	
	public ImageController(ImageService imageService) {
		this.imageService = imageService;
	}
	
	@GetMapping
	public ResponseEntity<List<Image>> getImage() {
		return ResponseEntity.ok().body(imageService.getAllImage());
	};
	
	@PostMapping
	public ResponseEntity<Image> createImage(@RequestBody ImageRequestDTO imageRequestDto) {
		Image image = imageService.createImage(imageRequestDto);
		return ResponseEntity.ok(image);
	}
	
	@PutMapping
	public ResponseEntity<?> updateImage(@PathVariable("id") Long id, @RequestBody ImageRequestDTO imageRequestDto) {
		imageService.updateImage(imageRequestDto, id);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping
	public ResponseEntity<?> deleteImage(@PathVariable("id") Long id) {
		imageService.deleteImage(id);
		return ResponseEntity.noContent().build();
	}
}
