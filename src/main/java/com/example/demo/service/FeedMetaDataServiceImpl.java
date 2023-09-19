package com.example.demo.service;

import com.example.demo.model.FeedMetaData;
import com.example.demo.repository.FeedMetaDataDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FeedMetaDataServiceImpl implements FeedMetaDataService{

    @Autowired FeedMetaDataDto feedMetaDataDto;

    @Override
    public Boolean saveFeedMetaData(FeedMetaData feedMetaData) {
        // Business Logic here
        return feedMetaDataDto.saveFeedMetaData(feedMetaData);
    }

    @Override
    public List<FeedMetaData> fetchAllFeed() {
        return feedMetaDataDto.fetchAllFeed();
    }

    @Override
    public FeedMetaData fetchFeedMetaDataById(Long id) {
        return feedMetaDataDto.fetchFeedMetaDataById(id);
    }

    @Override
    public Boolean deleteFeedMetaData(Long id) {
        return feedMetaDataDto.deleteFeedMetaData(id);
    }

    @Override
    public Boolean updateFeedMetaData(Long id, FeedMetaData feedMetaData) {
        return feedMetaDataDto.updateFeedMetaData(id, feedMetaData);
    }
}
