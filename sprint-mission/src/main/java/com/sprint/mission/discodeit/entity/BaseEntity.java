package com.sprint.mission.discodeit.entity;

import java.time.Instant;
import java.util.UUID;

public abstract class BaseEntity {
    private final UUID id;
    private final Long createdAt;
    private Long updatedAt;

    public BaseEntity() {
        this.id = UUID.randomUUID();
        this.createdAt = Instant.now().getEpochSecond();
        this.updatedAt = createdAt;
    }

    // private으로 선언된 필드를 클래스 외부에서 참조할 수 있도록 Getter 메소드를 정의
    public UUID getId() { return id; }

    public long getCreatedAt() {
        return createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public void update() {
        this.updatedAt = Instant.now().getEpochSecond();
    }

}
