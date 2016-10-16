package com.waheed.fantasy_premier_league_api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.waheed.fantasy_premier_league_api.players.PlayerType;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

/**
 * Created by waheedelmiladi on 16/10/2016.
 */
public class PlayerTest {
    private String playerJson = TestHelper.loadJsonFile("src/test/java/com/waheed/fantasy_premier_league_api/api-examples/player.json");
    private Player player;

    @org.junit.Before
    public void setUp() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        player = mapper.readValue(playerJson, Player.class);
    }

    @Test
    public void getElementType() throws Exception {
        assertThat(player.type(), instanceOf(PlayerType.class));
    }
}