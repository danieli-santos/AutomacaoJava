package frame;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class NestedFramesTests extends BaseTests {

    @Test
    public void testNestedFrames(){
        var nestedFrame = homePage.clickNestedFrames();
        assertEquals(nestedFrame.getLeftFrameText(), "LEFT", "Left frame text incorrect");
        assertEquals(nestedFrame.getBottomFrameText(), "BOTTOM", "Bottom frame text incorrect" );
        assertEquals(nestedFrame.getMiddleFrameText(), "MIDDLE", "Middle frame text incorrect");
        assertEquals(nestedFrame.getRightFrameText(), "RIGHT", "Rigth frame text incorrect");
    }

}
