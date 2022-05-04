package net.sparkminds.service.serviceImpl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.sparkminds.dto.ImageRequestDTO;
import net.sparkminds.entity.Image;
import net.sparkminds.responsitory.ImageRepository;
import net.sparkminds.service.ImageService;

@Service
@Transactional(readOnly = true)
public class ImageServiceImpl implements ImageService {
	
	@Autowired
	private ImageRepository imageRepository;

	@Override
	@Transactional
	public Image createImage(ImageRequestDTO imageRequestDto) {
		// TODO Auto-generated method stub
		Image image = new Image();
		image.setCategory(imageRequestDto.getCategory());
		image.setTitle(imageRequestDto.getTitle());
		image.setDescription(imageRequestDto.getDescription());
		image.setUrlImage(imageRequestDto.getUrlImage());
		return imageRepository.save(image);
	}

	@Override
	public List<Image> getAllImage() {
		// TODO Auto-generated method stub
		return imageRepository.findAll();
	}

	@Override
	@Transactional
	public void updateImage(ImageRequestDTO imageRequestDto, Long id) {
		// TODO Auto-generated method stub
		Image image = imageRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Image is not exist"));
		
		image.setCategory(imageRequestDto.getCategory());
		image.setTitle(imageRequestDto.getTitle());
		image.setDescription(imageRequestDto.getDescription());
		image.setUrlImage(imageRequestDto.getUrlImage());

	}

	@Override
	public void deleteImage(Long id) {
		// TODO Auto-generated method stub
		Image image = imageRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Image is not exist"));
		imageRepository.delete(image);

	}

}
