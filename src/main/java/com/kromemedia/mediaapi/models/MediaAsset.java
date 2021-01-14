package com.kromemedia.mediaapi.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class MediaAsset {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String type;
    private int size;
    private LocalDateTime created;
    private LocalDateTime lastModified;
    private String owner;

    public MediaAsset() {
    }

    public MediaAsset(int id, String type, int size, LocalDateTime created, LocalDateTime lastModified, String owner) {
        this.id = id;
        this.type = type;
        this.size = size;
        this.created = created;
        this.lastModified = lastModified;
        this.owner = owner;
    }

    public MediaAsset(MediaAsset other) {
        if(other != null) {
            this.id = other.id;
            this.type = other.type;
            this.size = other.size;
            this.created = other.created;
            this.lastModified = other.lastModified;
            this.owner = other.owner;
        }
    }

    @Override
    public String toString() {
        return "MediaAsset{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", size=" + size +
                ", created=" + created +
                ", lastModified=" + lastModified +
                ", owner='" + owner + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getLastModified() {
        return lastModified;
    }

    public void setLastModified(LocalDateTime lastModified) {
        this.lastModified = lastModified;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
