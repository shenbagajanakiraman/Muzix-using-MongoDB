package com.stackroute.service;

import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.domain.Track;
import com.stackroute.repository.TrackRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class TrackServiceTest
{
    private Track track;

    //Create a mock for UserRepository
    @Mock
    private TrackRepository trackRepository;

    //Inject the mocks as dependencies into UserServiceImpl
    @InjectMocks
    private TrackServiceImpl trackService;
    List<Track> list= null;

    @Before
    public void setUp() {
        //Initialising the mock object
        MockitoAnnotations.initMocks(this);
        track = new Track();
        track.setTrackId(1);
        track.setTrackName("Believe");
        track.setComments("Awesome");
        list = new ArrayList<>();
       // System.out.println(track);
       list.add(track);
        // System.out.println(list);
    }

    @Test
    public void saveTrackTestSuccess() throws TrackAlreadyExistsException {

        when(trackRepository.save((Track)any())).thenReturn(track);
        Track savedUser = trackService.addMusic(track);
        Assert.assertEquals(track,savedUser);

        //verify here verifies that userRepository save method is only called once
        verify(trackRepository,times(1)).save(track);

    }


    @Test
    public void saveUserTestFailure()
    {
        Track testTrack=new Track(1,"Believe","Awesome");
        trackRepository.save(testTrack);
        Assert.assertEquals(track,testTrack);
    }

    @Test
    public void getAllUser() {

        trackRepository.save(track);
        //stubbing the mock to return specific data
        when(trackRepository.findAll()).thenReturn(list);
        List<Track> userlist = trackService.getAllMusic();
        Assert.assertEquals(list,userlist);
    }
}
