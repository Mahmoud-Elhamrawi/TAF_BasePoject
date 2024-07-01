package Utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Utility {

    //TODO:clicking on Ele
    public static void clickingEle(WebDriver driver , By locator)
    {
        new WebDriverWait(driver , Duration.ofSeconds(5)).
                until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }

   //TODo:send data to Ele
    public static void sendData(WebDriver driver , By locator , String txt)
    {
        new WebDriverWait(driver ,Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).sendKeys(txt);
    }
   //TODO:get text from Ele
    public static String getTextFromEle(WebDriver driver , By locator)
    {
        new WebDriverWait(driver , Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(locator)) ;
        return convertToWebEle(driver,locator).getText() ;
    }

  //TODO:Scrolling on Page
    public static void scrollOnPage(WebDriver driver , By locator)
    {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
                ,convertToWebEle(driver ,locator));
    }
    //TODO:Convert To WebEle
    public static WebElement convertToWebEle(WebDriver driver , By locator)
    {
        return driver.findElement(locator);
    }
    //TODO:Take screenShot
    public static final String screen_path = "Test-outputs/ScreenShots/" ;
    public static void takeScreenShot(WebDriver driver , String screenName)
    {
        try {
            File screenSrc = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            File screenDis = new File(screen_path+screenName+"__"+getTimeStemp()+".png");
            FileUtils.copyFile(screenSrc,screenDis);
        }catch (Exception e)
        {
            LogUtility.info(e.getMessage());
            e.printStackTrace();
        }
    }

    //TODO:Time Stemp
    public static String getTimeStemp()
    {
        return new SimpleDateFormat("yyyy-MM-dd -h-m-ssa").
                format(new Date());
    }

    //TODO:Select from drop-down
    public static void selectFromDropDown(WebDriver driver,By locator ,String option)
    {
        new Select(convertToWebEle(driver,locator)).selectByVisibleText(option);
    }

    //TODO: generate random numbers
    public static int generateNumbers(int upper)
    {
        return new Random().nextInt(upper);
    }
    //TODO: generate unique number
    public static Set<Integer> uniqueNumber(int needNumbers , int fromTotalNumbers)
    {
        Set<Integer> uniqueNum = new HashSet<>();
        while (uniqueNum.size()<needNumbers)
        {
            int random =generateNumbers(fromTotalNumbers);
            uniqueNum.add(random);
        }
        return uniqueNum ;
    }

}
