package E2E;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import resources.baseJava;

//Access methods of other class
//1. Inheritance
//2. creating object to that class and invoke methods to it
public class HomePage extends baseJava {

    @Test
    public void basePageNavigation() throws IOException
    {
        driver= initializeDriver();
        driver.get("https://www.covid19india.org/");
        driver.manage().window().maximize();

        LandingPage l = new LandingPage(driver);
        l.expandTable().click();
        l.sortTPR().click();

        String str1;
        String str2="";

        WebElement webtable= driver.findElement(By.xpath("//div[@class='home-left expanded']"));
        List<WebElement> rows= webtable.findElements(By.xpath("//div[@class='cell']"));
        int rowscount= rows.size();
        for (int i=0;i<rowscount;i++)
        {
            List<WebElement> columns= rows.get(i).findElements(By.xpath("//div[@class='cell heading']"));
            int columnscount= columns.size();

            if (i>2) {
                break;}

            for(int j=0;j<columnscount;j++)
            {
                str1= rows.get(i).getText();

                if(str1.equals(str2)) {
                    continue;
                }
                else {
                    System.out.println(str1);
//System.out.println(str2);
                    str2=str1;
                }
//System.out.println(columns.get(j).getText());

            }


        }
//List<WebElement> input= driver.findElements(By.tagName("div"));
//System.out.println(input.size());

//for(WebElement value: input)
//{
//System.out.println(value.getAttribute("cell"));
//}

        driver.close();
    }
}

