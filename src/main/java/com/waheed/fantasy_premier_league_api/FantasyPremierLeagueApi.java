package com.waheed.fantasy_premier_league_api;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class FantasyPremierLeagueApi {

    private HttpClient client;
    private ObjectMapper mapper;

    public FantasyPremierLeagueApi() {
        client = new HttpClient();
        mapper = new ObjectMapper();
    }

    public GameWeek[] getGameWeeks() throws IOException {
        String gameWeeks = client.get(Constants.gameWeeksUrl);
        return mapper.readValue(gameWeeks, GameWeek[].class);
    }
}
