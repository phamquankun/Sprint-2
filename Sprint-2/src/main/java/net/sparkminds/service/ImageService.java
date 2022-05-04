package net.sparkminds.service;

import java.util.List;

import net.sparkminds.dto.ImageRequestDTO;
import net.sparkminds.entity.Image;

public interface ImageService {
	Image createImage(ImageRequestDTO imageRequestDto);
	
	List<Image> getAllImage();
	
	void updateImage(ImageRequestDTO imageRequestDto, Long id);
	
	void deleteImage(Long id);
}
