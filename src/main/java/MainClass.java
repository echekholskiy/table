import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class MainClass {
    static WebDriver driver;
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\nazhivka.by\\IdeaProjects\\testselenium\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://catalog.onliner.by/washingmachine");
        clickCheckBox("LG");
        clickCheckBox("Samsung");





    }
    public static void clickCheckBox(String name){
        String rbXpath="//span[text()='%s']/parent::label";
        if (!driver.findElement(By.xpath(String.format(rbXpath, name)+"/input")).isSelected()){
            driver.findElement(By.xpath(String.format(rbXpath, name))).click();
        }

    }

}
