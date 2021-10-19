package LcWaikiki;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BaseSayfa {

    WebDriver driver;
    WebDriverWait wait;


    public BaseSayfa(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,10);
    }

    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    public List<WebElement> findAllElements(By locator) {
        return driver.findElements(locator);
    }

    public void clickElement(By locator) {
        findElement(locator).click();
    }

    public String veriyiAl(By locator) {
        return findElement(locator).getAttribute("value");
    }

    public void setText(By locator, String text) {
        findElement(locator).sendKeys(text);
    }

    public Boolean isDisplayed(By locator) {
        return findElement(locator).isDisplayed();
    }

    public void scrollenalta() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
}

