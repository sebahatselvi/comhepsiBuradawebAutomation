package steps;

import com.hepsiburada.testautomation.util.BaseMethods;
import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

public class hepsiBuradaSteps extends BaseMethods {

    @Step("<key> sitesine git")
    public void sayfaAc(String key) throws InterruptedException {
        driver.manage().window().maximize();
        driver.get(key);
     //   Thread.sleep(10000);
    }

    @Step("<Uye Giris> Uye Giris Yap Tıkla ")
    public void uyegirisyapbutonu(String key) throws InterruptedException {
       clickToElement(key);
      //  Thread.sleep(10000);
    }

    @Step("<Giris Yap Butonuna> Giris Yap Tıkla ")
    public void girisyapbutonu(String key) throws InterruptedException {
       clickToElement(key);
      //  Thread.sleep(10000);
    }

    @Step("<Kullanıcı Alanına> alanına E-posta <kullanıcı Adı> gir")
    public void kullaniciAdi(String key, String kullaniciAdi) throws InterruptedException {
        sendToElement(key, kullaniciAdi);
      //  Thread.sleep(10000);
    }

    @Step("<Şifre Alanına> alanına Sifre <sifre> gir")
    public void sifre(String key, String sifre) throws InterruptedException {
        sendToElement(key, sifre);
       // Thread.sleep(10000);
    }

    @Step("<Login Kontrolu> <kullanıcı adı> ile kontrol yap")
    public void loginKontrolEt(String key, String value) throws InterruptedException {
        loginKontrol(key, value);
       // Thread.sleep(10000);
    }

    @Step(" <Sepete> git urunleri temizle")
    public void sepetTutar(String key) throws InterruptedException {
        sepetiTemizle(key);
       // Thread.sleep(10000);
    }

    @Step("<Ratgele bir kategorinin> kategori menusu üzerine git")
    public void menuKategoriler(String key) throws InterruptedException {
        rastgeleKategoriSec(key);
      //  Thread.sleep(10000);
    }

    @Step("<Rastgele bir alt kategori> alt kategori sec")
    public void kategoriAltMenu(String key) throws InterruptedException {
        List<WebElement> elements = findElementsByKey(key);
        rastgeleSecimUrunvsMarkavsPagination(elements);
     //  Thread.sleep(10000);
    }

    @Step("<Ratgele bir marka> marka sec")
    public void markasec(String key) throws InterruptedException {
        List<WebElement> elements = findElementsByKey(key);
        rastgeleSecimUrunvsMarkavsPagination(elements);
      //  Thread.sleep(10000);

    }

    @Step("<Minimum Fiyat Aralıgını> Minimum Fiyat <value> gir")
    public void minFiyat(String key, String value) throws InterruptedException {
        sendToElement(key, value);
       // Thread.sleep(10000);

    }


    @Step("<Maksimum Fiyat Aralıgını> Maksimum Fiyat <value> gir ")
    public void maxFiyat(String key, String value) throws InterruptedException {
        sendToElement(key, value);
      //  Thread.sleep(10000);
    }

    @Step("<Fiyat Buton> Fiyat Butonuna tıkla")
    public void fiyatButonTikla(String key) throws InterruptedException {
       clickToElement(key);
       // Thread.sleep(10000);
    }

    @Step("<Ratgele bir urun>sec <Urun Adı> ve <Urun Fiyatı> nı <csv> dosyasına kaydet ")
    public void urunAdiniFiyatiniKaydet(String element, String urunAdi, String urunFiyati, String csv) throws IOException, InterruptedException {
        rastgeleurunBulma(element);
        Thread.sleep(3000);
        WebElement urunadi = findElementByKey(urunAdi);
        WebElement urunfiyat = findElementByKey(urunFiyati);
        cvsUrunKaydet(urunadi.getText(), urunfiyat.getText(), csv);
      //  Thread.sleep(10000);

    }

    @Step("Detay sayfasındaki <Urun Fiyatı> nı <csv> dosyasından kontrol et")
    public void urunFiyatKontrol(String key, String csv) throws InterruptedException {
        urunFiyatDogrulamasi(key, csv);
       // Thread.sleep(10000);
    }

    @Step("<Sepete ekle> butonuna tıkla")
    public void sepeteEkle(String key) throws InterruptedException {
       clickToElement(key);
      //  Thread.sleep(10000);
    }

    @Step("<Eklenen Urun Sayısı> ile <Sepet Uzerindeki Sayı> kontrol et ve <Sepete> git")
    public void urunsayısıKontrol(String eklenenUrun, String sepetUzerindekiSayi, String sepet) throws InterruptedException {
        elementTextKarsilastir2(eklenenUrun, sepetUzerindekiSayi);
        Thread.sleep(3000);
        clickToElement(sepet);
        //  Thread.sleep(10000);
    }

