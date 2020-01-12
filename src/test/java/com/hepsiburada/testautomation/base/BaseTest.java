package com.hepsiburada.testautomation.base;

import com.thoughtworks.gauge.*;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;

import static java.lang.System.getenv;

public class BaseTest {
    protected static WebDriver driver;
    protected static WebDriverWait webDriverWait;
    private static Logger logger = LoggerFactory.getLogger(BaseTest.class);

    @BeforeScenario
    public void setUp(ExecutionContext executionContext) throws Exception{

        logger.info("" + executionContext.getCurrentScenario().getName());
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        if (StringUtils.isNotEmpty(getenv("key"))) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("test-type");
            options.addArguments("disable-popup-blocking");
            options.addArguments("ignore-certificate-errors");
            options.addArguments("disable-translate");
            options.addArguments("--start-maximized");
            options.addArguments("--no-sandbox");
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            capabilities.setCapability("key", System.getenv("key"));
            driver = new RemoteWebDriver(new URL("http://hub.testinium.io/wd/hub"), capabilities);
            ((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
        } else {
            System.setProperty("webdriver.chrome.driver", "web_driver/chromedriver");
            ChromeOptions options = new ChromeOptions();
//      options.addArguments("--kiosk");//FULLSCREEN FOR MAC
            driver = new ChromeDriver(options);
        }


    }

    @BeforeStep
    public void beforeStep(ExecutionContext executionContext){

        logger.info(executionContext.getCurrentStep().getDynamicText());
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
