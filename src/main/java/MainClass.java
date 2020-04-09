
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainClass {
    static WebDriver driver;

    public static void main(String[] args) {
        //MainClass m=new MainClass();
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\nazhivka.by\\IdeaProjects\\testselenium\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.w3schools.com/html/html_tables.asp");
        WebElement Elementtable= driver.findElement(By.xpath("//table[@id='customers']"));

        table tabl=new table(Elementtable, driver);
        System.out.println("rows number is"+tabl.getRows().size());
        System.out.println(tabl.getValueFromCell(2,3));
        System.out.println(tabl.getValueFromCell(4, "Country"));

        driver.quit();






    }


}
