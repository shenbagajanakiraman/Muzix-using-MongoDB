package com.stackroute.repository;

import com.stackroute.domain.Track;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackRepository extends MongoRepository<Track,Integer>
{
   // @Query(value = "db.track.find()")
//    public List<Track> getTrackByName(String trackName);
}
