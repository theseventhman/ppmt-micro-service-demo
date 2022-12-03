package com.tj.exercise.observer.demo;


import com.tj.exercise.observer.demo.publish.subscribe.PlaceOrderEvent;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationEventPublisher;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * @Author: tj
 * @Date: 2022/11/30 23:21
 */

public class OrderServiceImplTest {
    @Mock
    private ApplicationEventPublisher eventPublisher;
    @InjectMocks
    private OrderServiceImpl orderService;

    @Captor
    private ArgumentCaptor<PlaceOrderEvent> captor;

    @Before
    public void init() {
        initMocks(this);
    }

    @Test
    public void test_placeOrder() {
        orderService.placeOrder(1);
        verify(eventPublisher).publishEvent(captor.capture());
    }

}
