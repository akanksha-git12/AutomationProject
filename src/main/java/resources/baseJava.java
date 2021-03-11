package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class baseJava {

    public WebDriver driver;

    public WebDriver initializeDriver() throws IOException
    {
        Properties prop = new Properties();
        FileInputStream fis= new FileInputStream("C:\\Users\\Akanksha_Priyadarshi\\IdeaProjects\\Automation_Practice\\src\\main\\java\\resources\\data.properties");

        prop.load(fis);
        String browserName=prop.getProperty("browser");

        if (browserName.equals("Chrome"))
        {
            System.setProperty("webdriver.chrome.driver","C:\\Intel\\chromedriver.exe");
            driver= new ChromeDriver();
// write code

        }

        else if (browserName.equals("firefox"))
        {
//write code
            driver= new FirefoxDriver();
        }

        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        return driver;

    }
}

