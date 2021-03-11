package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
    public WebDriver driver;

    By expand= By.xpath("//div[@class='home-left']/div[4]/div[4]");
    By testPositiveRatio= By.xpath("//*[contains(text(), 'Test Positivity Ratio')]");



    public LandingPage(WebDriver driver) {
// TODO Auto-generated constructor stub
        this.driver= driver;
    }

    public WebElement expandTable()
    {
        return driver.findElement(expand);
    }


    public WebElement sortTPR()
    {
        return driver.findElement(testPositiveRatio);
    }

}

