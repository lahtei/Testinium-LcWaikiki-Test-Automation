package testinium.project;


import LcWaikiki.SepetSayfa;
import LcWaikiki.AnaSayfa;
import LcWaikiki.GirisSayfa;
import LcWaikiki.UrunSayfa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class TestLcWaikiki extends BaseTest {

    AnaSayfa anaSayfa;
    GirisSayfa girisPage;
    UrunSayfa urunPage;
    SepetSayfa sepetPage;

    String _email = "govent@hotmail.com";
    String _password = "14781478Ab.";
    String _productName = "Pantolon";

    @Test
    @Order(1)
    public void isHome() throws Exception {
        anaSayfa = new AnaSayfa(driver);
        girisPage = new GirisSayfa(driver);
        urunPage = new UrunSayfa(driver);
        sepetPage = new SepetSayfa(driver);
        urunPage = new UrunSayfa(driver);
        Assertions.assertTrue(anaSayfa.isHomePageDisplayed(),"Anasayfa Bulunamadı");

    }

    @Test
    @Order(2)
    public void Loginsayfasınagit() throws Exception {
        anaSayfa.goToLoginPage();
    }

    @Test
    @Order(3)
    public void Giris() throws InterruptedException {
        girisPage.setEmailveSifre(_email, _password);
        girisPage.GirisClick();
        Thread.sleep(2000);
        Assertions.assertTrue(anaSayfa.isLogin());
    }

    @Test
    @Order(4)
    public void Urunbul() {
        anaSayfa.UruntipiArama(_productName);
    }

    @Test
    @Order(5)
    public void scrollenalta() {
        urunPage.scrollenalta();
        urunPage.clickDahaFazlaButon();

    }

    @Test
    @Order(6)
    public void Randomurunsec() throws InterruptedException {
        urunPage.Randomurunsec();
        urunPage.secUrunBedenBoyutu();
    }
    @Test
    @Order(7)
    public void Sepetegit() throws InterruptedException {
        urunPage.SepeteeklenenUrun();
        urunPage.SepetSayfası();
    }


    @Test
    @Order(8)
    public void UrunMiktarıDegisim() {
        Assertions.assertEquals("2", sepetPage.urunmiktarıdegisim("2"),"Urun miktari degismedi");
    }

    @Test
    @Order(9)
    public void SepetiTemizle() {
        sepetPage.Sepetitemizle();
        Assertions.assertTrue(sepetPage.SepetBosKontrol(),"Sepet Temizlenemedi");

    }





}

