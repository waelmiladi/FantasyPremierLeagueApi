package com.waheed.fantasy_premier_league_api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
}