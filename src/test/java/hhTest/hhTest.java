package hhTest;

import SearchGoogleXiaomiTest.BaseTest;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static hhTest.CheckWindowRegister.CheckRegister;
import static hhTest.MainPage.*;

public class hhTest extends BaseTest {
    private final static String URL = "https://hh.ru/";

    @Test
    public void CheckAtributesHasMap() {
        MainPage mainPage = new MainPage(URL);

        /**
         * проверки сразу через ассерты
         */
        Assert.assertTrue(mainPage.CheckButtonHelp());
        Assert.assertTrue(mainPage.CheckVisibleLogo());
        Assert.assertTrue(mainPage.CheckNoticeSeekWorker());
        mainPage.clickButton();
        Assert.assertTrue(CheckRegister());


        /**
         * вот тут сравнение ожидаемого и актуального результатов через хэш карту
         */
        Map<String, Object> expectedAtributes = new HashMap<>();
        expectedAtributes.put(button, true);
        expectedAtributes.put(logotype, true);
        expectedAtributes.put(notice, true);
        expectedAtributes.put(register, true);

        Map<String, Object> actualAtributes=mainPage.getatributes();
        Assert.assertEquals(actualAtributes,expectedAtributes);
    }

}

