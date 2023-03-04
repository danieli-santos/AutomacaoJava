package base;


import java.io.File;
import java.io.IOException;
import java.sql.Driver;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.google.common.collect.ForwardingSortedSetMultimap;
import com.google.common.io.Files;

import net.bytebuddy.jar.asm.Opcodes;
import pages.HomePage;
import utils.EventReporter;
import utils.WindowManager;


public class BaseTests {

    private EventFiringWebDriver driver;

    //private WebDriver driver;
    protected HomePage homePage;

    
    // public void setUp(){
    //     System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
    //     driver = new ChromeDriver();
    //     goHome();
    //     //      driver.manage().window().maximize();

    //     homePage = new HomePage(driver);
    // }

    //Event Listenerd
    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
        driver.register(new EventReporter());
        goHome();
        setCookie();
      //  driver.manage().window().maximize();

        //
    }
    
    @BeforeMethod
    public void goHome(){
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
    }



    @AfterClass
    public void tearDown(){
        System.out.println("Fim!!");
        driver.quit();//ele fechará qualquer uma das janelas abertas e concluirá esta sessão.
    }

    @AfterMethod
    public void takeScreenshot(ITestResult success){

        if(ITestResult.SUCCESS == success.getStatus()){
            var camera = (TakesScreenshot)driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            
            try {
            Files.move(screenshot, new File("./src/main/resources/screenshots/test.png"));
            } catch (IOException e) {
            e.printStackTrace();
            }
        }
    }

    public void recordFailure(ITestResult result){

        if (ITestResult.FAILURE == result.getStatus()) 
        {
            var camera = (TakesScreenshot)driver;   
            File failureScreenshot = camera.getScreenshotAs(OutputType.FILE);
            // Files.move(screenshot, new File("./src/main/resources/screenshots/test.png"));

            try {
                Files.move(failureScreenshot, new File("./src/main/resources/screenshots/" + result.getName() +".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            
        }
    }

    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }

    private ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        //options.setHeadless(true);//significa é que ele executará nossos testes sem realmente abrir nosso navegador.
        return options;
    }

    private void setCookie(){
        Cookie cookie = new Cookie.Builder("tau", "123")
                .domain("the-internet.herokuapp.com")
                .build();
        driver.manage().addCookie(cookie);
        driver.manage().deleteCookieNamed("optimizelySegments");
    }

    

}
