package com.stackroute.exceptions;

import com.stackroute.responses.ResponseForError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class TrackGlobalExceptionHandling extends Exception
{
    @ExceptionHandler(value = {TrackAlreadyExistsException.class})
    public ResponseEntity<ResponseForError> globalTrackAlreadyExists(TrackAlreadyExistsException ex) throws Exception
    {
        ResponseForError responseForError = new ResponseForError();
        responseForError.setErrorId(HttpStatus.BAD_REQUEST.value());
        responseForError.setErrorMessage(ex.getMessage());
        return new ResponseEntity<>(responseForError,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {TrackNotFoundException.class})
    public ResponseEntity<ResponseForError> globalTrackNotFound(TrackNotFoundException ex) throws Exception
    {
        ResponseForError responseForError = new ResponseForError();
        responseForError.setErrorId(HttpStatus.BAD_REQUEST.value());
        responseForError.setErrorMessage(ex.getMessage());
        return new ResponseEntity<>(responseForError,HttpStatus.BAD_REQUEST);
    }

}
