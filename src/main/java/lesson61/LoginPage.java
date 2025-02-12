package lesson61;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;
    Cookie cookie, cookieAuth, auth_public_uid, auth_refresh_token;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofMillis(5000));
//        actions = new Actions(driver);
//        cookie = new Cookie("auth_access_token", "eyJhbGciOiJFUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2NTE3NDMyO" +
//                "TQsInJuZCI6IjNjN2VhODcwZmQ5MzYyNWY3ZWM4MWE1MGYwOTkwYTczZGFhYTA3NDMwYTA5MWM4YTgzZTgyNmUxZjY1OWFmZTIiLC" +
//                "J1c2VySWQiOiI0NTZhMDJkOS0yMDU3LWY1MTItYzM2Mi1hZmViZDlkY2Y3NWQiLCJ1c2VyTmFtZSI6IiJ9.MEYCIQCTfR5zKdpucmf" +
//                "h6N0ih33hXDMWzeuImrUjvIUSoSmJUQIhALiyxZJmOfUk5lCD62FNH2tcHc3SXk8r_saYruneAFhU");
//        cookieAuth = new Cookie("auth_ssid", "7fd85eaa24f27e7a2fb7145ee4f8fdd1c27da307ae8e95d7e69b09ff1a6fbd4a");
//        auth_public_uid = new Cookie("auth_public_uid", "a903dc06d0bbc5851734405f58bfdff9");
//        auth_refresh_token = new Cookie("auth_refresh_token", "7b967b03b7f866ad90c08c02aa3b519cc6984623bc4f8b8a442336902fdd027d");

    }

//    @FindBy(xpath = "//button[.='Войти']")
//    private WebElement LoginButton;

    @FindBy(xpath = "//button[.='Войти']")
    public WebElement loginButton;

    @FindBy(xpath = "//div[.='Войти с паролем']")
    public WebElement enterWithPassword;

   //@Step("Клик на кнопку авторизоваться")
    public LoginPage clickLoginButton() {
        loginButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[.='Войти с паролем']")));
        enterWithPassword.click();
        return this;
    }

  // @Step("Авторизация по кукам")
//    public LoginPage loginCooki() {
//        driver.manage().addCookie(cookie);
//        driver.manage().addCookie(cookieAuth);
//        driver.manage().addCookie(auth_refresh_token);
//        driver.manage().addCookie(auth_public_uid);
//        driver.navigate().refresh();
//        return this;
//    }

    @FindBy(xpath = "//input[@autocomplete=\"username\"]")
    private WebElement login;

    @FindBy(xpath = "//input[@autocomplete=\"current-password\"]")
    private WebElement password;

    @FindBy(xpath = "//div[@class=\"base-main-button\"]//div[.='Войти']")
    private WebElement clickLoginAuth;

    public LoginPage login() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@autocomplete=\"current-password\"]")));
        login.sendKeys("luckyjr777@mail.ru");
        return this;
    }

    public LoginPage password() {
        password.sendKeys("110275vvv");
        return this;
    }

    public LoginPage clickAuthFinal() throws InterruptedException {
     //   clickLoginAuth.click();
        // Thread.sleep(3000);
        wait.until(ExpectedConditions.textToBe((By.xpath("//span[.='Корзина']")), "Корзина"));
//        ((JavascriptExecutor)driver).executeScript("window.open()");
//        List<String> tabs = new ArrayList<>(driver.getWindowHandle());
//        driver.switchTo().window(tabs.get(1));


        return this;
    }

    @FindBy(xpath = "//div[@data-code=\"8142276\"]//button[@class=\"button-ui button-ui_white button-ui_icon wishlist-btn\"]")
    private WebElement chekSpell;

    public LoginPage chekBox() throws InterruptedException {
        Thread.sleep(6000);

        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-code=\"8142276\"]//label[@class=\"ui-checkbox\"]/span[contains(., 'Сравнить')]")));
        chekSpell.click();
        return this;
    }
}
