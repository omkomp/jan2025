package javaDns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    Actions actions;
    WebDriverWait wait;
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class=\"user-profile__login\"]")
    public WebElement loginButton;

    @FindBy(xpath = "//span[.='Войти']")
    public WebElement loginbutton2;

    @FindBy(xpath = "//div[.='Войти с паролем']")
    public WebElement enterWithPassword;

    public LoginPage clickLoginButton() throws InterruptedException {
        //    Thread.sleep(5000);
        loginButton.click();
        loginbutton2.click();
        enterWithPassword.click();
        return this;
    }

    @FindBy(xpath = "//input[@autocomplete=\"username\"]")
    public WebElement login;

    @FindBy(xpath = "//input[@autocomplete=\"current-password\"]")
    public WebElement password;

    @FindBy(xpath = "//div[@class=\"base-main-button\"]//div[.='Войти']")
    public WebElement clickLoginAuth;

    public LoginPage login(String loginn) {
        login.sendKeys(loginn);
        return this;
    }

    public LoginPage password(String pass) {
        password.sendKeys(pass);
        return this;
    }

    public LoginPage clickAuthFinal() {
        clickLoginAuth.click();
        return this;
    }

    @FindBy(xpath = "//div[@class=\"main-footer__nav\"]//a[.='Как оформить заказ']")
    public WebElement chekSpell;

    @FindBy(xpath = "//div[contains(@data-product,'00155d8ed20b')]/a[contains(@href, 'g500h')]")
    public WebElement buyButton;

    public LoginPage bButton() throws InterruptedException {
       //  Thread.sleep(9000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@data-product,'00155d8ed20b')]/a[contains(@href, 'g500h')]")));
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@data-product,'00155d8ed20b')]/a[contains(@href, 'g500h')]")));
        buyButton.click();

        return this;
    }


}
