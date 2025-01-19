package com.sprint.mission.discodeit.entity;

import java.util.UUID;

public class User extends BaseEntity{
    private String name;
    private String email;

    public User(String name, String email) {
        super();
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void update(String name, String email) { // name과 email만 수정하는 update 메서드
        if (name != null) {
            this.name = name;
        }
        if (email != null) {
            this.email = email;
        }
        super.update(); // 수정시간 변경
    }
}
