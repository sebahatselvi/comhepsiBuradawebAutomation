package com.hepsiburada.testautomation.util;

import com.hepsiburada.testautomation.base.BaseTest;
import com.hepsiburada.testautomation.helper.ElementHelper;
import com.hepsiburada.testautomation.helper.StoreHelper;
import com.hepsiburada.testautomation.model.ElementInfo;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.io.*;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BaseMethods extends BaseTest {


    final static Logger logger = Logger.getLogger(BaseMethods.class);
    public WebElement findElementByKey(String key) {

        ElementInfo elementInfo = StoreHelper.INSTANCE.findElementInfoByKey(key);
        By infoParam = ElementHelper.getElementInfoToBy(elementInfo);
        WebElement webElement=webDriverWait.until(ExpectedConditions.presenceOfElementLocated(infoParam));
        return webElement;

    }

    public List<WebElement> findElementsByKey(String key) {
        ElementInfo elementInfo = StoreHelper.INSTANCE.findElementInfoByKey(key);
        By infoParam = ElementHelper.getElementInfoToBy(elementInfo);
        return driver.findElements(infoParam);
    }

    public void clickToElement(String key) {
        WebElement element = findElementByKey(key);
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

    public void clickElementandwait(String key) {
        WebElement element = findElementByKey(key);
        element.click();
        waitBySeconds(5);

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

            } else {
               logger.info("Sepet Temizlendi");
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

    public void cvsUrunKaydet(String urunFiyat, String urunAd, String dosyaAdı) throws IOException {
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
        String[] kelime = null;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(dosyaAdi), "UTF8"));
            String okunanveri = br.readLine();
            kelime = okunanveri.split("\"");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
        return kelime[1];
    }

    public void elementKarsilastir(WebElement element, WebElement element2) {
        try {
            Assert.assertEquals(element.getText(), element2.getText());
            logger.info(element.getText() + "ve" + element2.getText() + " birbirine eşit");
        } catch (Exception ex) {
            logger.info(element.getText() + "," + element2.getText() + " elementine eşit değil");
        }
    }


    public void dropDownListtenSec(List<WebElement> elements) {
        Random random = new Random();
        int index = random.nextInt(elements.size());
        if (index == 0) {
            index = random.nextInt(elements.size());
        }
        elements.get(index).click();
    }

    public void loginKontrol(String key, String value) {
        WebElement element = findElementByKey(key);
        try {
            logger.info(element.getText() + " degeri " + value + " degerine eşit");
        } catch (Exception ex) {
            logger.info("Eşitlik sağlanmadı");
            throw ex;
        }
    }

    public void rastgeleKategoriSec(String key) throws InterruptedException {
        List<WebElement> elements = findElementsByKey(key);
        Random random = new Random();
       int index = random.nextInt(elements.size());
       // int index=0;
        String css="#elektronik > div > div > div > div.col.lg-3.col-md-3.col-sm-3.menus > ul > li> a";
       if(index==0)
       {
           elements.get(index).click();
         Thread.sleep(10000);
           int index2=random.nextInt(findElementsByCssSelector(css).size());
           WebElement element=findElementsByCssSelector(css).get(index2);
           elementHover(element);
           int index3=random.nextInt(findElementsByCssSelector("#menu-0 > ul > li > a").size());
           WebElement element1=findElementsByCssSelector("#menu-0 > ul > li > a").get(index2);
           element1.click();


           Thread.sleep(10000);
       }

       else {
           try {
               logger.info(elements.get(index).getText() + " kategorisine tıklandı");
               elements.get(index).click();
           } catch (Exception ex) {
               logger.info(elements.get(index).getText() + " kategorisine tıklanamadı");
           }
       }
    }


    public void rastgeleurunBulma(String key) {
        List<WebElement> elements = findElementsByKey(key);
        Random random = new Random();
        int index = random.nextInt(elements.size());
        elementHover(elements.get(index));
    }

    public void urunFiyatDogrulamasi(String key, String dosyaAdi) {
        WebElement element = findElementByKey(key);
        try {
            Assert.assertEquals(element.getText(), cvsVeriOkuma(dosyaAdi));
            logger.info("urunun fiyatı doğru");
        } catch (Exception ex) {
            logger.info("urun fiyatı yanlış");
            throw ex;
        }
    }
    
    public void elementTextKarsilastir2(String key1, String key2) {
        WebElement element = findElementByKey(key1);
        WebElement element1 = findElementByKey(key2);
        try {
            logger.info(element.getAttribute("value") + " elementi " + element1.getText() + " elementine eşit");
            Assert.assertEquals(element.getAttribute("value"), element1.getText());
        } catch (Exception ex) {
            logger.info("değerler eşit değil");
            throw ex;
        }

    }

    public void rastgeleSecimYap(String key) {
        List<WebElement> elements = findElementsByKey(key);
        Random random = new Random();
        int index = random.nextInt(elements.size());
        if (index == 0) {
            index = random.nextInt(elements.size());
        }
        try {
            logger.info(elements.get(index).getText() + "  tıklandı");
            elements.get(index).click();
        } catch (Exception ex) {
            logger.info(elements.get(index).getText() + "  tıklanamadı");
        }

    }

    public List<WebElement> findElementsByCssSelector(String key)
    {
        List<WebElement>elements=driver.findElements(By.cssSelector(key));
        return elements;
    }

    public void deneme(String ana, String child1,String child2)
    {
        Random random=new Random();
        ana="#elektronik";
        child1="#elektronik > div > div > div > div.col.lg-3.col-md-3.col-sm-3.menus > ul > li> a";
        child2="#menu-0 > ul > li> a";
        int index2=random.nextInt(findElementsByCssSelector(child1).size());
        int index3=random.nextInt(findElementsByCssSelector(child2).size());
        WebElement anaelement=findElementsByCssSelector(ana).get(0);
        WebElement child1element=findElementsByCssSelector(child1).get(index2);
        WebElement child2element=findElementsByCssSelector(child2).get(index3);
        anaelement.click();
        elementHover(child1element);
        child2element.click();
    }
}

