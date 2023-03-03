package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EntryAdPage {

    private WebDriver driver;
    private By modalAlert = By.xpath("//div[contains(@class,'modal-title')]");
    private By closeButton = By.className("modal-footer");

    public EntryAdPage(WebDriver driver){
        this.driver = driver;
    }

    public String getModal(){
        return driver.findElement(modalAlert).getText();
    }

    public void clickButtonClose(){
        driver.findElement(closeButton).getAttribute("p");

    }





}
