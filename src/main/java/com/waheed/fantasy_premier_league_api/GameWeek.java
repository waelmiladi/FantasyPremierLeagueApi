package com.waheed.fantasy_premier_league_api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GameWeek {
    @JsonProperty
    private int id;

    @JsonProperty
    private String name;

    @JsonProperty("deadline_time")
    private String deadlineTime;

    @JsonProperty("average_entry_score")
    private int averageEntryScore;

    @JsonProperty
    private boolean finished;

    @JsonProperty("data_checked")
    private boolean dataChecked;

    @JsonProperty("highest_scoring_entry")
    private int highestScoringEntry;

    @JsonProperty("deadline_time_game_offset")
    private int deadlineTimeGameOffset;

    @JsonProperty("highest_score")
    private int highestScore;

    @JsonProperty("is_previous")
    private boolean isPrevious;

    @JsonProperty("is_current")
    private boolean isCurrent;

    @JsonProperty("is_next")
    private boolean isNext;

    private static ObjectMapper mapper = new ObjectMapper();

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getDeadlineTime() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
        return formatter.parse(deadlineTime.replaceAll("Z$", "+0000"));
    }

    public int getAverageEntryScore() {
        return averageEntryScore;
    }

    public boolean isFinished() {
        return finished;
    }

    public boolean isDataChecked() {
        return dataChecked;
    }

    public int getHighestScoringEntry() {
        return highestScoringEntry;
    }

    public int getDeadlineTimeGameOffset() {
        return deadlineTimeGameOffset;
    }

    public int getHighestScore() {
        return highestScore;
    }

    public boolean isPrevious() {
        return isPrevious;
    }

    public boolean isCurrent() {
        return isCurrent;
    }

    public boolean isNext() {
        return isNext;
    }

    public static GameWeek[] getAll(HttpClient client) throws IOException {
        String gameWeeks = client.get(Constants.gameWeeksUrl);
        return mapper.readValue(gameWeeks, GameWeek[].class);
    }

    public static GameWeek getPrevious(HttpClient client) throws Exception {
        GameWeek[] gameWeeks = getAll(client);
        Optional<GameWeek> gameWeek = Arrays.stream(gameWeeks).filter(gw -> gw.isPrevious()).findFirst();
        return getGameWeek(gameWeek);
    }

    public static GameWeek getCurrent(HttpClient client) throws Exception {
        GameWeek[] gameWeeks = getAll(client);
        Optional<GameWeek> gameWeek = Arrays.stream(gameWeeks).filter(gw -> gw.isCurrent()).findFirst();
        return getGameWeek(gameWeek);
    }

    public static GameWeek getNext(HttpClient client) throws Exception {
        GameWeek[] gameWeeks = getAll(client);
        Optional<GameWeek> gameWeek = Arrays.stream(gameWeeks).filter(gw -> gw.isNext()).findFirst();
        return getGameWeek(gameWeek);
    }

    public static GameWeek findById(HttpClient client, int id) throws Exception {
        GameWeek[] gameWeeks = getAll(client);
        Optional<GameWeek> gameWeek = Arrays.stream(gameWeeks).filter(gw -> gw.getId() == id).findFirst();
        return getGameWeek(gameWeek);
    }

    private static GameWeek getGameWeek(Optional<GameWeek> gameWeek) throws Exception {
        if (gameWeek.isPresent()) return gameWeek.get();
        throw new Exception("No Game Week found");
    }
}