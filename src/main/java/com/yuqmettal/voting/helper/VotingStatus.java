package com.yuqmettal.voting.helper;

public enum VotingStatus {
    Valid(true, "The Vote is valid"),
    AreaDoesNotExists(false, "The Area does not exists"),
    EmployeeDoesNotExists(false, "TheEmployee does not exists"),
    OwnVoteError(false, "You can not vote to yourself"),
    AlreadyVoted(false, "A vote is already registered this month");

    VotingStatus(Boolean isValid, String message) {
        this.setIsValid(isValid);
        this.setMessage(message);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getIsValid() {
        return isValid;
    }

    public void setIsValid(Boolean isValid) {
        this.isValid = isValid;
    }

    private Boolean isValid;
    private String message;

}