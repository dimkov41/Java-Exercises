package meTube.domain.models.service;

import javax.validation.constraints.NotNull;

public class TubeServiceModel {
    private String name;
    private String description;
    private String youtubeLink;
    private String uploader;

    public TubeServiceModel() {
    }

    public TubeServiceModel(String name, String description, String youtubeLink, String uploader) {
        this.name = name;
        this.description = description;
        this.youtubeLink = youtubeLink;
        this.uploader = uploader;
    }

    @NotNull
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @javax.validation.constraints.Pattern(regexp = "https:\\/\\/www\\.youtube\\.com\\/watch\\?v=[A-Za-z0-9\\-_]{11}")
    public String getYoutubeLink() {
        return youtubeLink;
    }

    public void setYoutubeLink(String youtubeLink) {
        this.youtubeLink = youtubeLink;
    }

    @NotNull
    public String getUploader() {
        return uploader;
    }

    public void setUploader(String uploader) {
        this.uploader = uploader;
    }
}
