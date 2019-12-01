package com.ysx.demo.config.shiro;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;

import java.util.concurrent.atomic.AtomicInteger;

public class MySessionListener implements SessionListener {
    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(SessionListener.class);
    private final AtomicInteger sessionCount = new AtomicInteger(0);

    @Override
    public void onStart(Session session) {
        sessionCount.incrementAndGet();
        LOGGER.info("登陆+1=="+sessionCount.get());
    }

    @Override
    public void onStop(Session session) {
        sessionCount.decrementAndGet();
        LOGGER.info("登陆-1=="+sessionCount.get());
    }

    @Override
    public void onExpiration(Session session) {
        sessionCount.decrementAndGet();
        LOGGER.info("登陆过期-1=="+sessionCount.get());
    }
}