package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MortgagePage {
    private SelenideElement forPrivateIndividuals = $(byAttribute("data-test-id", "test-retail")),
            clickmortgageTab = $(byAttribute("data-test-id", "link-mortgage"));


    public MortgagePage openPage() {
        open("/");
        return this;
    }

    public MortgagePage hoverOverTheIndividualsTab(String value) {
        forPrivateIndividuals.$(byText(value)).shouldBe(visible).hover();
        return this;
    }

    public MortgagePage mortgageTab() {
        clickmortgageTab.shouldBe(visible).click();
        return this;
    }

    public MortgagePage readyProperty(String value) {
        $(byText(value)).click();
        return this;
    }

    public MortgagePage checkMortgageRecord(String value) {
        $(withText(value)).shouldBe(visible);
        return this;
    }
}
