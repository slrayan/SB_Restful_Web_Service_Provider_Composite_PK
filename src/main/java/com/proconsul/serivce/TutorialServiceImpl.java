package com.proconsul.serivce;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.proconsul.entity.Tutorial;
import com.proconsul.entity.TutorialId;
import com.proconsul.repository.TutorialRepository;

@Service
public class TutorialServiceImpl implements TutorialService{
	
	
	@Value("${message.no.tutorials}")
	private String noTutorials;
	
	@Autowired
	private TutorialRepository tutorialRepository;

	@Override
	public List<Tutorial> findAllTutorials() throws Exception {
		
		List<Tutorial> tutorials = tutorialRepository.findAll();
		
		if (tutorials==null || tutorials.isEmpty()) {
			
			throw new Exception(noTutorials);
			
		}
		
		return tutorials;
		
	}

	@Override
	public Tutorial findTutorialById(TutorialId tutorialId) {
		
		return tutorialRepository.findById(tutorialId).orElseThrow(IllegalArgumentException::new);
		
	}

	@Override
	public Tutorial saveOrUpdateTutorial(Tutorial tutorial) {
	
		Tutorial savedOrUpdatedTutorial = null;
		
		try {
			
			savedOrUpdatedTutorial = tutorialRepository.save(tutorial);
		}
		
		catch(IllegalArgumentException ex) {
			
			ex.printStackTrace();
		}
		
		return savedOrUpdatedTutorial;
		
	}

	@Override
	public Map<String, Boolean> removeTutorial(TutorialId tutorialId) {
		
		Map<String,Boolean> deletionMap = new HashMap<>();
		
		try {
			
			tutorialRepository.deleteById(tutorialId);
			deletionMap.put("deletion", true);
			
		}
		
		catch(IllegalArgumentException ex) {
			
			deletionMap.put("deletion", false);
			
			
		}
		
		return deletionMap;
	}

}
