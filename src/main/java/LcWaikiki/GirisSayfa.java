package LcWaikiki;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GirisSayfa extends BaseSayfa {

    private static final By emailTextBox = By.id("LoginEmail");
    private static final By sifreTextBox = By.id("Password");
    private static final By btnGirisButton = By.id("loginLink");

    public GirisSayfa(WebDriver driver) {
        super(driver);
    }

    public void setEmailveSifre(String email, String password) {
        setText(emailTextBox, email);
        setText(sifreTextBox, password);
    }
    public void GirisClick(){
        clickElement(btnGirisButton);
    }


}