    @Step("<Adet Sayısı> adetini <adet> arttır")
    public void adetSayisiniArtır(String key, int adet) throws InterruptedException {

        for(int i=0;i<adet;i++)
        {
            clickElementandwait(key);
        }
        //  Thread.sleep(10000);

    }

    @Step("<Urun tutar> ile <Odenecek tutarı> karşılatır")
    public void tutarKontrol(String urunTutar, String odenecekTutar) throws InterruptedException {
        WebElement element = findElementByKey(urunTutar);
        WebElement element1 = findElementByKey(odenecekTutar);
        elementKarsilastir(element1, element);
        //  Thread.sleep(10000);
    }

    @Step("<Ürün toplamı değeri> Ürün toplam tutar ve <kargo tutarı> kargo ücreti <csv> dosyasına yazdırılır ve <alışverişi tamamla butonuna> tıklanır")
    public void urunToplamDegeriveKargoTutarinicsvdosyasınaKaydet(String urunToplamdeger, String kargotutari, String csv, String alisverisitamamla) throws IOException, InterruptedException {
        WebElement urunElementi = findElementByKey(urunToplamdeger);
        List<WebElement>kargo=findElementsByKey(kargotutari);
        if(kargo.size()==2)
        {
            cvsUrunKaydet(kargo.get(1).getText(), urunElementi.getText(), csv);
        }
        else if(kargo.size()==1)
        {
            cvsUrunKaydet(kargo.get(0).getText(),urunElementi.getText(),csv);
        }
        Thread.sleep(10000);
        WebElement element = findElementByKey(alisverisitamamla);
        element.click();
        //  Thread.sleep(10000);
    }

    @Step("<Yeni Adres Ekle> yeni adres ekle butonuna tıkla")
    public void yeniAdresEkle(String key) throws InterruptedException {
        clickToElement(key);
        //  Thread.sleep(10000);
    }

    @Step("<Ad Giriniz> alanına isim <isim> gir")
    public void isimgir(String key, String value) throws InterruptedException {
        sendToElement(key, value);
        //  Thread.sleep(10000);
    }

    @Step("<Soyisim> alanına soyisim <soyisim> gir")
    public void soyisimGir(String key, String value) throws InterruptedException {
        sendToElement(key, value);
        //  Thread.sleep(10000);
    }

    @Step("<Sehir dropdonwn> menusunden sehir <sehir> sec")
    public void sehirSec(String sehirDrop, String sehir) throws InterruptedException {
        clickElementandwait(sehirDrop);
        rastgeleSecimYap(sehir);
        //  Thread.sleep(10000);
    }

    @Step("<İlce dropdonwn> menusunden ilçe <ilce> sec")
    public void ilceSec(String ilcedrop, String ilce) throws InterruptedException {
        clickElementandwait(ilcedrop);
        rastgeleSecimYap(ilce);
        //  Thread.sleep(10000);

    }

    @Step("<Mahalle dropdonwn> menusunden mahalle <mahalle> sec")
    public void mahalleSec(String mahalledrop, String mahalle) throws InterruptedException {
       clickElementandwait(mahalledrop);
        rastgeleSecimYap(mahalle);
        //  Thread.sleep(10000);
    }

    @Step("<Adres> alanına sokak <adres> yaz")
    public void adresYaz(String adresalani, String adres) throws InterruptedException {
        sendToElement(adresalani, adres);
        //  Thread.sleep(10000);
    }

    @Step("<Adres Adı> alanına adres adı <adres adı> nı yaz")
    public void adresAdi(String key, String value) throws InterruptedException {
        sendToElement(key, value);
        //  Thread.sleep(10000);
    }

    @Step("<Telefon Numarası> alanına telefon <telefon no> gir")
    public void telefonNumarasiGir(String key, String value) throws InterruptedException {
        sendToElement(key, value);
        //  Thread.sleep(10000);
    }

    @Step("<TC Kimlik No> alanına TC Kimlik numarası <tc kimlik Numarası> gir")
    public void tecKimlikNumarasiGir(String key, String value) throws InterruptedException {
        WebElement element1;
        while (true) {

            try {

                element1 = findElementByKey(key);
            } catch (Exception ex) {
                element1 = null;
            }

            if (element1 != null) {
                element1.sendKeys(value);
                driver.navigate().refresh();
                Thread.sleep((5000));

            } else {
                break;
            }
        }
        //  Thread.sleep(10000);
    }

