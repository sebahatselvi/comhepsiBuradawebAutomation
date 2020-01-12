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

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SepetKontrolMethods extends BaseTest {

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

    public void sepetiTemizle(String key) throws InterruptedException {
        WebElement element;
        while (true) {

            try {
                element = findElementByKey(key);
            } catch (Exception ex) {
                element = null;
            }

            if (element != null) {

                element.click();
                driver.navigate().refresh();
                Thread.sleep((5000));

            } else {
                System.out.println("sepette ürün kalmadı");
                break;
            }
        }
    }

    public void adresiTemizle2(String key,String key2) throws InterruptedException {
        WebElement element;
        WebElement element1;
        while (true) {

            try {
                element = findElementByKey(key);
                element1=findElementByKey(key2);
            } catch (Exception ex) {
                element = null;
                element1=null;
            }

            if (element != null) {

                element.click();
                Thread.sleep((5000));
                element1.click();
                driver.navigate().refresh();
                Thread.sleep((5000));

            } else {
                System.out.println("adresler silindi");
                break;
            }
        }
    }

    public void sepetiTemizleJS(String key) throws InterruptedException {
        List<WebElement> elementList = findElementsByKey(key);
        int counter = 0;
        if (elementList != null)
            counter = elementList.size();
        while (counter > 0) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("$('.btn-delete').click()");
            counter--;
        }
    }

    public void cvsUrunKaydet(String urunFiyat, String urunAd,String dosyaAdı) throws IOException {
        FileWriter csvWriter = new FileWriter(dosyaAdı);
        csvWriter.append("\"" + urunAd + "\"");
        csvWriter.append(",");
        csvWriter.append("\"" + urunFiyat + "\"");
        csvWriter.flush();
        csvWriter.close();
    }

    public void elementHover(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    public void rastgeleSecimUrunvsMarkavsPagination(List<WebElement> elements) {
        Random random = new Random();
        int index = random.nextInt(elements.size());
        try {
            logger.info(elements.get(index).getText() + "  elementine tıklandı");
            elements.get(index).click();
        } catch (Exception ex) {
            logger.info(elements.get(index).getText() + "  elementine tıklanamadı");
            throw ex;

        }
    }

    public void isDisableofElement(WebElement element) {
        try {
            logger.info(element + "  görüntülendi");
            element.isDisplayed();
        } catch (Exception ex) {
            logger.info(element + " elementi bulunamadı");
            throw ex;
        }
    }

    public String cvsVeriOkuma(String dosyaAdi) {

        BufferedReader br = null;
        String line = "";
        String[] kelime = null;
        List lstdeneme = new ArrayList();
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(dosyaAdi), "UTF8"));
            String okunanveri = br.readLine();
            kelime = okunanveri.split("\"");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
        return kelime[3];
    }

    public void elementKarsilastir(WebElement element, WebElement element2) {
        try {
            Assert.assertEquals(element.getText(), element2.getText());
            logger.info(element.getText() + "ve" + element2.getText() + " birbirine eşit");
        } catch (Exception ex) {
            logger.info(element.getText() + "," + element2.getText() + " elementine eşit değil");
        }
    }
    public void elementTextKarsilastir(String key1, String key2)
    {
        WebElement element=findElementByKey(key1);
        WebElement element1=findElementByKey(key2);
        try {
            logger.info(element.getAttribute("value")+" elementi "+element1.getText()+" elementine eşit");
            Assert.assertEquals(element.getAttribute("value"),element1.getText());
        }
        catch (Exception ex)
        {
            logger.info("değerler eşit değil");
            throw  ex;
        }

    }

    public void dropDownListtenSec(List<WebElement> elements)
    {
        Random random=new Random();
        int index=random.nextInt(elements.size());
        if(index==0)
        {
            index=random.nextInt(elements.size());
        }
        elements.get(index).click();
    }
}

