package com.app.controller;

import com.app.requestEntity.AddLevelRequest;
import com.app.service.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/content")
public class LevelController {
	@Autowired
	private LevelService levelService;

	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@RequestMapping(value = "/add-level")
	public ResponseEntity<?> addLevel(@RequestBody AddLevelRequest addLevelRequest) {
		levelService.addLevel(addLevelRequest);
		return ResponseEntity.ok(HttpStatus.OK);

	}

	@RequestMapping(value = "get-list-level")
	public ResponseEntity<?> getListLevel( ) {

		return ResponseEntity.ok(levelService.getListLevel());

	}
	@RequestMapping(value = "find-level-by-id/{levelId}")
	public ResponseEntity<?> findLevelById(@PathVariable int levelId) {

		return ResponseEntity.ok(levelService.findLevelById(levelId));

	}
	@RequestMapping(value = "delete-level/{levelId}")
	public ResponseEntity<?> deleteLevel(@PathVariable int levelId) {
		return ResponseEntity.ok(levelService.deleteLevel(levelId));

	}

}
