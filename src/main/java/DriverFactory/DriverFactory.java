package DriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    public static void setDriver(String browser)
    {
        switch (browser.toLowerCase())
        {
            case "chrome":
                driverThreadLocal.set(new ChromeDriver());
                break;
            case "firefox":
                driverThreadLocal.set(new FirefoxDriver());
                break;
            default:
                EdgeOptions options = new EdgeOptions();
                options.addArguments("--start-maximized") ;
                driverThreadLocal.set(new EdgeDriver(options));
        }


    }
    public static WebDriver getDriver()
    {
        return driverThreadLocal.get();
    }

    public static void tearDown()
    {
        getDriver().quit();
        driverThreadLocal.remove();
    }


}
