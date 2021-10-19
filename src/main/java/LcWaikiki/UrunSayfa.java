package LcWaikiki;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Random;

public class UrunSayfa extends BaseSayfa {


    By listOfProductsLocator = By.xpath("//*[contains(@class,'row c-items')]//div[contains(@class,'c-item')]");
    By addToBasketLocator = By.id("pd_add_to_cart");
    By dahaFazlaButtonLocator = By.className("lazy-load-text");
    By urunBedenlerLocator = By.xpath("//div[@class='mobile-size-and-cart-container']//div[@id='option-size']/a[@data-toggle='popover']");
    By sepeteGit = By.xpath("//a[contains(@href,'https://www.lcwaikiki.com/tr-TR/TR/sepetim') and contains(@data-tracking-label,'Sepetim')]");

    public UrunSayfa(WebDriver driver) {
        super(driver);
    }


    public void clickDahaFazlaButon() {
        clickElement(dahaFazlaButtonLocator);
    }

    public void Randomurunsec() throws InterruptedException {
        Random rand = new Random();

        List<WebElement> productList = findAllElements(listOfProductsLocator);
        int randNum = rand.nextInt(productList.size()) + 1;
        if (randNum == 1) {
            randNum += 2;
        }
        WebElement randomElement = productList.get(randNum);
        randomElement.click();
        Thread.sleep(2000);
    }

    public void secUrunBedenBoyutu() {
        List<WebElement> urunBeden = findAllElements(urunBedenlerLocator);
        Random rand = new Random();
        int randNum = rand.nextInt(urunBeden.size()) + 1;
        if (randNum == 1) {
            randNum += 1;
        }
        WebElement randomElement = urunBeden.get(randNum);
        randomElement.click();
    }


    public void SepeteeklenenUrun() throws InterruptedException {
        clickElement(addToBasketLocator);
        Thread.sleep(3000);
    }

    public void SepetSayfası() {
        wait.until(ExpectedConditions.elementToBeClickable(sepeteGit)).click();
    }

}

