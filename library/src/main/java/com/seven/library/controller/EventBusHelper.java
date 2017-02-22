package com.seven.library.controller;

import org.greenrobot.eventbus.EventBus;

/**
 * 事件总线帮助
 * Created by Seven on 2017/2/15.
 */
public final class EventBusHelper {
    private static EventBus eventBus = EventBus.getDefault();

    public static void register(Object subscriber) {
        eventBus.register(subscriber);
    }

    public static void unregister(Object subscriber) {
        eventBus.unregister(subscriber);
    }

    public static void post(Object target) {
        eventBus.post(target);
    }

}