    @Step("<Adresi Kaydet> adresi kaydet butonuna tıkla")
    public void adresiKaydet(String key) throws InterruptedException {

        clickToElement(key);
        //  Thread.sleep(10000);
    }

    @Step("<Devam Et> devam et butonuna tıkla")
    public void devamEt(String key) throws InterruptedException {
       clickToElement(key);
        //  Thread.sleep(10000);

    }

    @Step("Ödeme tipi <kredi kartı> seçilir")
    public void odemeTipi(String key) throws InterruptedException {
       clickToElement(key);
        //  Thread.sleep(10000);
    }

    @Step("<Kart Numarası> kart numarasını <kartnumarası> gir")
    public void kartnumarasi(String key, String value) throws InterruptedException {
        sendToElement(key, value);
        //  Thread.sleep(10000);
    }

    @Step("<Kart Uzerindeki İsim> kart sahibinin adı <isim> gir")
    public void kartuzerindekisism(String key, String value) throws InterruptedException {
        sendToElement(key, value);
        //  Thread.sleep(10000);
    }

    @Step("<Son Ay Kullanma Tarihi> son kullanma tarihi(ay) butonuna tıkla")
    public void sonkullanmatarihiay(String key) throws InterruptedException {
        clickToElement(key);
        //  Thread.sleep(10000);
    }

    @Step("<Son Kullanma Tarihi Ay> ay sec")
    public void sonkullanmatarihisecay(String key) throws InterruptedException {
        List<WebElement> elements = findElementsByKey(key);
        dropDownListtenSec(elements);
        //  Thread.sleep(10000);
    }

    @Step("<Son Yıl Kullanma Tarihi> yıl butonuna tıkla")
    public void sonkullanmatarihiyil(String key) throws InterruptedException {

        clickToElement(key);
        //  Thread.sleep(10000);
    }

    @Step("<Son Kullanma Tarihi Yil> yıl sec")
    public void sonkullanmatarihisecyil(String key) throws InterruptedException {
        List<WebElement> elements = findElementsByKey(key);
        dropDownListtenSec(elements);
        //  Thread.sleep(10000);
    }

    @Step("<CVC> alanına CVC <cvc kodu> gir")
    public void cvckodugir(String key, String value) throws InterruptedException {
        sendToElement(key, value);
        //  Thread.sleep(10000);

    }

    @Step("<Anasayfaya> anasayfaya git")
    public void anasayfayadon(String key) throws InterruptedException {
        clickToElement(key);
        //  Thread.sleep(10000);
    }

    @Step("<Sepete> sepete tıkla")
    public void sepetegit(String key) throws InterruptedException {
        clickToElement(key);
        //  Thread.sleep(10000);

    }

    @Step("<Sepetteki Urunleri> sil")
    public void sepetiTemizlestep(String key) throws InterruptedException {
       sepetiTemizle(key);
    }

    @Step("<Hesabım> a gidip <hesabım> a tıkla")
    public void hesabimaGit(String key, String key2) throws InterruptedException {
        WebElement element=findElementByKey(key);
        elementHover(element);
        Thread.sleep(10000);
        clickToElement(key2);
        //  Thread.sleep(10000);
    }

    @Step("<Adreslerim> adreslerim alanına git")
    public void adreslerimeGit(String key) throws InterruptedException {
       clickToElement(key);
        //  Thread.sleep(10000);
    }

    @Step("<Adresimi sil> adresimi sil butonuna tıkla")
    public void adresimiSil(String key) throws InterruptedException {
        clickToElement(key);
        //  Thread.sleep(10000);
    }

    @Step("<Adresimi sil onayla> adresi silmeyi onayla butonuna tıkla")
    public void adresimiSilonayla(String key) throws InterruptedException {
        clickToElement(key);
        //  Thread.sleep(10000);
    }

    @Step("<key> saniye bekle")
    public void waitBysecond(int key) {
        waitBySeconds(key);
    }


    @Step("<Secilen Urun> secilen urune tıkla")
    public void secilenurun(String key) throws InterruptedException {
        clickToElement(key);
        //  Thread.sleep(10000);

    }

    @Step("<Sepetim1> sepetim tıkla")
    public void sepetimeTikla(String key) throws InterruptedException {
       clickToElement(key);
        //  Thread.sleep(10000);

    }

    @Step("<Giris Buton> giris butonuna tıkla")
    public void girisButonu(String key) throws InterruptedException {
       clickToElement(key);
        //  Thread.sleep(10000);

    }




    @Step("<alısverıs> tamamla")
    public  void deneme(String key) throws InterruptedException {
        clickToElement(key);
        //  Thread.sleep(10000);

    }


}
