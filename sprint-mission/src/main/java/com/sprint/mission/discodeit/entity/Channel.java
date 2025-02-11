package com.sprint.mission.discodeit.entity;

public class Channel extends BaseEntity{
    private Channeltype type;
    private String name;
    private String description;

    public Channel(Channeltype type, String name, String description) {
        super();
        this.type = type;
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public Channeltype getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public void update(String newName, String newDescription) {
        boolean anyValueUpdated = false;

        if (newName != null && !newName.equals(this.name)) {
            this.name = newName;
            anyValueUpdated = true;
        }

        if (newDescription != null && !newDescription.equals(this.description)) {
            this.description = description;
            anyValueUpdated = true;
        }

        if (anyValueUpdated) {
            super.update();
        }

    }

}
