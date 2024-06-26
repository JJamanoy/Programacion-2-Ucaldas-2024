package com.model.tutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.tutorial.domain.Tutorial;
import java.util.List;


public interface TutorialRepository extends JpaRepository<Tutorial, Long>{
    List<Tutorial> findByPublished(boolean published);
    List<Tutorial> findByTitleContaining(String title);
}
