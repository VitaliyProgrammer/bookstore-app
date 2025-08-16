package com.example.bookstore;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class FailTest {
    @Test
    void thisTestShouldFail() {
        fail("Intentional fail to test CI");
    }

    @Test
    void shouldFail() {
        assertEquals(1, 2);
    }
}
