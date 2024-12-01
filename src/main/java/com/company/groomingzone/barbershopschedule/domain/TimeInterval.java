package com.company.groomingzone.barbershopschedule.domain;

public enum TimeInterval {
    THIRTY_MINUTES(30),
    ONE_HOUR(60);

    private final int minutes;

    TimeInterval(int minutes) {
        this.minutes = minutes;
    }

    public int getMinutes() {
        return minutes;
    }
}
