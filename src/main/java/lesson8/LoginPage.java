package lesson8;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage {
    private SelenideElement loginButton = $(By.xpath("//div[@class=\"user-profile__login\"]"));
    private SelenideElement loginbutton2 = $(By.xpath("//span[.='Войти']"));
    private SelenideElement enterWithPassword = $(By.xpath("//div[.='Войти с паролем']"));


    //@Step("Клик на кнопку авторизоваться")
    public LoginPage clickLoginButton() {
        loginButton.click();
        loginbutton2.click();
        enterWithPassword.click();
        return page(LoginPage.class);
    }

    private SelenideElement login = $(By.xpath("//input[@autocomplete=\"username\"]"));
    private SelenideElement password = $(By.xpath("//input[@autocomplete=\"current-password\"]"));
    private SelenideElement clickLoginAuth = $(By.xpath("//div[@class=\"base-main-button\"]//div[.='Войти']"));


    public LoginPage login(String loginn) {
        login.sendKeys(loginn);
        return page(LoginPage.class);
    }

    public LoginPage password(String pass) {
        password.sendKeys(pass);
        return page(LoginPage.class);
    }

    public LoginPage clickAuthFinal() {
        clickLoginAuth.click();
        return page(LoginPage.class);
    }


    private SelenideElement chekSpell = $(By.xpath("//div[@class=\"main-footer__nav\"]//a[.='Как оформить заказ']"));
    private SelenideElement subscribe = $(By.xpath("//input[@class=\"subscription-widget__input\"]"));

    public LoginPage chekBox() throws InterruptedException {
                chekSpell.click();
        return page(LoginPage.class);
    }

    public LoginPage subscribe() throws InterruptedException {
        subscribe.shouldBe(Condition.visible).sendKeys("херня");
        Thread.sleep(6000);
        return this;
    }

    private SelenideElement buyButton = $(By.xpath("//div[contains(@data-product,'00155d8ed20b')]/a[contains(@href, 'g500h')]"));
    private SelenideElement forAuto = $(By.xpath("//div[.='Для автомобиля']"));
    private SelenideElement actual = $(By.xpath("//div[.='Актуальные предложения']"));
    private SelenideElement addFav =$(By.xpath("//button[@class=\"button-ui button-ui_white button-ui_icon wishlist-btn\"]"));

    public LoginPage bButton() throws InterruptedException {
        actual.scrollIntoView(true);
        forAuto.scrollIntoView(true);
        buyButton.click();
        addFav.click();
        return this;
    }

private SelenideElement checkFav=$(By.xpath("//button[@class=\"button-ui button-ui_white button-ui_icon wishlist-btn button-ui_done\"]"));
    public LoginPage chekFavorites() {
        checkFav.shouldBe(Condition.visible);
        return page(LoginPage.class);
    }
}