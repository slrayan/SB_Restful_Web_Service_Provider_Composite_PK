package com.proconsul.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proconsul.entity.Tutorial;
import com.proconsul.entity.TutorialId;
import com.proconsul.serivce.TutorialService;

/*
 * GET        http://localhost:8080/rest/api/tutorials
 * GET        http://localhost:8080/rest/api/tutorials/tutorial-id/1028A/Java 1.8
 * POST       http://localhost:8080/rest/api/tutorials ------>>>>>>JSON
 * PUT        http://localhost:8080/rest/api/tutorials ----------->>>>JSON
 * DELETE     http://localhost:8080/rest/api/tutorials/tutorial-id/1028A/Java 19
 * 
 */

@RestController
@RequestMapping("/rest/api/tutorials")
public class TutorialController {
	
	@Autowired
	private TutorialService tutorialService;
	
	@GetMapping("")
	public List<Tutorial> findAllTutorials() throws Exception{
		
		return tutorialService.findAllTutorials();
	}
	
	
	@GetMapping("/tutorial-id/{code}/{title}")
	public Tutorial findTutorialById(@PathVariable String code, @PathVariable String title) {
	
		return tutorialService.findTutorialById(new TutorialId(code,title));
		
	}
	
	@PostMapping("")
	public Tutorial saveTutorial(@RequestBody Tutorial tutorial) {
		
		return tutorialService.saveOrUpdateTutorial(tutorial);
	}
	
	@PutMapping("")
	public Tutorial updateTutorial(@RequestBody Tutorial tutorial) {
		
		return tutorialService.saveOrUpdateTutorial(tutorial);
	}
	
	@DeleteMapping("/tutorial-id/{code}/{title}")
	public Map<String,Boolean> removeTutorial(@PathVariable String code, @PathVariable String title){
		
		return tutorialService.removeTutorial(new TutorialId(code,title));
		
	}

}