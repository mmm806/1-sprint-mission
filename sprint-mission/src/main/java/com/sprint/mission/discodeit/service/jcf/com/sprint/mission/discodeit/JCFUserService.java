package com.sprint.mission.discodeit.service.jcf.com.sprint.mission.discodeit;

import com.sprint.mission.discodeit.entity.User;
import com.sprint.mission.discodeit.service.UserService;

import java.util.*;

public class JCFUserService implements UserService {
    private final Map<UUID, User> data; // 데이터를 저장하는 필드 final로 선언

    public JCFUserService() {
        this.data = new HashMap<>();
    }

    @Override
    public User create(String username, String email, String password) {
        User user = new User(username, email, password);
        this.data.put(user.getId(), user);

        return user;
    }

    @Override
    public User find(UUID userId) {
        User userNullalbe = this.data.get(userId);

        return Optional.ofNullable(userNullalbe)
                .orElseThrow(() -> new NoSuchElementException("User with id " + userId + " not found"));
    }

    @Override
    public  List<User> findAll() {
        return this.data.values().stream().toList();
    }

    @Override
    public User update(UUID userId, String newUsername, String newEmail, String newPassword) {
        User userNullable = this.data.get(userId);
        User user = Optional.ofNullable(userNullable)
                .orElseThrow(() -> new NoSuchElementException("user with id " + userId + " not found"));
        user.update(newUsername, newEmail, newPassword);

        return user;
    }

    @Override
    public void delete(UUID userId) {
        if (!this.data.containsKey(userId)) {
            throw new NoSuchElementException("User with id " + userId + " not found");
        }

        this.data.remove(userId);
    }
}
