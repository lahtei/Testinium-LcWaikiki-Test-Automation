package LcWaikiki;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SepetSayfa extends BaseSayfa {

    By secilenurunadediLocator = By.xpath("//*[contains(@id,'Cart_AddQuantity_')]");
    By sepettemizleButtonLocator = By.xpath("//a[@class='cart-square-link' and @title='Sil']");
    By sepetBosYazisiLocator = By.xpath("//p[@class='cart-empty-title' and contains(text(),'Sepetinizde ürün bulunmamaktadır.')]");
    By urunSayisiLocator = By.xpath("//*[contains(@class,'item-quantity-input ignored')]");
    By modalSilmeButtonLocator = By.xpath("//div[@class='row']/div[@class='col-xs-12']/a[contains(@id,'Cart_ProductDelete_')]");

    public SepetSayfa(WebDriver driver) {
        super(driver);
    }

    public String urunmiktarıdegisim(String pCount) {
        clickElement(secilenurunadediLocator);
        return veriyiAl(urunSayisiLocator);
    }

    public void Sepetitemizle() {
        clickElement(sepettemizleButtonLocator);
        clickElement(modalSilmeButtonLocator);


    }

    public boolean SepetBosKontrol() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(sepetBosYazisiLocator)).isDisplayed();
    }

}
