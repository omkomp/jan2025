package SearchGoogleXiaomiTest;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

/**
 * стартовая страница dns
 */
public class MainPage {
    private final SelenideElement seekingXiaomi = $x("//input[@placeholder=\"Поиск без отслеживания\"]");
    private final SelenideElement town = $x("//span[contains(.,'Все верно')]");

    public void OpenWebSite(String url) {
        Selenide.open(url);
    }

    /**
     * поиск модели телефона mi14T pro
     *
     * @param mi
     */
    public void ClickOnSearchXiaomi(String mi) {
        seekingXiaomi.setValue(mi).pressEnter();
    }


    /**
     * выбор города при открытии сайта
     */
    public void ClickOnTown() {
        Selenide.$(town).shouldBe(visible).click();
        // town.click();
    }

}
