package com.waheed.fantasy_premier_league_api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by waheedelmiladi on 16/10/2016.
 */
public class FantasyPremierLeagueApiTest {

    private HttpClient client = mock(HttpClient.class);
    private FantasyPremierLeagueApi api = new FantasyPremierLeagueApi();

    @org.junit.Before
    public void setUp() throws Exception {
        api.setClient(client);
    }

    @Test
    public void getTeams() throws Exception {

    }
}