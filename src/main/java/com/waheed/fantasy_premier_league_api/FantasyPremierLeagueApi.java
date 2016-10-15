package com.waheed.fantasy_premier_league_api;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class FantasyPremierLeagueApi {

    private HttpClient client;

    public FantasyPremierLeagueApi() {
        client = new HttpClient();
    }

    public GameWeek[] getGameWeeks() throws IOException {
        return GameWeek.getAll(client);
    }
}
