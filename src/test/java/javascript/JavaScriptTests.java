package javascript;

import org.testng.annotations.Test;

import base.BaseTests;

public class JavaScriptTests  extends BaseTests{
    
    @Test
    public void testScrollToTable(){
        homePage.clickLargeAndDeepDom().scrollToTable();
    }

    @Test
    public void scrollToParagraph(){
        homePage.clickInfiniteScroll().scrollToParagraph(5);
    }
    
}
