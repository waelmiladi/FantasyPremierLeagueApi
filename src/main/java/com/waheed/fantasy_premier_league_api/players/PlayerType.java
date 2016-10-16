package com.waheed.fantasy_premier_league_api.players;

import com.waheed.fantasy_premier_league_api.Player;

import java.util.HashMap;
import java.util.Map;

/**
 * {"id":1,"singular_name":"Goalkeeper","singular_name_short":"GKP","plural_name":"Goalkeepers","plural_name_short":"GKP"}
 */
public class PlayerType {
    private int id;
    private String singularName;
    private String singularNameShort;
    private String pluralName;
    private String pluralNameShort;

    public PlayerType(int id, String singularName, String singularNameShort, String pluralName, String pluralNameShort) {
        this.id = id;
        this.singularName = singularName;
        this.singularNameShort = singularNameShort;
        this.pluralName = pluralName;
        this.pluralNameShort = pluralNameShort;
    }

    public int getId() {
        return id;
    }

    public String getSingularName() {
        return singularName;
    }

    public String getSingularNameShort() {
        return singularNameShort;
    }

    public String getPluralName() {
        return pluralName;
    }

    public String getPluralNameShort() {
        return pluralNameShort;
    }

    public static PlayerType byId(int id) {
        return types().get(id);
    }

    private static Map<Integer, PlayerType> types() {
        Map<Integer, PlayerType> playerTypes = new HashMap<Integer, PlayerType>();

        Goalkeeper goalkeeper = PlayerType.goalkeeper();
        Defender defender = PlayerType.defender();
        Midfielder midfielder = PlayerType.midfielder();
        Forward forward = PlayerType.forward();

        playerTypes.put(goalkeeper.getId(), goalkeeper);
        playerTypes.put(defender.getId(), defender);
        playerTypes.put(midfielder.getId(), midfielder);
        playerTypes.put(forward.getId(), forward);

        return playerTypes;
    }


    private static Goalkeeper goalkeeper() {
        return new Goalkeeper(1, "Goalkeeper", "GKP", "Goalkeepers", "GKP");
    }

    private static Defender defender() {
        return new Defender(2, "Defender", "DEF", "Defenders", "DEF");
    }

    private static Midfielder midfielder() {
        return new Midfielder(3, "Midfielder", "MID", "Midfielders", "MID");
    }

    private static Forward forward() {
        return new Forward(4, "Forward", "FWD", "Forwards", "FWD");
    }
}
