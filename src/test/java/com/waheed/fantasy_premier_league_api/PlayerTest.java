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
    private String playerJson = "{\"id\":1,\"photo\":\"48844.jpg\",\"web_name\":\"Ospina\",\"team_code\":3,\"status\":\"a\",\"code\":48844,\"first_name\":\"David\",\"second_name\":\"Ospina\",\"squad_number\":13,\"news\":\"\",\"now_cost\":49,\"chance_of_playing_this_round\":null,\"chance_of_playing_next_round\":null,\"value_form\":\"0.0\",\"value_season\":\"0.0\",\"cost_change_start\":-1,\"cost_change_event\":0,\"cost_change_start_fall\":1,\"cost_change_event_fall\":0,\"in_dreamteam\":false,\"dreamteam_count\":0,\"selected_by_percent\":\"0.2\",\"form\":\"0.0\",\"transfers_out\":3570,\"transfers_in\":1014,\"transfers_out_event\":26,\"transfers_in_event\":4,\"loans_in\":0,\"loans_out\":0,\"loaned_in\":0,\"loaned_out\":0,\"total_points\":0,\"event_points\":0,\"points_per_game\":\"0.0\",\"ep_this\":\"1.5\",\"ep_next\":\"1.5\",\"special\":false,\"minutes\":0,\"goals_scored\":0,\"assists\":0,\"clean_sheets\":0,\"goals_conceded\":0,\"own_goals\":0,\"penalties_saved\":0,\"penalties_missed\":0,\"yellow_cards\":0,\"red_cards\":0,\"saves\":0,\"bonus\":0,\"bps\":0,\"influence\":\"0.0\",\"creativity\":\"0.0\",\"threat\":\"0.0\",\"ict_index\":\"0.0\",\"ea_index\":56,\"element_type\":1,\"team\":1}";
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