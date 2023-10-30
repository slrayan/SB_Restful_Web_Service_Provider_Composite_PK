package com.proconsul.serivce;

import java.util.List;
import java.util.Map;

import com.proconsul.entity.Tutorial;
import com.proconsul.entity.TutorialId;

public interface TutorialService {
	
	public List<Tutorial> findAllTutorials() throws Exception ;

	public Tutorial findTutorialById(TutorialId tutorialId);

	public Tutorial saveOrUpdateTutorial(Tutorial tutorial);

	public Map<String, Boolean> removeTutorial(TutorialId tutorialId);
}
