package com.waheed.fantasy_premier_league_api.players;

import com.waheed.fantasy_premier_league_api.players.PlayerType;

/**
 * Created by waheedelmiladi on 16/10/2016.
 */
public class Goalkeeper extends PlayerType {
    public Goalkeeper(int id, String singularName, String singularNameShort, String pluralName, String pluralNameShort) {
        super(id, singularName, singularNameShort, pluralName, pluralNameShort);
    }
}
