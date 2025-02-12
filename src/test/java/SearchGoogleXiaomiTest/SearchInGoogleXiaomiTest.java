package SearchGoogleXiaomiTest;

import org.junit.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;

public class SearchInGoogleXiaomiTest extends BaseTest {
    private static final String duck = "https://duckduckgo.com/";
    private static final String mi14tTpro = "mi14tT pro";

    @Test
    public void FirstSearch() {
        MainPage mainPage = new MainPage();
        mainPage.OpenWebSite(duck);

        mainPage.ClickOnSearchXiaomi(mi14tTpro);

//        FoundPages foundPages = new FoundPages();

        $x("//span[contains(.,'Xiaomi 14T Pro - Xiaomi Global')]").shouldHave(text("Xiaomi 14T Pro - Xiaomi Global"));

    }


}
