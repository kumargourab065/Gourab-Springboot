package com.centroxy.controller;

import com.centroxy.entity.Group;
import com.centroxy.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class GroupController {

    @Autowired
    private GroupService groupService;


    @PostMapping("/addGroupByAdmin")
    public ResponseEntity<Group> addGroup(@RequestBody Group group) {
        try {
            return new ResponseEntity<>(groupService.saveGroup(group), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getGroupById/{id}")
    public ResponseEntity<Group> getGroupById(@PathVariable Long id) {
        try {
            Group group = groupService.getGroupById(id);
            return new ResponseEntity<>(group, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
