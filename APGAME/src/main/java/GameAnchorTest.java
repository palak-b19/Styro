package com.stickheroap.stickheroap;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;
import static org.testng.AssertJUnit.assertTrue;

public class GameAnchorTest {
    @Test
    public void testSum() {
        GameController gameController = new GameController();
        assertNotNull(gameController.getMain_pane());
    }
}