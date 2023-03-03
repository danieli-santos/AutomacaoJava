package wait;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class WaitTests  extends BaseTests {

    @Test
    public void testWaitUntilHidden(){
        var loadingPage = homePage.clickDynamicLoading().clickExample1();

        loadingPage.clickStar();
        assertEquals(loadingPage.getLoadedText(), "Hello World!", "Loaded text incorrect");
    }

    @Test
    public void testWaitUntilHidden2(){
        var loadingPage2 = homePage.clickDynamicLoading().clickExample2();

        loadingPage2.clickStar2();
        assertEquals(loadingPage2.getLoadedText(), "Hello World!", "Loaded text incorrect");

    }

}
