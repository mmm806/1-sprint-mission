package com.sprint.mission.discodeit.service;

import com.sprint.mission.discodeit.entity.Channel;
import com.sprint.mission.discodeit.entity.Channeltype;

import java.util.List;
import java.util.UUID;

public interface ChannelService {
    Channel create(Channeltype type, String name, String description);
    Channel find(UUID ChannelId);
    List<Channel> findAll();
    Channel update(UUID channelId, String newName, String newDescription);
    void delete(UUID channelId);
}
