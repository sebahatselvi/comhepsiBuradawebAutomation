package com.hepsiburada.testautomation.util;

import com.hepsiburada.testautomation.base.BaseTest;
import com.hepsiburada.testautomation.helper.ElementHelper;
import com.hepsiburada.testautomation.helper.StoreHelper;
import com.hepsiburada.testautomation.model.ElementInfo;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BaseMethods extends BaseTest {

    public WebDriverWait wait = new WebDriverWait(driver, 20);
    final static Logger logger = Logger.getLogger(BaseMethods.class);
    public WebElement findElementByKey(String key) {
        ElementInfo elementInfo = StoreHelper.INSTANCE.findElementInfoByKey(key);
        By infoParam = ElementHelper.getElementInfoToBy(elementInfo);
        WebDriverWait webDriverWait = new WebDriverWait(driver, 0);
        WebElement webElement = webDriverWait
                .until(ExpectedConditions.presenceOfElementLocated(infoParam));
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'center'})",
                webElement);
        return webElement;
    }
    public List<WebElement> findElementsByKey(String key) {
        ElementInfo elementInfo = StoreHelper.INSTANCE.findElementInfoByKey(key);
        By infoParam = ElementHelper.getElementInfoToBy(elementInfo);
        return driver.findElements(infoParam);
    }
    public void clickToElement(WebElement element) {
        try {
            logger.info("clickElement method called:  clicking " + element);
            element.click();
        } catch (
                Exception ex) {
            logger.error(element + " elementine tıklanamadı!!!");
            throw ex;
        }
    }
    public void sendToElement(String key, String value) {
        try {
            WebElement element = findElementByKey(key);
            logger.info("sendKey method called: sending" + value + "to" + key);
            element.sendKeys(value);
        } catch (Exception ex) {
            logger.info(key + " elementine " + value + " değeri yazılamadı");
            throw ex;
        }
    }
    public void waitBySeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public String getElementText(WebElement element) {
        return element.getText();
    }
    public void elementineDegeriniGonder(WebElement element, String deger) {
        try {
            logger.info(element + " elementine " + deger + " degeri gonderildi");
            element.sendKeys(deger);
        } catch (Exception ex) {
            logger.info(element + " elementine " + deger + " degeri gonderildi");
            throw ex;
        }

    }



}

