package LcWaikiki;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AnaSayfa extends BaseSayfa {

    WebDriverWait wait;

    By isHomePageDisplayedElementWithOutLogin = By.xpath("//a[@class='dropdown-toggle']/span[contains(text(),'Giriş Yap')]");
    By isHomePageDisplayedElementWithLogin = By.xpath("//a[@class='dropdown-toggle']/span[contains(text(),'Hesabım')]");

    By AnaSayfaGirisButton = By.xpath("//a[@class='dropdown-toggle']/span[contains(text(),'Giriş Yap')]");
    By goGirissayfaLocator = By.xpath("//a[contains(@href,'https://www.lcwaikiki.com/tr-TR/TR/giris') and contains(@class,'block')]");
    By AramagirisBox = By.id("search_input");
    By AramaButton = By.xpath("//button[@class='searchButton']");




    public AnaSayfa(WebDriver driver) {
        super(driver);
    }

    public boolean isHomePageDisplayed() throws Exception {
        return findElement(this.isHomePageDisplayedElementWithOutLogin).isDisplayed();
    }

    public void goToLoginPage() throws Exception {
        Actions actions = new Actions(driver);
        actions.moveToElement(findElement(isHomePageDisplayedElementWithOutLogin)).build().perform();
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(goGirissayfaLocator)).click();
    }

    public boolean isLogin() {
        return findElement(isHomePageDisplayedElementWithLogin).isDisplayed();
    }

    public void UruntipiArama(String productName) {
        clickElement(AramagirisBox);
        setText(AramagirisBox,productName);
        clickElement(AramaButton);
    }



}

