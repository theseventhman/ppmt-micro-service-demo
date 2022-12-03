package com.tj.exercise.observer.demo;


import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * @Author: tj
 * @Date: 2022/11/30 23:21
 */

public class OrderServiceImplTest {
    @Test
    public void test_placeOrder() {
       new OrderServiceImpl().placeOrder(1);
    }

}
