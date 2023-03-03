package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicLoadingExample2Page {
    private WebDriver driver;
    private By starButton2 = By.cssSelector("#start button");
//    private By loadingIndicator2 = By.id("loading");
    private By loadedText2 = By.xpath("//h4[contains(.,'Hello World!')]");


    public DynamicLoadingExample2Page(WebDriver driver){
        this.driver = driver;
    }
    public void clickStar2(){
          driver.findElement(starButton2).click();
          WebDriverWait wait = new WebDriverWait(driver, 5);
          wait.until(ExpectedConditions.presenceOfElementLocated(loadedText2));

    }
//    public boolean isStartButtonDisplayed(){
//        return driver.findElement(starButton2).isDisplayed();
//    }
    public String getLoadedText(){
//          WebDriverWait wait = new WebDriverWait(driver, 10);
//          wait.until(ExpectedConditions.invisibilityOf(driver.findElement(loadedText2)));


        return driver.findElement(loadedText2).getText();

    }
}
