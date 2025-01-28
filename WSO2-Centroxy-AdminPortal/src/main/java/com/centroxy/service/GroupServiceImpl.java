package com.centroxy.service;

import com.centroxy.entity.Group;
import com.centroxy.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Override
    public Group saveGroup(Group group) {
        return groupRepository.save(group);
    }

    @Override
    public Group getGroupById(Long id) {
        return groupRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Group not found with id: " + id));
    }


}
