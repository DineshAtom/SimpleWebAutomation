package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class LaunchBrowser {
   public static WebDriver driver ;

    /**
     * Method to launch desired browser
     * @param browser
     * @param url
     */
    @Parameters({"browser", "url"})
    @BeforeTest
    public void launchBrowser(String browser, String url) {
        System.out.println("Gonna launch browser (_--_)");
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    /**
     * Method to close browser
     * @param browser
     */
    @Parameters({"browser"})
    @AfterTest
    public void quitBrowser(String browser) {
     //   driver.quit();
        System.out.println(browser + " is Closed ʘ‿ʘ  (｡◕‿◕｡)");

    }

}
