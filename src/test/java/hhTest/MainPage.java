package hhTest;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    private final SelenideElement help = $x("//button[contains(.,'Помощь')]");
    private final SelenideElement logo = $x("//span[@class=\"supernova-logo supernova-logo_inversed supernova-logo_hh-ru\"]");
    private final SelenideElement seekWorker = $x("//span[contains(.,'Я ищу сотрудника')]");
    private final SelenideElement seek = $x("//span[contains(.,'Найти')]/span");

    public static String button = "кнопка помощь";
    public static String logotype = "логотип hh";
    public static String notice = "надпись о поиске сотрудника";
    public static String register = "надпись о регистрации";

    public MainPage(String url) {
        Selenide.open(url);
    }


    /**
     * заполнене hashMap актуальными значениями для сравнения с ожидаемыми
     * @return
     */
    public Map<String, Object> getatributes() {
        Map<String, Object> atributes = new HashMap<>();
        atributes.put(button, CheckButtonHelp());
        atributes.put(logotype, CheckVisibleLogo());
        atributes.put(notice, CheckNoticeSeekWorker());
        atributes.put(register, CheckWindowRegister.CheckRegister());
        return atributes;
    }

    /**
     * проверка слова "Помощь" на главной странице
     *
     * @return
     */
    public boolean CheckButtonHelp() {
        return help.getText().contains("Помощь");
    }


    /**
     * проверка видимости логотипа на главной странице
     */
    public boolean CheckVisibleLogo() {
        return logo.isDisplayed();
    }

    /**
     * проверка надписи "Поиск сотрудника"
     */
    public boolean CheckNoticeSeekWorker() {
        return seekWorker.getText().contains("Я ищу сотрудника");
    }


    /**
     * клик по кнопке "Найти" на главной странице
     */
    public void clickButton() {
        seek.click();
    }
}
