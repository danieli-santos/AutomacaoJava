package navigation;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

import base.BaseTests;

public class WindowTests  extends BaseTests {
    
    @Test
    public void testWindows(){
        var buttonPaga = homePage.clickDynamicLoading().rightClickOnExample2Link();
        getWindowManager().switchToNewTab();
        assertTrue(buttonPaga.isStartButtonDisplayed(), "Start button is not displayed");

    }
}
