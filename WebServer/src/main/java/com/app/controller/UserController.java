package com.app.controller;

import com.app.requestEntity.AddUserInfoRequest;
import com.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
   @RequestMapping("/get-info/{userId}")
   public ResponseEntity<?> getListGrammar(@PathVariable int userId){
       return ResponseEntity.ok(userService.getUserInfo(userId));
   }

    @RequestMapping("/get-rank-10")
    public ResponseEntity<?> getRank10(){

        return ResponseEntity.ok(userService.getRank10());
    }
    @RequestMapping("/get-rank-5")
    public ResponseEntity<?> getRank5(){

        return ResponseEntity.ok(userService.getRank5());
    }


}
