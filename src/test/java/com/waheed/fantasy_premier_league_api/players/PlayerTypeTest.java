package com.waheed.fantasy_premier_league_api.players;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by waheedelmiladi on 16/10/2016.
 */
public class PlayerTypeTest {
    @Test
    public void getGoalkeeperById() throws Exception {
        PlayerType goalkeeper = PlayerType.byId(1);

        assertEquals(goalkeeper.getSingularName(), "Goalkeeper");
        assertEquals(goalkeeper.getSingularNameShort(), "GKP");
        assertEquals(goalkeeper.getPluralName(), "Goalkeepers");
        assertEquals(goalkeeper.getPluralNameShort(), "GKP");
    }

    @Test
    public void getDefenderById() throws Exception {
        PlayerType defender = PlayerType.byId(2);

        assertEquals(defender.getSingularName(), "Defender");
        assertEquals(defender.getSingularNameShort(), "DEF");
        assertEquals(defender.getPluralName(), "Defenders");
        assertEquals(defender.getPluralNameShort(), "DEF");
    }

    @Test
    public void getMidfielderById() throws Exception {
        PlayerType midfielder = PlayerType.byId(3);

        assertEquals(midfielder.getSingularName(), "Midfielder");
        assertEquals(midfielder.getSingularNameShort(), "MID");
        assertEquals(midfielder.getPluralName(), "Midfielders");
        assertEquals(midfielder.getPluralNameShort(), "MID");
    }

    @Test
    public void getForwardById() throws Exception {
        PlayerType forward = PlayerType.byId(4);

        assertEquals(forward.getSingularName(), "Forward");
        assertEquals(forward.getSingularNameShort(), "FWD");
        assertEquals(forward.getPluralName(), "Forwards");
        assertEquals(forward.getPluralNameShort(), "FWD");
    }
}