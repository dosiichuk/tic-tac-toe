package com.kodilla.tictactoe.model.event;

import com.kodilla.tictactoe.model.enums.EventType;

public interface IEvent {
    EventType getEventType();
}
