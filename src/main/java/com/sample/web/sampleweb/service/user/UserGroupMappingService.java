package com.sample.web.sampleweb.service.user;

import com.sample.web.sampleweb.repository.user.UserGroupMappingRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UserGroupMappingService {
    private final UserGroupMappingRepository userGroupMappingRepository;

    public UserGroupMappingService(UserGroupMappingRepository userGroupMappingRepository) {
        this.userGroupMappingRepository = userGroupMappingRepository;
    }

    public List<String> getAllUserGroupIds() {
        return userGroupMappingRepository.findDistinctUserGroupId();
        //List<UserGroupMappingEntity> userGroupMappingEntities = userGroupMappingRepository.findAllDistinctByUserGroupId();
        //return userGroupMappingEntities.stream().map(UserGroupMappingEntity::getUserGroupId).toList();

    }
}