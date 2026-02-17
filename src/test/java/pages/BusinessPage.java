package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class BusinessPage {
    private SelenideElement visibleSmallBusiness = $(byAttribute("data-test-id", "test-sme"));

    @Step("Перейти на вкладку \"Малому бизнесу и ИП\"")
    public BusinessPage smallBusinessIndividualEntrepreneurs(String value) {
        visibleSmallBusiness.$(byText(value)).shouldBe(visible).click();
        return this;
    }

    @Step("Проскроллить страницу до информации с условиями по тарифам для бизнеса \"условия для среднего и крупного бизнеса\", осуществить переход на страницу с условиями, кликнув по данной ссылке")
    public BusinessPage conditionsLargeMediumBusiness(String value) {
        $(byText(value)).scrollTo().click();
        return this;
    }

    @Step("Убедиться в успешном переходе, найдя на странице информационную вкладку \"Все предложения для среднего и крупного бизнеса\"")
    public BusinessPage allOffersLargeMediumBusiness(String value) {
        $(byText(value)).scrollTo().shouldBe(visible);
        return this;
    }
}
