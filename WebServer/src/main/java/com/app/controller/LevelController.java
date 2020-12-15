package com.app.controller;

import com.app.entity.Level;
import com.app.entity.UserInfo;
import com.app.requestEntity.AddLevelRequest;
import com.app.service.LevelService;
import com.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/content")
public class LevelController {
	@Autowired
	private LevelService levelService;
	@Autowired
	private UserService userService;

	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@RequestMapping(value = "/add-level")
	public ResponseEntity<?> addLevel(@RequestBody AddLevelRequest addLevelRequest) {
		return ResponseEntity.ok(levelService.addLevel(addLevelRequest));

	}
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@RequestMapping(value = "get-list-level")
	public ResponseEntity<?> getListLevel( ) {

		return ResponseEntity.ok(levelService.getListLevel());

	}
	@RequestMapping(value = "get-list-level-by-user")
	public ResponseEntity<?> getListLevelByUser(@RequestParam int userId) {
		UserInfo userInfo= userService.getUserInfo(userId);
		return ResponseEntity.ok(levelService.getListLevelByUser(userInfo.getUnlockLevel()));
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@RequestMapping(value = "find-level-by-id/{levelId}")
	public ResponseEntity<?> findLevelById(@PathVariable int levelId) {

		return ResponseEntity.ok(levelService.findLevelById(levelId));

	}

	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@RequestMapping(value = "delete-level/{levelId}")
	public ResponseEntity<?> deleteLevel(@PathVariable int levelId) {
		return ResponseEntity.ok(levelService.deleteLevel(levelId));

	}

	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@RequestMapping(value = "update-level")
	public ResponseEntity<?> updateLevel(@RequestBody Level level) {
		return ResponseEntity.ok(levelService.updateLevel(level));

	}

}
