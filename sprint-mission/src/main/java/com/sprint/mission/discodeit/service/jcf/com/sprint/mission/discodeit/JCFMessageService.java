package com.sprint.mission.discodeit.service.jcf.com.sprint.mission.discodeit;

import com.sprint.mission.discodeit.entity.Channel;
import com.sprint.mission.discodeit.entity.Message;
import com.sprint.mission.discodeit.entity.User;
import com.sprint.mission.discodeit.service.MessageService;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class JCFMessageService implements MessageService {
    private final List<Message> data;

    public JCFMessageService() {
        this.data = new ArrayList<>();
    }

    @Override
    public Message createMessage(String content, User user, Channel channel) {
        Message message = new Message(content, user, channel);
        data.add(message);
        return message;
    }

    @Override
    public Message getMessageById(UUID id) {
        return data.stream()
                .filter(message -> message.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Message> getAllMessages() {
        return new ArrayList<>(data);
    }

    @Override
    public Message updateMessage(UUID id, String content) {
        Message message = getMessageById(id);
        if (message != null) {
            message.update(content);  // Message 내용 수정
            return message;
        }
        return null;
    }

    @Override
    public boolean deleteMessage(UUID id) {
        Message message = getMessageById(id);
        if (message != null) {
            data.remove(message);
            return true;
        }
        return false;
    }
}
