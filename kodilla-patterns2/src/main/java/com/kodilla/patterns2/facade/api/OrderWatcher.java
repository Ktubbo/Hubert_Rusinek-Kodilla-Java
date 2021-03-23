package com.kodilla.patterns2.facade.api;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class OrderWatcher {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderWatcher.class);

    @Before(value = "execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..)) && args(userId) && target(object)",
            argNames = "userId,object")
    public void logEvent(Long userId, Object object) {
        LOGGER.info("Class: " + object.getClass().getName() + ", ID: " + userId);
    }
}
