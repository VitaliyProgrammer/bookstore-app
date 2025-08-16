package com.example.bookstore;

import org.testng.annotations.Test;

import static org.aspectj.bridge.MessageUtil.fail;

public class FailTest {
    @Test
    void thisTestShouldFail() {
        fail("Intentional fail to test CI");
    }
}
