package meTube.domain.entities;

import javax.persistence.Entity;

@Entity(name = "tubes")
public class Tube extends BaseEntity {
    private String name;
    private String description;
    private String youtubeLink;
    private String uploader;

    public Tube() {
    }

    public Tube(String name, String description, String youtubeLink, String uploader) {
        this.name = name;
        this.description = description;
        this.youtubeLink = youtubeLink;
        this.uploader = uploader;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getYoutubeLink() {
        return youtubeLink;
    }

    public void setYoutubeLink(String youtubeLink) {
        this.youtubeLink = youtubeLink;
    }

    public String getUploader() {
        return uploader;
    }

    public void setUploader(String uploader) {
        this.uploader = uploader;
    }
}
