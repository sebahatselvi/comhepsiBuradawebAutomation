package steps;

import com.hepsiburada.testautomation.util.BaseMethods;
import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class StepImplementation extends BaseMethods {
  /*  final static Logger logger = Logger.getLogger(BaseMethods.class);
    @Step("<url> adresine git")
    public void getUrl(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }

    @Step("<key> elementine tıkla")
    public void elementeTikla(String key) {
        WebElement element = findElementByKey(key);
        clickToElement(element);
    }


    @Step("<key> elementine <value> değerini gir")
    public void sendToElement(String key, String value) {
        WebElement element = findElementByKey(key);
        elementineDegeriniGonder(element, value);

    }

    @Step("<key> saniye bekle")
    public void waitBysecond(int key) {
        waitBySeconds(key);
    }

    @Step("<key> elementinin textininin <text> olduğunu doğrula")
    public void getElementText(String key, String text) {
        WebElement element = findElementByKey(key);
        Assert.assertEquals(getElementText(element), text);

    }


    //******************************************************************

    @Step("<key> elementi görüntülendi mi")
    public void elementGoruntule(String key) {
        WebElement element = findElementByKey(key);
        isDisableofElement(element);
    }

    @Step("sepet urunleri sil <urunSil2>")
    public void deneme(String urunSil2) throws InterruptedException {

        sepetiTemizle(urunSil2);
    }

    @Step("Kategoriler menusunden <key> kategorisini sec")
    public void kategorilerMenusu(String key) {
        List<WebElement> elements = findElementsByKey(key);
        Random random = new Random();
        int index = random.nextInt(elements.size());
        if (index == 0) {
            index = random.nextInt(elements.size());
        }
        try {
            logger.info(elements.get(index).getText() + " kategorisine tıklandı");
            elements.get(index).click();
        } catch (Exception ex) {
            logger.info(elements.get(index).getText() + " kategorisine tıklanamadı");
        }

    }

    @Step("Kategoriler alt menusunden <key> kategorisini sec")
    public void altkategori(String key) {
        List<WebElement> elements = findElementsByKey(key);
        rastgeleSecimUrunvsMarkavsPagination(elements);
    }

    @Step("Markalar menusunden <key> markasını sec")
    public void markalarMenusun(String key) {
        List<WebElement> elements = findElementsByKey(key);
        rastgeleSecimUrunvsMarkavsPagination(elements);
    }

    @Step("Pagination menusunden <key> numarayı sec")
    public void paginationUrun(String key) {
        List<WebElement> elements = findElementsByKey(key);
        rastgeleSecimUrunvsMarkavsPagination(elements);
    }

    @Step("Urunler menusunden <key> urununu sec")
    public void urunlerMenusun(String key) throws IOException {
        List<WebElement> elements = findElementsByKey(key);

    }

    @Step("Secilen <SecilenUrun> urunu bul")
    public void urunBulma(String key) {
        List<WebElement> elements = findElementsByKey(key);
        Random random = new Random();
        int index = random.nextInt(elements.size());
        elementHover(elements.get(index));
    }

    @Step("<adini> ve <fiyatini> <csv> dosyasına kaydet")
    public void urunAdiVsFiyati(String urunadi, String urunFiyati, String csv) throws IOException {
        WebElement urunElementi = findElementByKey(urunadi);
        WebElement fiyatElement = findElementByKey(urunFiyati);
        cvsUrunKaydet(fiyatElement.getText(), urunElementi.getText(), csv);
    }

    @Step("Secilen urunun <fiyat> detaydaki ürün fiyatına eşitmi <csv> dosyasından kontrol et")
    public void urunFiyatDogrulama(String key, String dosyaAdi) {
        WebElement element = findElementByKey(key);
        try {
            Assert.assertEquals(element.getText(), cvsVeriOkuma(dosyaAdi));
            logger.info("urunun fiyatı doğru");
        } catch (Exception ex) {
            logger.info("urun fiyatı yanlış");
            throw ex;
        }
    }

    @Step("<key1> elementinin textinin <key2> elementine eşit olduğunu goster")
    public void elementTextKarsilastir(String key1, String key2) {
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

    @Step("Urun <fiyat> ve <odenecekTutarı> kontrol et")
    public void odenecekTutarFiyatKontrol(String key1, String key2) {
        WebElement element = findElementByKey(key1);
        WebElement element1 = findElementByKey(key2);
        elementKarsilastir(element1, element);
    }

    @Step("Ulkeler menusunden <key> ulkesini sec")
    public void ulkelerMenusu(String key) {
        List<WebElement> elements = findElementsByKey(key);
        Random random = new Random();
        int index = random.nextInt(elements.size());
        if (index == 0) {
            index = random.nextInt(elements.size());
        }
        try {
            logger.info(elements.get(index).getText() + " kategorisine tıklandı");
            elements.get(index).click();
        } catch (Exception ex) {
            logger.info(elements.get(index).getText() + " kategorisine tıklanamadı");
        }

    }

    @Step("Sehirler menusunden <key> ulkesini sec")
    public void sehirlerMenusu(String key) {
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

    @Step("İlçe <key> sec")
    public void dropdownIlceSec(String key) {
        List<WebElement> elements = findElementsByKey(key);
        dropDownListtenSec(elements);

    }

    @Step("Mahalle <key> sec")
    public void dropdownMahalleSec(String key) {
        List<WebElement> elements = findElementsByKey(key);
        dropDownListtenSec(elements);

    }

    @Step("<Son Kullanma Tarihi Ay Sec> sec")
    public void dropdownAySec(String key) {
        List<WebElement> elements = findElementsByKey(key);
        dropDownListtenSec(elements);
    }

    @Step("<Hesabım> butonu üzerine git")
    public void butonUzerineGit(String key) {
        WebElement element = findElementByKey(key);
        elementHover(element);
    }

    @Step("<Yeni Adres Ekle TC> elementine TC gerekli mi kontrol et <67684101126> değerini gir")
    public void tcKimlikNoKontrol(String key, String value) throws InterruptedException {
        WebElement element1;
        while (true) {

            try {

                element1=findElementByKey(key);
            } catch (Exception ex) {
                element1=null;
            }

            if (element1 != null) {
                element1.sendKeys(value);
                driver.navigate().refresh();
                Thread.sleep((5000));

            } else {
                break;
            }
        }

    }

    @Step("Sayfayı yenile")
    public void sayfayiYenile() throws InterruptedException {
        driver.navigate().refresh();
        Thread.sleep((5000));
    }

    @Step("Adresleri  sil <Adresi Sil> ,<Adresi Sil Onayla>")
    public void adresiTemizle(String buton1, String buton2) throws InterruptedException {

        adresiTemizle2(buton1,buton2);

    }

    @Step("<key> elementinin texti <value> değerine eşitmi?")
    public void loginKontrol(String key, String value)
    {
        WebElement element=findElementByKey(key);
        try {
            logger.info(element.getText()+" degeri "+value+" degerine eşit");
        }
        catch (Exception ex)
        {
            logger.info("Eşitlik sağlanmadı");
            throw  ex;
        }
    }
*/
}
