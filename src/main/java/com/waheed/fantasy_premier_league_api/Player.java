package com.waheed.fantasy_premier_league_api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.waheed.fantasy_premier_league_api.players.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Player {
    @JsonProperty
    private int id;
    @JsonProperty
    private String photo;
    @JsonProperty("web_name")
    private String webName;
    @JsonProperty("team_code")
    private int teamCode;
    @JsonProperty
    private String status;
    @JsonProperty
    private int code;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("second_name")
    private String secondName;
    @JsonProperty("squad_number")
    private int squadNumber;
    @JsonProperty
    private String news;
    @JsonProperty("now_cost")
    private int nowCost;
    @JsonProperty("chance_of_playing_this_round")
    private int chanceOfPlayingThisRound;
    @JsonProperty("chance_of_playing_next_round")
    private int chanceOfPlayingNextRound;
    @JsonProperty("value_form")
    private float valueForm;
    @JsonProperty("value_season")
    private float valueSeason;
    @JsonProperty("cost_change_start")
    private int costChangeStart;
    @JsonProperty("cost_change_event")
    private int costChangeEvent;
    @JsonProperty("cost_change_start_fall")
    private int costChangeStartFall;
    @JsonProperty("cost_change_event_fall")
    private int costChangeEventFall;
    @JsonProperty("in_dreamteam")
    private boolean inDreamteam;
    @JsonProperty("dreamteam_count")
    private int dreamteamCount;
    @JsonProperty("selected_by_percent")
    private float selectedByPercent;
    @JsonProperty
    private float form;
    @JsonProperty("transfers_out")
    private int transfersOut;
    @JsonProperty("transfers_in")
    private int transfersIn;
    @JsonProperty("transfers_out_event")
    private int transfersOutEvent;
    @JsonProperty("transfers_in_event")
    private int transfersInEvent;
    @JsonProperty("loans_in")
    private int loansIn;
    @JsonProperty("loans_out")
    private int loansOut;
    @JsonProperty("loaned_in")
    private int loanedIn;
    @JsonProperty("loaned_out")
    private int loanedOut;
    @JsonProperty("total_points")
    private int totalPoints;
    @JsonProperty("event_points")
    private int eventPoints;
    @JsonProperty("points_per_game")
    private float pointsPerGame;
    @JsonProperty("ep_this")
    private float epThis;
    @JsonProperty("ep_next")
    private float epNext;
    @JsonProperty
    private boolean special;
    @JsonProperty
    private int minutes;
    @JsonProperty("goals_scored")
    private int goalsScored;
    @JsonProperty
    private int assists;
    @JsonProperty("clean_sheets")
    private int cleanSheets;
    @JsonProperty("goals_conceded")
    private int goalsConceded;
    @JsonProperty("own_goals")
    private int ownGoals;
    @JsonProperty("penalties_saved")
    private int penaltiesSaved;
    @JsonProperty("penalties_missed")
    private int penaltiesMissed;
    @JsonProperty("yellow_cards")
    private int yellowCards;
    @JsonProperty("red_cards")
    private int redCards;
    @JsonProperty
    private int saves;
    @JsonProperty
    private int bonus;
    @JsonProperty
    private int bps;
    @JsonProperty
    private float influence;
    @JsonProperty
    private float creativity;
    @JsonProperty
    private float threat;
    @JsonProperty("ict_index")
    private float ictIndex;
    @JsonProperty("ea_index")
    private int eaIndex;
    @JsonProperty("element_type")
    private int elementType;
    @JsonProperty
    private int team;

    public PlayerType type() {
        return PlayerType.byId(elementType);
    }
}
