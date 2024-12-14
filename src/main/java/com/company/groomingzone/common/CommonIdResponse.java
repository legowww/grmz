package com.company.groomingzone.common;


public record CommonIdResponse(Long id) {

    public static CommonIdResponse of(Long id) {
        return new CommonIdResponse(id);
    }
}
