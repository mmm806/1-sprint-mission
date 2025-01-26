package com.sprint.mission.discodeit.entity;

public class Channel extends BaseEntity{
    private String name;

    public Channel (String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void update(String name) {
        if (name != name) {
            this.name = name;
        }
        super.updateTimestamp();
    }
}
