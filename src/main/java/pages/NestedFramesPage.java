package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NestedFramesPage {

    private WebDriver driver;
    private String topFrame = "frame-top";
    private String leftFrame = "frame-left";
    private String bottomFrame = "frame-bottom";
    private String middleFrame = "frame-middle";
    private String rightFrame = "frame-right";
    private By middleId = By.id("content");
    private By body = By.tagName("body");


    public NestedFramesPage(WebDriver driver) {
        this.driver = driver;

    }

    public String getLeftFrameText(){
        driver.switchTo().frame(topFrame);
        driver.switchTo().frame(leftFrame);
        String text = getFrameText();
        driver.switchTo().parentFrame();
        driver.switchTo().parentFrame();
        return text;

    }

    public String getBottomFrameText(){
        driver.switchTo().frame(bottomFrame);
        String text = getFrameText();
        driver.switchTo().parentFrame();
        return text;
    }

    public String getMiddleFrameText(){
        driver.switchTo().frame(topFrame);
        driver.switchTo().frame(middleFrame);
        String text = getFrameTextMiddle();
        driver.switchTo().parentFrame();
        driver.switchTo().parentFrame();
        driver.switchTo().parentFrame();
        return text;
    }

    public String getRightFrameText(){
        driver.switchTo().frame(topFrame);
        driver.switchTo().frame(rightFrame);
        String text = getFrameText();
        driver.switchTo().parentFrame();
        driver.switchTo().parentFrame();
        return text;
    }

    private String getFrameText(){
        return driver.findElement(body).getText();
    }

    private String getFrameTextMiddle(){
        return driver.findElement(middleId).getText();
    }

}
