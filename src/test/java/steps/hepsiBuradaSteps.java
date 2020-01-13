package steps;

import com.hepsiburada.testautomation.util.BaseMethods;
import com.thoughtworks.gauge.Step;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

public class hepsiBuradaSteps extends BaseMethods {

    @Step("<key> sitesine git")
    public void sayfaAc(String key)
    {
        driver.manage().window().maximize();
        driver.get(key);
    }

    @Step("<Giris Yap Butonuna> Tıkla ")
    public void girisyapbutonu(String key)
    {
        WebElement element=findElementByKey(key);
        element.click();
    }

    @Step("<Kullanıcı Alanına> <kullanıcı Adı> gir")
    public void kullaniciAdi(String key,String kullaniciAdi)
    {
        sendToElement(key,kullaniciAdi);

    }

    @Step("<Şifre Alanına> <sifre> gir")
    public void sifre(String key,String sifre)
    {
        sendToElement(key,sifre);
    }

    @Step("<Login Kontrolu> <kullanıcı adı> ile kontrol yap")
    public void loginKontrolEt(String key, String value)
    {
        loginKontrol(key,value);
    }

    @Step(" <Sepete> git urunleri temizle")
    public void sepetTutar(String key)
    {
         sepetiTemizle(key);
    }

    @Step("<Ratgele bir kategorinin> üzerine git")
    public void menuKategoriler(String key)
    {
      rastgeleKategoriSec(key);
    }
    @Step("<Rastgele bir alt kategori> sec")
    public void kategoriAltMenu(String key)
    {
        List<WebElement> elements = findElementsByKey(key);
        rastgeleSecimUrunvsMarkavsPagination(elements);
    }

    @Step("<Ratgele bir marka> sec")
    public void markasec(String key)
    {
        List<WebElement> elements = findElementsByKey(key);
        rastgeleSecimUrunvsMarkavsPagination(elements);

    }

    @Step("<Minimum Fiyat Aralıgını> <value> gir")
    public void minFiyat(String key,String value)
    {
        sendToElement(key,value);

    }


    @Step("<Maksimum Fiyat Aralıgını> <value> gir ")
    public void maxFiyat(String key,String value)
    {
        sendToElement(key,value);
    }

    @Step("<Fiyat Buton> tıkla")
    public void fiyatButonTikla(String key)
    {
        WebElement element=findElementByKey(key);
        element.click();
    }

    @Step("<Ratgele bir urun>sec <Urun Adı> ve <Urun Fiyatı> nı <csv> dosyasına kaydet ")
    public void urunAdiniFiyatiniKaydet(String element,String urunAdi, String urunFiyati, String csv) throws IOException {
        rastgeleurunBulma(element);
        WebElement urunadi=findElementByKey(urunAdi);
        WebElement urunfiyat=findElementByKey(urunFiyati);
        cvsUrunKaydet(urunfiyat.getText(),urunfiyat.getText(),csv);

    }

    @Step("Detay sayfasındaki <Urun Fiyatı> nı <csv> dosyasından kontrol et")
    public void urunFiyatKontrol(String key, String csv)
    {
      urunFiyatDogrulamasi(key,csv);
    }

    @Step("<Sepete ekle> butonuna tıkla")
    public void sepeteEkle(String key)
    {
     WebElement element=findElementByKey(key);
     element.click();
    }

    @Step("<Eklenen Urun Sayısı> ile <Sepet Uzerindeki Sayı> kontrol et ve <Sepete> git")
    public void urunsayısıKontrol(String eklenenUrun, String sepetUzerindekiSayi,String sepet)
    {
        elementTextKarsilastir2(eklenenUrun,sepetUzerindekiSayi);
        WebElement element=findElementByKey(sepet);
        element.click();
    }

    @Step("<Adet Sayısı> nı iki arttır")
    public void adetSayisiniArtır(String key)
    {
        WebElement element=findElementByKey(key);
        for(int i=0;i<2;i++)
        {
            element.click();
        }

    }

    @Step("<Urun tutar> ile <Odenecek tutarı> karşılatır")
    public void tutarKontrol(String urunTutar, String odenecekTutar)
    {
        WebElement element = findElementByKey(urunTutar);
        WebElement element1 = findElementByKey(odenecekTutar);
        elementKarsilastir(element1, element);
    }

    @Step("<Ürün toplamı değeri> ve <kargo tutarı> <csv> dosyasına yazdırılır ve <alışverişi tamamla butonuna> tıklanır")
    public void urunToplamDegeriveKargoTutarinicsvdosyasınaKaydet(String urunToplamdeger, String kargotutari,String csv,String alısverisitamamla) throws IOException {
        WebElement urunElementi = findElementByKey(urunToplamdeger);
        WebElement fiyatElement = findElementByKey(kargotutari);
        cvsUrunKaydet(fiyatElement.getText(), urunElementi.getText(), csv);
        WebElement element=findElementByKey(alısverisitamamla);
        element.click();

    }

