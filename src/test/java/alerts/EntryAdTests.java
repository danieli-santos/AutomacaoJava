package alerts;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class EntryAdTests extends BaseTests {

    @Test
    public void testModal() throws InterruptedException {

        var EntryAdPage = homePage.clickEntryAd();

        String text = EntryAdPage.getModal();
        assertEquals(text, "", "Alert text incorrect");

        EntryAdPage.clickButtonClose();


    }

}
