package com.sprint.mission.discodeit.service.jcf.com.sprint.mission.discodeit;

import com.sprint.mission.discodeit.entity.User;
import com.sprint.mission.discodeit.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class JCFUserService implements UserService {
    private final List<User> data; // 데이터를 저장하는 필드 final로 선언

    public JCFUserService() {
        this.data = new ArrayList<>();
    }

    @Override
    public User createUser(String name, String email) {
        User user = new User(name, email); // User 객체 생성
        data.add(user); // 생성된 객체를 data에 저장
        return user;
    }

    @Override
    public User readUserById(UUID id) {
        return data.stream().
                filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public  List<User> readAllUsers() {
        return new ArrayList<>(data);
    }

    @Override
    public User updateUser(UUID id, String name, String email) {
        User user = readUserById(id);
        if (user != null) {
            user.update(name, email);
            return user;
        }
        return null;
    }

    @Override
    public boolean deleteUser(UUID id) {
        User user = readUserById(id);
        if (user != null) {
            data.remove(user);
            return true;
        }
        return false;
    }
}
