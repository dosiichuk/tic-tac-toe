package com.kodilla.tictactoe.model.event;

import com.kodilla.tictactoe.model.enums.EventType;

public class GameStartedEvent implements IEvent{
    private final EventType eventType = EventType.GAME_STARTED;

    @Override
    public EventType getEventType() {
        return eventType;
    }
}
