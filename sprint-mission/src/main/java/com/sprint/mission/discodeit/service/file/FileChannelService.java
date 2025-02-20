package com.sprint.mission.discodeit.service.file;

import com.sprint.mission.discodeit.entity.Channel;
import com.sprint.mission.discodeit.entity.ChannelType;
import com.sprint.mission.discodeit.entity.Message;
import com.sprint.mission.discodeit.service.ChannelService;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

public class FileChannelService implements ChannelService {

    private final Path DIRECTORY;
    private final String EXTENSION = ".ser";

    public FileChannelService () {
        this.DIRECTORY = Paths.get(System.getProperty("user.dir"),"file-data-map", Message.class.getSimpleName());
    }

    private Path resolvePath(UUID id) {
        return DIRECTORY.resolve(id + EXTENSION);
    }
    @Override
    public Channel create(ChannelType type, String name, String description) {
        Channel channel = new Channel(type, name, description);

        Path path = resolvePath(channel.getId());
        try (
                FileOutputStream fos = new FileOutputStream(path.toFile());
                ObjectOutputStream oos = new ObjectOutputStream(fos)
                ) {
            oos.writeObject(channel);
        } catch (IOException e){
            throw new RuntimeException(e);

        }
        return channel;
    }

    @Override
    public Channel find(UUID channelId) {
        Channel channelNullalbe = null;
        Path path = resolvePath(channelId);

        if (Files.exists(path)) {
            try (
                    FileInputStream fis = new FileInputStream(path.toFile());
                    ObjectInputStream ois = new ObjectInputStream(fis)
                    ) {
                channelNullalbe = (Channel) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return Optional.ofNullable(channelNullalbe)
                .orElseThrow(() -> new NoSuchElementException("Channel With id " + channelId + " not found"));
    }

    @Override
    public List<Channel> findAll() {
        return null;
    }

    @Override
    public Channel update(UUID channelId, String newName, String newDescription) {
        return null;
    }

    @Override
    public void delete(UUID channelId) {

    }
}
