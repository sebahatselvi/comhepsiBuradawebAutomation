package com.hepsiburada.testautomation.base;

import com.thoughtworks.gauge.*;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.net.URL;
import static java.lang.System.getenv;
import static java.lang.System.setOut;

public class BaseTest {
    protected static WebDriver driver;
    protected static WebDriverWait webDriverWait;
    private static Logger logger = LoggerFactory.getLogger(BaseTest.class);
    private DesiredCapabilities capabilities;
    public void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, 30,250);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }

    @BeforeScenario
    public void setUp(ExecutionContext executionContext) throws Exception{

        logger.info("" + executionContext.getCurrentScenario().getName());
      /*  DesiredCapabilities capabilities = DesiredCapabilities.chrome();
       // if (StringUtils.isNotEmpty(getenv("key"))) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("test-type");
            options.addArguments("disable-popup-blocking");
            options.addArguments("ignore-certificate-errors");
            options.addArguments("disable-translate");
            options.addArguments("--start-maximized");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-popup-blocking");
            options.addArguments("test-type");
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            capabilities.setCapability("key", System.getenv("key"));
            driver = new RemoteWebDriver(new URL("http://192.168.60.117:4444/wd/hub"), capabilities);
            webDriverWait=new WebDriverWait(driver,20,250);
            driver.get("https://www.hepsiburada.com/");
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
           // ((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
       // }
        /* else {
            System.setProperty("webdriver.chrome.driver", "web_driver/chromedriver");
            ChromeOptions options = new ChromeOptions();
//          options.addArguments("--kiosk");//FULLSCREEN FOR MAC
            driver = new ChromeDriver(options);
            webDriverWait=new WebDriverWait(driver,20,250);
            driver.get("https://www.hepsiburada.com/");
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
        }*/

        FirefoxProfile profile = new FirefoxProfile();
        capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability(FirefoxDriver.PROFILE,profile);
        capabilities.setCapability("marionette",true);


       /* ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);*/


        driver = new RemoteWebDriver(new URL("http://192.168.60.117:4444/wd/hub"),capabilities);
        webDriverWait=new WebDriverWait(driver,20,250);
        driver.get("https://www.hepsiburada.com/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }
    @BeforeStep
    public void beforeStep(ExecutionContext executionContext){


        logger.info(executionContext.getCurrentStep().getDynamicText());
       waitForPageLoaded();
    }
    @AfterStep
    public void afterStep(ExecutionContext executionContext){

        if (executionContext.getCurrentStep().getIsFailing()) {
            logger.error(executionContext.getCurrentScenario().getName());
            logger.error(executionContext.getCurrentStep().getDynamicText());
            logger.error(executionContext.getCurrentStep().getErrorMessage() + "\r\n"
                    + executionContext.getCurrentStep().getStackTrace());
        }

    }

    @AfterScenario
    public void tearDown(){
        driver.quit();
    }

}
