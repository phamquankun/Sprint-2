package net.sparkminds.responsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import net.sparkminds.entity.Image;

public interface ImageRepository extends JpaRepository<Image, Long > {

}
