package com.example.demo.service;

import com.example.demo.model.FeedMetaData;

import java.util.List;

public interface FeedMetaDataService {
    Boolean saveFeedMetaData(FeedMetaData feedMetaData);
    List<FeedMetaData> fetchAllFeed();
    FeedMetaData fetchFeedMetaDataById(Long id);
    Boolean deleteFeedMetaData(Long id);
    Boolean updateFeedMetaData(Long id, FeedMetaData feedMetaData);
}
