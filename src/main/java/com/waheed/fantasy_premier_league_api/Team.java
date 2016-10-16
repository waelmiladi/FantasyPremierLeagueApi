package com.waheed.fantasy_premier_league_api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.Optional;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class Team {
    @JsonProperty
    private int id;

    @JsonProperty
    private int code;

    @JsonProperty
    private String name;

    @JsonProperty("short_name")
    private String shortName;

    @JsonProperty
    private boolean unavailable;

    @JsonProperty
    private int strength;

    @JsonProperty
    private int position;

    @JsonProperty
    private int played;

    @JsonProperty
    private int win;

    @JsonProperty
    private int loss;

    @JsonProperty
    private int draw;

    @JsonProperty
    private int points;

    @JsonProperty
    private String form;

    @JsonProperty("link_url")
    private String linkUrl;

    @JsonProperty("strength_overall_home")
    private int strengthOverallHome;

    @JsonProperty("strength_overall_away")
    private int strengthOverallAway;

    @JsonProperty("strength_attack_home")
    private int strengthAttackHome;

    @JsonProperty("strength_attack_away")
    private int strengthAttackAway;

    @JsonProperty("strength_defence_home")
    private int strengthDefenceHome;

    @JsonProperty("strength_defence_away")
    private int strengthDefenceAway;

    @JsonProperty("team_division")
    private int division;

    @JsonProperty("current_event_fixture")
    private TeamFixture[] currentFixtures;

    @JsonProperty("next_event_fixture")
    private TeamFixture[] nextFixtures;

    public String getName() {
        return name;
    }

    public TeamFixture getCurrentFixture() throws Exception {
        Optional<TeamFixture> currentFixture = Arrays.stream(currentFixtures).findFirst();
        return getTeamFixture(currentFixture);
    }

    public TeamFixture getNextFixture() throws Exception {
        Optional<TeamFixture> nextFixture = Arrays.stream(nextFixtures).findFirst();
        return getTeamFixture(nextFixture);
    }

    private TeamFixture getTeamFixture(Optional<TeamFixture> fixture) throws Exception {
        if (fixture.isPresent()) return fixture.get();
        throw new Exception("No fixture available");
    }
}
