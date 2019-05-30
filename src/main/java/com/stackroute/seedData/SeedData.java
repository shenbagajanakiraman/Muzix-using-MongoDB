//package com.stackroute.seedData;
//
//
//import com.stackroute.domain.Track;
//import com.stackroute.service.TrackService;
//import lombok.Data;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.core.env.Environment;
//import org.springframework.stereotype.Component;
//
//
//@Component
//@Data
//public class SeedData implements CommandLineRunner
//{
//    @Autowired
//    Environment environment;
//
//    @Autowired
//    TrackService trackService;
//
//    Track track=new Track();
//    @Override
//    public void run(String... args) throws Exception {
//        track.setTrackName(environment.getProperty("track-name"));
//        track.setComments(environment.getProperty("track-comment"));
//        //System.out.println(track.getTrackName());
//        trackService.addMusic(track);
//
//    }
//}
