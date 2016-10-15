package com.waheed.fantasy_premier_league_api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.text.ParseException;
import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * Created by waheedelmiladi on 15/10/2016.
 */
public class GameWeekTest {

    private String gameWeekJson = "{\"id\":1,\"name\":\"Gameweek 1\",\"deadline_time\":\"2016-08-13T10:30:00Z\",\"average_entry_score\":44,\"finished\":true,\"data_checked\":true,\"highest_scoring_entry\":719297,\"deadline_time_epoch\":1471084200,\"deadline_time_game_offset\":3600,\"deadline_time_formatted\":\"13 Aug 11:30\",\"highest_score\":104,\"is_previous\":false,\"is_current\":false,\"is_next\":false}";
    private GameWeek gameWeek;

    @org.junit.Before
    public void setUp() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        gameWeek = mapper.readValue(gameWeekJson, GameWeek.class);
    }

    @Test
    public void testGetDeadlineTime() throws ParseException {
        Date deadlineTime = gameWeek.getDeadlineTime();
        assertEquals(deadlineTime.getTime(), 1471084200000L);
    }
}