package com.ejemplo.serverfansj;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ConfigTest {

    @Test
    public void testGettersAndSetters() {
        Config config = new Config();

        config.setUser("testUser");
        config.setPassword("testPassword");
        config.setIp("127.0.0.1");
        config.setSpeed(50);

        assertEquals("testUser", config.getUser());
        assertEquals("testPassword", config.getPassword());
        assertEquals("127.0.0.1", config.getIp());
        assertEquals(50, config.getSpeed());
    }
}
