package com.example.demo.repository;

import com.example.demo.model.FeedMetaData;

import java.util.List;

public interface FeedMetaDataDto {
    Boolean saveFeedMetaData(FeedMetaData feedMetaData);
    List<FeedMetaData> fetchAllFeed();
    FeedMetaData fetchFeedMetaDataById(Long id);
    Boolean deleteFeedMetaData(Long id);
    Boolean updateFeedMetaData(Long id, FeedMetaData feedMetaData);
}