    @Step("<Yeni Adres Ekle> butonuna tıkla")
            public void yeniAdresEkle(String key)
    {
        WebElement element = findElementByKey(key);
        clickToElement(element);
    }

    @Step("<Ad Giriniz> alanına <isim> gir")
    public void isimgir(String key, String value)
    {
      sendToElement(key,value);
    }
    @Step("<Soyisim> alanına <isim> gir")
    public void soyisimGir(String key, String value)
    {
        sendToElement(key,value);
    }
    @Step("<Sehir dropdonwn> menusunden <sehir> sec")
    public void sehirSec(String sehirDrop, String sehir)
    {
       WebElement element=findElementByKey(sehir);
       element.click();
    }

    @Step("<İlce dropdonwn> menusunden <ilce> sec")
    public void ilceSec(String sehirDrop, String sehir)
    {
        WebElement element=findElementByKey(sehir);
        element.click();
        rastgeleSecimYap(sehir);

    }
    @Step("<Mahalle dropdonwn> menusunden <mahalle> sec")
    public void mahalleSec(String mahalledrop, String mahalle)
    {
        WebElement element=findElementByKey(mahalle);
        element.click();
        rastgeleSecimYap(mahalledrop);
    }
    @Step("<Adres> alanına <adres> yaz")
    public void adresYaz(String adresalani, String adres)
    {
         sendToElement(adresalani,adres);
    }
    @Step("<Adres Adı> alanına <adres adı> nı yaz")
    public void adresAdi(String key, String value)
    {
       sendToElement(key,value);
    }

    @Step("<Telefon Numarası> alanına <telefon no> gir")
    public void telefonNumarasiGir(String key, String value)
    {
        sendToElement(key,value);
    }

    @Step("<TC Kimlik No> alanına <tc kimlik Numarası> gir")
    public void tecKimlikNumarasiGir(String key, String value) throws InterruptedException {
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

    @Step("<Adresi Kaydet> butonuna tıkla")
    public void adresiKaydet(String key)
    {

        WebElement element=findElementByKey(key);
        element.click();;
    }

    @Step("<Devam Et> butonuna tıkla")
    public void devamEt(String key)
    {
        WebElement element=findElementByKey(key);
        element.click();;
    }
    @Step("Ödeme tipi <kredi kartı> seçilir")
    public void odemeTipi(String key)
    {
        WebElement element=findElementByKey(key);
        element.click();;
    }

   @Step("<Kart Numarası>nı <kartnumarası> gir")
    public void kartnumarasi(String key, String value)
   {
          sendToElement(key,value);
   }

   @Step("<Kart Uzerindeki İsim> alanına <isim> gir")
    public void kartuzerindekisism(String key, String value)
   {
       sendToElement(key,value);
   }

   @Step("<Son Ay Kullanma Tarihi> butonuna tıkla")
    public void sonkullanmatarihiay(String key)
   {
     WebElement element=findElementByKey(key);
     element.click();
   }

    @Step("<Son Kullanma Tarihi Ay> sec")
    public void sonkullanmatarihisecay(String key)
    {
        List<WebElement> elements = findElementsByKey(key);
        dropDownListtenSec(elements);
    }

    @Step("<Son Yıl Kullanma Tarihi> butonuna tıkla")
    public void sonkullanmatarihiyil(String key)
    {
      WebElement element=findElementByKey(key);
    }

    @Step("<Son Kullanma Tarihi Yil> sec")
    public void sonkullanmatarihisecyil(String key)
    {
        List<WebElement> elements = findElementsByKey(key);
        dropDownListtenSec(elements);
    }
    @Step("<CVC> alanına <cvc kodu> gir")
    public void cvckodugir(String key, String value)
    {
        sendToElement(key,value);

    }
    @Step("<Anasayfaya> git")
    public void anasayfayadon(String key)
    {
         WebElement element=findElementByKey(key);
         element.click();
    }
    @Step("<Sepete> tıkla")
    public void sepetegit(String key)
    {
        WebElement element=findElementByKey(key);
        element.click();

    }

    @Step("<Sepetteki Urunleri> sil")
    public void sepetiTemizle(String key)
    {
       sepetiTemizle(key);
    }

    @Step("<Hesabım> a gidip <hesabım> a tıkla")
    public void hesabimaGit(String key, String key2)
    {
      WebElement element=findElementByKey(key);
      elementHover(element);
      WebElement element1=findElementByKey(key);
      element1.click();
    }

    @Step("<Adreslerim> alanına git")
    public void adreslerimeGit(String key)
    {
       WebElement element=findElementByKey(key);
       element.click();
    }

    @Step("<Adresimi sil> butonuna tıkla")
    public void adresimiSil(String key)
    {
       WebElement element=findElementByKey(key);
       element.click();
    }

    @Step("<Adresimi sil onayla> butonuna tıkla")
    public void adresimiSilonayla(String key)
    {
        WebElement element=findElementByKey(key);
        element.click();
    }

    @Step("<key> saniye bekle")
    public void waitBysecond(int key) {
        waitBySeconds(key);
    }


}
