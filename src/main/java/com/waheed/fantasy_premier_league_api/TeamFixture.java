package com.waheed.fantasy_premier_league_api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TeamFixture {
    @JsonProperty
    private int id;

    @JsonProperty("is_home")
    private boolean isHome;

    @JsonProperty
    private int month;

    @JsonProperty
    private int day;

    @JsonProperty("event_day")
    private int eventDay;

    @JsonProperty
    private int opponent;

    public int getId() {
        return id;
    }

    public boolean isHome() {
        return isHome;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getEventDay() {
        return eventDay;
    }

    public int getOpponent() {
        return opponent;
    }
}
