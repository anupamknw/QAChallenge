package com.autohero.ui.tests;

import com.autohero.utilities.ConfigFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver driver=null;
    public String BROWSER="";

    public void setUp()
    {
        BROWSER = new ConfigFileReader().getBrowser();
        if (BROWSER.contentEquals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (BROWSER.contentEquals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else {
            System.err.println("Invalid browser");
            System.exit(0);
        }
        driver.get(new ConfigFileReader().getSearchURL());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
}
