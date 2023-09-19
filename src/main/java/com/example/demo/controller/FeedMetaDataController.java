package com.example.demo.controller;

import com.example.demo.model.FeedMetaData;
import com.example.demo.service.FeedMetaDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FeedMetaDataController {

    @Autowired FeedMetaDataService feedMetaDataService;
    @PostMapping("/feed")
    public ResponseEntity<String> saveFeedMetaData(@RequestBody FeedMetaData feedMetaData) {
        boolean isSuccess = feedMetaDataService.saveFeedMetaData(feedMetaData);
        if(isSuccess)
            return ResponseEntity.ok("Feed Meta Data Created Successfully!!");
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/feed")
    public ResponseEntity<List<FeedMetaData>> fetchAllFeedMetaData() {
        List<FeedMetaData> feeds = null;
        feeds = feedMetaDataService.fetchAllFeed();
        return ResponseEntity.ok(feeds);
    }

    @GetMapping("/feed/{id}")
    public ResponseEntity<FeedMetaData> fetchFeedMetaDataById(@PathVariable("id") Long id) {
        FeedMetaData feedMetaData;
        feedMetaData = feedMetaDataService.fetchFeedMetaDataById(id);
        return ResponseEntity.ok(feedMetaData);
    }

    @DeleteMapping("/feed/{id}")
    public ResponseEntity<String> deleteFeedMetaData(@PathVariable("id") Long id) {
        boolean isSuccess = feedMetaDataService.deleteFeedMetaData(id);
        if(isSuccess)
            return ResponseEntity.ok("Feed Meta Data deleted Successfully!!");
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PutMapping("/feed/{id}")
    public ResponseEntity<String> updateFeedMetaData(@PathVariable("id") Long id, @RequestBody FeedMetaData feedMetaData) {
        boolean isSuccess = feedMetaDataService.updateFeedMetaData(id, feedMetaData);
        if(isSuccess)
            return ResponseEntity.ok("Feed Meta Data Updated Successfully!!");
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

}
