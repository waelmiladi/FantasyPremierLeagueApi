package com.waheed.fantasy_premier_league_api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by waheedelmiladi on 16/10/2016.
 */
public class TeamTest {
    private ObjectMapper mapper = new ObjectMapper();
    private String teamJson = "{\"id\":1,\"current_event_fixture\":[{\"is_home\":true,\"month\":10,\"event_day\":1,\"id\":71,\"day\":15,\"opponent\":16}],\"next_event_fixture\":[{\"is_home\":true,\"month\":10,\"event_day\":1,\"id\":81,\"day\":22,\"opponent\":12}],\"name\":\"Arsenal\",\"code\":3,\"short_name\":\"ARS\",\"unavailable\":false,\"strength\":4,\"position\":0,\"played\":0,\"win\":0,\"loss\":0,\"draw\":0,\"points\":0,\"form\":null,\"link_url\":\"\",\"strength_overall_home\":1240,\"strength_overall_away\":1325,\"strength_attack_home\":1200,\"strength_attack_away\":1375,\"strength_defence_home\":1300,\"strength_defence_away\":1315,\"team_division\":1}";
    private Team team = mapper.readValue(teamJson, Team.class);

    public TeamTest() throws IOException {
    }

    @Test
    public void testName() throws Exception {
        assertEquals(team.getName(), "Arsenal");
    }

    @Test
    public void testCurrentFixture() throws Exception {
        TeamFixture currentFixture = team.getCurrentFixture();

        assertEquals(currentFixture.getId(), 71);
    }

    @Test
    public void testNextFixture() throws Exception {
        TeamFixture nextFixture = team.getNextFixture();

        assertEquals(nextFixture.getId(), 81);
    }

    @Test(expected=Exception.class)
    public void testWithoutFixture() throws Exception {
        String teamWithoutFixtureJson = "{\"id\":1,\"current_event_fixture\":[],\"next_event_fixture\":[],\"name\":\"Arsenal\",\"code\":3,\"short_name\":\"ARS\",\"unavailable\":false,\"strength\":4,\"position\":0,\"played\":0,\"win\":0,\"loss\":0,\"draw\":0,\"points\":0,\"form\":null,\"link_url\":\"\",\"strength_overall_home\":1240,\"strength_overall_away\":1325,\"strength_attack_home\":1200,\"strength_attack_away\":1375,\"strength_defence_home\":1300,\"strength_defence_away\":1315,\"team_division\":1}";
        Team teamWithoutFixture = mapper.readValue(teamWithoutFixtureJson, Team.class);
        teamWithoutFixture.getCurrentFixture();
    }
}