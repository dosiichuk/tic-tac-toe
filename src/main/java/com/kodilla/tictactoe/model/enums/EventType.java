package com.kodilla.tictactoe.model.enums;

public enum EventType {
    GAME_STARTED("GAME_STARTED"),
    PLAYER1_INPUT_RECEIVED("PLAYER1_INPUT_RECEIVED"),
    PLAYER2_INPUT_RECEIVED("PLAYER2_INPUT_RECEIVED"),
    ROUND_COMPLETE("ROUND_COMPLETE"),
    WINNER_DETERMINED("WINNER_DETERMINED");

    private final String eventTypeDescr;

    EventType(String eventTypeDescr) {
        this.eventTypeDescr = eventTypeDescr;
    }

    public String getEventTypeDescr() {
        return eventTypeDescr;
    }

    public static String getDescriptionForType(EventType type) {
        return type.getEventTypeDescr();
    }

}
