package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class BusinessPage {
    private SelenideElement visibleSmallBusiness = $(byAttribute("data-test-id", "test-sme"));

    public BusinessPage smallBusinessIndividualEntrepreneurs(String value) {
        visibleSmallBusiness.$(byText(value)).shouldBe(visible).click();
        return this;
    }

    public BusinessPage conditionsLargeMediumBusiness(String value) {
        $(byText(value)).scrollTo().click();
        return this;
    }

    public BusinessPage allOffersLargeMediumBusiness(String value) {
        $(byText(value)).scrollTo().shouldBe(visible);
        return this;
    }
}
