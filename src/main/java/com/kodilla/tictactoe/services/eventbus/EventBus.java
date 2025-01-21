package com.kodilla.tictactoe.services.eventbus;

import com.kodilla.tictactoe.model.enums.EventType;
import com.kodilla.tictactoe.model.event.IEvent;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

public class EventBus implements IEventBus {
    private final Map<String, Set<Consumer<IEvent>>> listeners = new HashMap<>();

    @Override
    public void subscribe(EventType eventType, Consumer<IEvent> listener) {
        listeners.computeIfAbsent(EventType.getDescriptionForType(eventType), k -> new HashSet<>()).add(listener);
    }

    @Override
    public void unsubscribe(EventType eventType, Consumer<IEvent> listener) {
        Set<Consumer<IEvent>> eventListeners = listeners.get(EventType.getDescriptionForType(eventType));
        if (eventListeners != null) {
            eventListeners.remove(listener);
        }
    }

    public void publish(IEvent event) {
        Set<Consumer<IEvent>> eventListeners = listeners.get(event.getEventType());
        if (eventListeners != null) {
            for (Consumer<IEvent> listener : eventListeners) {
                listener.accept(event);
            }
        }
    }

}
