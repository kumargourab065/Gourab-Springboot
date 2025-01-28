package com.centroxy.service;

import com.centroxy.entity.Group;

public interface GroupService {
    Group saveGroup(Group group);
    Group getGroupById(Long id);


}
