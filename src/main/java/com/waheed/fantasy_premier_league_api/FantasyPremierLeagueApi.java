package com.waheed.fantasy_premier_league_api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FantasyPremierLeagueApi {

    private HttpClient client;
    private ObjectMapper mapper;

    public FantasyPremierLeagueApi() {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        client = new HttpClient(httpClient);
        mapper = new ObjectMapper();
    }

    public void setClient(HttpClient client) {
        this.client = client;
    }

    public List<Team> getTeams() throws IOException {
        String teams = client.get(Constants.teamsUrl);
        return Arrays.stream(mapper.readValue(teams, Team[].class)).collect(Collectors.toList());
    }
}
