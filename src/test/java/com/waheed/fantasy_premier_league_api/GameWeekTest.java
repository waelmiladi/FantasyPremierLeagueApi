package com.waheed.fantasy_premier_league_api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameWeekTest {
    private String gameWeekJson = TestHelper.loadJsonFile("src/test/java/com/waheed/fantasy_premier_league_api/api-examples/game-week.json");
    private String gameWeeksJson = TestHelper.loadJsonFile("src/test/java/com/waheed/fantasy_premier_league_api/api-examples/game-weeks.json");
    private GameWeek gameWeek;
    private HttpClient client = mock(HttpClient.class);

    @org.junit.Before
    public void setUp() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        gameWeek = mapper.readValue(gameWeekJson, GameWeek.class);

        when(client.get(Constants.gameWeeksUrl)).thenReturn(gameWeeksJson);
    }

    @Test
    public void testGetDeadlineTime() throws ParseException {
        assertEquals(gameWeek.getDeadlineTime().getTime(), 1471084200000L);
    }

    @Test
    public void getAverageEntryScore() throws Exception {
        assertEquals(gameWeek.getAverageEntryScore(), 44);
    }

    @Test
    public void isFinished() throws Exception {
        assertEquals(gameWeek.isFinished(), true);
    }

    @Test
    public void isDataChecked() throws Exception {
        assertEquals(gameWeek.isDataChecked(), true);
    }

    @Test
    public void getHighestScoringEntry() throws Exception {
        assertEquals(gameWeek.getHighestScoringEntry(), 719297);
    }

    @Test
    public void getDeadlineTimeGameOffset() throws Exception {
        assertEquals(gameWeek.getDeadlineTimeGameOffset(), 3600);
    }

    @Test
    public void getHighestScore() throws Exception {
        assertEquals(gameWeek.getHighestScore(), 104);
    }

    @Test
    public void testGetAll() throws ParseException, IOException {
        assertEquals(GameWeek.getAll(client).length, 3);
    }

    @Test
    public void testGetPrevious() throws Exception {
        assertEquals(GameWeek.getPrevious(client).getName(), "Gameweek 1");
    }

    @Test
    public void testGetCurrent() throws Exception {
        assertEquals(GameWeek.getCurrent(client).getName(), "Gameweek 2");
    }

    @Test
    public void testGetNext() throws Exception {
        assertEquals(GameWeek.getNext(client).getName(), "Gameweek 3");
    }

    @Test
    public void testFindById() throws Exception {
        assertEquals(GameWeek.findById(client, 2).getName(), "Gameweek 2");
    }

    @Test(expected=Exception.class)
    public void testFindByIdWhenNonExistent() throws Exception {
        GameWeek.findById(client, 4);
    }
}