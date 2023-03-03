package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class DynamicLoadingPage {

    private WebDriver driver;
    private By  linkXpath_Formt = By.xpath("//a[contains(.,'Example 1: Element on page that is hidden')]");
//    private String linkXpath_Format = ".//a[contains(text(), '%s')]";
//    private By link_Example1 = By.xpath(String.format(linkXpath_Format, "Example 1"));
    private  By linkXpath_Formt2 = By.xpath("//a[contains(.,'Example 2: Element rendered after the fact')]");

    public DynamicLoadingPage(WebDriver driver){
        this.driver = driver;
    }

    public DynamicLoadingExample1Page clickExample1(){
        driver.findElement(linkXpath_Formt).click();
        return new DynamicLoadingExample1Page(driver);
    }

    public DynamicLoadingExample2Page clickExample2(){
        driver.findElement(linkXpath_Formt2).click();
        return new DynamicLoadingExample2Page(driver);
    }


    public DynamicLoadingExample2Page rightClickOnExample2Link(){
        driver.findElement(linkXpath_Formt2).sendKeys(Keys.COMMAND, Keys.RETURN );
        return new DynamicLoadingExample2Page(driver);
    }

}
