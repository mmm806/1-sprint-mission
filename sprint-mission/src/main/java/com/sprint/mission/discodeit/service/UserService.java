package com.sprint.mission.discodeit.service;

import com.sprint.mission.discodeit.entity.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    User createUser(String name, String email);
    User readUserById(UUID uuid);
    List<User> readAllUsers();
    User updateUser(UUID id, String name, String email);
    boolean deleteUser(UUID id);
}
