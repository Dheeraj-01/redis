package com.example.demo.repository;

import com.example.demo.model.FeedMetaData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class FeedMetaDataDtoImpl implements FeedMetaDataDto{

    @Autowired private RedisTemplate redisTemplate;
    private static final String KEY = "FEED";
    @Override
    public Boolean saveFeedMetaData(FeedMetaData feedMetaData) {
        try{
            redisTemplate.opsForHash().put(KEY, feedMetaData.getId().toString(), feedMetaData);
            return true;
        }
        catch (Exception exception){
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public List<FeedMetaData> fetchAllFeed() {
        try{
            List<FeedMetaData> values = null;
            values = redisTemplate.opsForHash().values(KEY);
            return values;
        }
        catch (Exception exception){
            exception.printStackTrace();
            return null;
        }
    }

    @Override
    public FeedMetaData fetchFeedMetaDataById(Long id) {
        try{
            FeedMetaData feedMetaData = null;
            feedMetaData = (FeedMetaData) redisTemplate.opsForHash().get(KEY, id.toString());
            return feedMetaData;
        }
        catch (Exception exception){
            exception.printStackTrace();
            return null;
        }
    }

    @Override
    public Boolean deleteFeedMetaData(Long id) {
        try{
            redisTemplate.opsForHash().delete(KEY, id.toString());
            return true;
        }
        catch (Exception exception){
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean updateFeedMetaData(Long id, FeedMetaData feedMetaData) {
        try{
            feedMetaData.setId(id);
            redisTemplate.opsForHash().put(KEY, id.toString(), feedMetaData);
            return true;
        }
        catch (Exception exception){
            exception.printStackTrace();
            return false;
        }
    }
}
