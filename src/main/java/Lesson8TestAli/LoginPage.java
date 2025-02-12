package Lesson8TestAli;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private SelenideElement profilButton = $(By.xpath("//span[.='Мой Профиль']"));
    private SelenideElement enterButton = $(By.xpath("//button[.='Войти']"));
    private SelenideElement enterLogin = $(By.xpath("//input[@placeholder=\"адрес электронной почты или ID\"]"));
    private SelenideElement enterPassword = $(By.xpath("//input[@placeholder=\"Пароль\"]"));
    private SelenideElement authButton = $(By.xpath("//button[@class=\"ali-kit_Button__button__18ub7i ali-kit_Button__size-l__18ub7i contained ali-kit_Button__primary__18ub7i batman-v2_index__login-submit__1a53tq\"]"));
    private SelenideElement firstPush = $(By.xpath("//div[.='Отклонить']"));


    @Step("Авторизация на сайте ДНС")
    public LoginPage authorization(String l, String p) {
        firstPush.click();
        profilButton.click();
        enterButton.click();
        enterLogin.sendKeys(l);
        enterPassword.sendKeys(p);
        authButton.click();
//        String currentUrl= Selenide.switchTo().parentFrame().getCurrentUrl();
//        currentUrl.contains("dns");
        return this;
    }

    private SelenideElement goods = $(By.xpath("//a[@href=\"/item/1005002742639158.html?sku_id=12000021936225840\"]/div[.='Смартфон Xiaomi Redmi Note 10S 6+64G [ Ростест (ЕАС) | доставка от 2 дней | официальная гарантия ]']"));
    private SelenideElement quantity = $(By.xpath("//button[@ae_object_type=\"quantity_increase\"]"));
    private SelenideElement addToCart = $(By.xpath("//button[.='Добавить в корзину']"));
    private SelenideElement logoMain = $(By.xpath("//div[@class=\"Header_Logo__image__b5449\"]"));
    private SelenideElement pushFooter = $(By.cssSelector("#__aer_root__ > div > p > svg"));
    private SelenideElement goCart = $(By.xpath("//p[@class=\"ali-kit_Base__base__104pa1 ali-kit_Base__default__104pa1 ali-kit_Paragraph__paragraph__1w2ua6 ali-kit_Paragraph__size-xs__1w2ua6 Product_CartPopupHeader__linkAsButtonText__1lfjs\"]"));
    private SelenideElement searchLine = $(By.xpath("//input[@name=\"SearchText\"]"));

    @Step("добавление количества товара и добавление его в корзину")
    public LoginPage addCart() {
        logoMain.click();
        searchLine.setValue("redmi 9").pressEnter();
        Selenide.switchTo().parentFrame().manage().window().maximize();

        pushFooter.click();
        goods.click();
        Selenide.switchTo().window(1);
        quantity.click();
        addToCart.click();
        goCart.click();

        //  Selenide.sleep(9000);
        return this;
    }

    private SelenideElement checkCart = $(By.xpath("//h3[.='Корзина (1)']"));
    private SelenideElement checkGoods = $(By.xpath("//div[@class=\"ShoppingcartItemList_ProductCard__bakGroundLayer__1nl31\"]"));

    @Step("Проверка что товар добавился в корзину")
    public LoginPage checkOrder() {
        checkCart.shouldBe(Condition.visible);
        checkGoods.shouldBe(Condition.visible);
//        Selenide.executeJavaScript("let element = document.evaluate(\"//h3[.='Корзина (1)']\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null)\n" +
//                "element.singleNodeValue.remove()");
        return this;
    }

}
