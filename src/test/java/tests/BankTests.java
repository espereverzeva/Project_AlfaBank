package tests;

import org.junit.jupiter.api.Test;
import pages.MortgagePage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class BankTests extends TestBase {

    MortgagePage mortragePage = new MortgagePage();

    @Test
    void mortgageForSecondaryHousing() {
        mortragePage.openPage()
        //open("/");
        //$(byAttribute("data-test-id", "test-retail")).$(byText("Частным лицам")).shouldBe(visible).hover();
                .hoverOverTheIndividualsTab("Частным лицам")
        //$(byAttribute("data-test-id", "link-mortgage")).shouldBe(visible).click();
                .mortgageTab()
        //$(byText("Готовая недвижимость")).click();
                .readyProperty("Готовая недвижимость")
        //$(withText("Ипотека на вторичное жильё")).shouldBe(visible);
                .checkMortgageRecord("Ипотека на вторичное жильё");
    }

    @Test
    void businessProposal() {
        open("/");
        $(byAttribute("data-test-id", "test-sme")).$(byText("Малому бизнесу и ИП")).shouldBe(visible).click();
        $(byText("условия для среднего и крупного бизнеса")).scrollTo().click();
        $(byText("Все предложения для среднего и крупного бизнеса")).scrollTo().click();
        $(withText("Внешнеэкономическая деятельность")).shouldBe(visible);
    }

    @Test
    void infoAverageLargeBusiness() {
        open("/");
        $(byAttribute("data-test-id", "test-corporate")).$(byText("Среднему и крупному бизнесу")).shouldBe(visible).click();
        $(byText("Подберём решения для вашего бизнеса")).scrollTo().click();
        $(byAttribute("data-test-id", "accordion-header-1")).scrollTo().click();
        $(withText("Как открыть расчётный счёт?")).shouldBe(visible);
    }

    @Test
    void searchPage() {
        open("/");
        $(".v5qQXQ").click();
        $(byAttribute("data-test-id", "search-input")).val("кредит").pressEnter();
        $(".fdJZg3").shouldHave(text("кредит"));
    }

    @Test
    void feedbackPage() {
        open("/");
        $(byText("Отзывы")).scrollTo().click();
        $(withText("Отзывы об Альфа-Банке")).shouldBe(visible);

    }
}

