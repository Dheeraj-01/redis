package com.example.demo.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class FeedMetaData implements Serializable {
    private Long id;
    private String description;
    private String imageLink;
    private String userName;
    private Long likes;
}
