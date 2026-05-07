package com.smartparking.dto;

public class CheckOutResponse {
    private Long sessionId;
    private String slotName;
    private String message;

    public CheckOutResponse(Long sessionId, String slotName, String message) {
        this.sessionId = sessionId;
        this.slotName = slotName;
        this.message = message;
    }
    
    public Long getSessionId() { return sessionId; }
    public String getSlotName() { return slotName; }
    public String getMessage() { return message; }
}
