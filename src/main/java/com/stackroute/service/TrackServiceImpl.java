package com.stackroute.service;

import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;
import com.stackroute.domain.Track;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackServiceImpl implements TrackService {
    @Autowired
    private TrackRepository trackRepository;


    @Override
    public Track addMusic(Track track) throws TrackAlreadyExistsException
    {
        if(trackRepository.existsById(track.getTrackId()))
        {
            throw new TrackAlreadyExistsException("Track already Exist");
        }
        else
        {
            return trackRepository.save(track);
        }
    }
    @Override
    public List<Track> getAllMusic()
    {
        return trackRepository.findAll();
    }
    @Override
    public void deleteMusic(int track) throws TrackNotFoundException {
        if(trackRepository.existsById(track))
        {
            trackRepository.deleteById(track);

        }
        else
        {
            throw new TrackNotFoundException("Track not found");
        }

    }

    @Override
    public Optional<Track> findTrackById(int id) {
        return trackRepository.findById(id);
    }

//    @Override
//    public List<Track> getTrackByName(String trackName) throws TrackNotFoundException{
//
//        List<Track> listOfTracks = null;
//        listOfTracks = trackRepository.getTrackByName(trackName);
//        if (listOfTracks.equals(null))
//        {
//            throw new TrackNotFoundException("Track not found exception");
//        }
//        return listOfTracks;
//    }
}
