package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MortgagePage {
    private SelenideElement forPrivateIndividuals = $(byAttribute("data-test-id", "test-retail")),
            clickmortgageTab = $(byAttribute("data-test-id", "link-mortgage"));

    @Step("Открыть страницу сайта")
    public MortgagePage openPage() {
        open("/");
        return this;
    }

    @Step("Перейти на вкладку \"Частным лицам\"")
    public MortgagePage hoverOverTheIndividualsTab(String value) {
        forPrivateIndividuals.$(byText(value)).shouldBe(visible).hover();
        return this;
    }

    @Step("Кликнуть на раздел \"Ипотека\"")
    public MortgagePage mortgageTab() {
        clickmortgageTab.shouldBe(visible).click();
        return this;
    }

    @Step("Кликнуть по программе ипотеки \"Готовая недвижимость\"")
    public MortgagePage readyProperty(String value) {
        $(byText(value)).click();
        return this;
    }

    @Step("Проверить что страница с информацией о выбранной программе успешно открывается")
    public MortgagePage checkMortgageRecord(String value) {
        $(withText(value)).shouldBe(visible);
        return this;
    }
}
