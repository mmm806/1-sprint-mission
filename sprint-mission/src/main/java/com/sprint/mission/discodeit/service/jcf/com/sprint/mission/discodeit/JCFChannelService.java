package com.sprint.mission.discodeit.service.jcf.com.sprint.mission.discodeit;

import com.sprint.mission.discodeit.entity.Channel;
import com.sprint.mission.discodeit.service.ChannelService;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class JCFChannelService implements ChannelService {
    private final List<Channel> data;

    public JCFChannelService() {
        this.data = new ArrayList<>();
    }

    @Override
    public Channel createChannel(String name) {
        Channel channel = new Channel(name);
        data.add(channel);
        return channel;
    }

    @Override
    public Channel getChannelById(UUID id) {
        return data.stream()
                .filter(channel -> channel.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Channel> getAllChannels() {
        return new ArrayList<>(data);
    }

    @Override
    public Channel updateChannel(UUID id, String name) {
        Channel channel = getChannelById(id);
        if (channel != null) {
            channel.update(name);  // Channel 정보 업데이트
            return channel;
        }
        return null;
    }

    @Override
    public boolean deleteChannel(UUID id) {
        Channel channel = getChannelById(id);
        if (channel != null) {
            data.remove(channel);
            return true;
        }
        return false;
    }
}