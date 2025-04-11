package hhTest;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class CheckWindowRegister {
    private static final SelenideElement CheckWindowRegister = $x("//h2[contains(.,'работодатели смогут найти вас')]");


    public static boolean CheckRegister() {
        return CheckWindowRegister.getText().contains("Зарегистрируйтесь — работодатели смогут найти вас и пригласить на работу");
    }


}
