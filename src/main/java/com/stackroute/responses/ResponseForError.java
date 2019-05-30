package com.stackroute.responses;

import lombok.Data;

@Data
public class ResponseForError
{
    private int errorId;
    private String errorMessage;

    public int getErrorId() {
        return errorId;
    }

    public void setErrorId(int errorId) {
        this.errorId = errorId;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
