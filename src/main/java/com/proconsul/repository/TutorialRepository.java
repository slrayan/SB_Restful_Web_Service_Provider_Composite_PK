package com.proconsul.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proconsul.entity.Tutorial;
import com.proconsul.entity.TutorialId;

public interface TutorialRepository extends JpaRepository<Tutorial,TutorialId>{

}