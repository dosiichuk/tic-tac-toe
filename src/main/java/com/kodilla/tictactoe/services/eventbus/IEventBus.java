package com.kodilla.tictactoe.services.eventbus;

import com.kodilla.tictactoe.model.enums.EventType;
import com.kodilla.tictactoe.model.event.IEvent;

import java.util.function.Consumer;

public interface IEventBus {
    void subscribe(EventType eventType, Consumer<IEvent> listener);
    void unsubscribe(EventType eventType, Consumer<IEvent> listener);
    void publish(IEvent event);
}
