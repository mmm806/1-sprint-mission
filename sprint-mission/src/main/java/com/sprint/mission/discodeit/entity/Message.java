package com.sprint.mission.discodeit.entity;

public class Message extends BaseEntity{
    private String content;
    private User user;
    private Channel channel;

    public Message(String content, User user, Channel channel) {
        super();
        this.content = content;
        this.user = user;
        this.channel = channel;
    }

    public String getContent() {
        return content;
    }

    public User getUser() {
        return user;
    }

    public Channel getChannel() {
        return channel;
    }

    public void update(String content) {
        if (content != null) {
            this.content = content;
        }
        super.updateTimestamp();
    }
}
