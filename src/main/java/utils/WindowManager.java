package utils;

import org.openqa.selenium.WebDriver;

public class WindowManager {
    private WebDriver driver;
    private WebDriver.Navigation navigate;

    public WindowManager(WebDriver driver){
        this.driver = driver;
        navigate = driver.navigate();
    }
//que irá navegar para a última página visitada no histórico do navegador
    public void goBack(){
        navigate.back();
    
    }
// que avançará uma página no histórico do navegador
    public void goForward(){
        navigate.forward();
    }
//irá recarregar a página atual
    public void refreshPage(){
        navigate.refresh();
    }
//um que leva uma String e outro que leva um URL. ambos vão diretamente para o URL especificado
    public void goTo(String url){
        navigate.to(url);
        
    }
    public void swtchToTab(String tabTitle){
        var windows = driver.getWindowHandles();
        System.out.println("Number of tabs: " + windows.size());

        System.out.println("Window handles:");
        windows.forEach(System.out::println);
        
        

        windows.forEach(System.out::println);

        for( String window : windows){
            System.out.println("Switching to window: " + window);
            
            driver.switchTo().window(window);
            
            System.out.println("Current window title: " + driver.getTitle());

            if(tabTitle.equals(driver.getTitle())){
                break;
            }
        }

    }

}
