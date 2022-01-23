package com.example.usermanagement.model;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class SuccessResponse {

    private int status;
    private String message;
    private Object attachment;

    public SuccessResponse(int status, String message, Object attachment) {
        this.status = status;
        this.message = message;
        this.attachment = attachment;
    }
}