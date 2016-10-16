package com.waheed.fantasy_premier_league_api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TeamFixtureTest {
    private String teamFixtureJson = "{\"id\":1,\"is_home\":true,\"month\":2,\"event_day\":3,\"day\":4,\"opponent\":5}";
    private TeamFixture teamFixture;

    @Before
    public void setUp() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        teamFixture = mapper.readValue(teamFixtureJson, TeamFixture.class);
    }

    @Test
    public void getId() throws Exception {
        assertEquals(teamFixture.getId(), 1);
    }

    @Test
    public void isHome() throws Exception {
        assertEquals(teamFixture.isHome(), true);
    }

    @Test
    public void getMonth() throws Exception {
        assertEquals(teamFixture.getMonth(), 2);
    }

    @Test
    public void getEventDay() throws Exception {
        assertEquals(teamFixture.getEventDay(), 3);
    }

    @Test
    public void getDay() throws Exception {
        assertEquals(teamFixture.getDay(), 4);
    }

    @Test
    public void getOpponent() throws Exception {
        assertEquals(teamFixture.getOpponent(), 5);
    }
}