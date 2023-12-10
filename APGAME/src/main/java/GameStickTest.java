package com.stickheroap.stickheroap;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

public class GameStickTest {
    @Test
    public void testSum() {
        GameController gameController = new GameController();
        assertNotNull(gameController.getStick_rect());
    }
}