package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.files.DownloadActions.click;

public class BankTests extends TestBase {

    @Test
 void mortgageForSecondaryHousing() {
     open ("/");
        //actions().moveToElement($(".k5qQXQ")).perform();
        //$(byText("Частным лицам")).shouldBe(visible).hover();
        //aXYDeT gXYDeT cXYDeT

        $(byAttribute("data-test-id", "test-retail")).$(byText("Частным лицам")).shouldBe(visible).hover();
        $(byAttribute("data-test-id", "link-mortgage")).shouldBe(visible).click();
        $(byText("Готовая недвижимость")).click();
        // $(".'aSfUAb vSfUAb'").shouldHave(text("Ипотека\n" + "на вторичное жильё"));

    }

    @Test
    void tariffs() {
        open ("/");
        $(byAttribute("data-test-id", "test-sme")).$(byText("Малому бизнесу и ИП")).shouldBe(visible).click();
        $(".hgfDvQ").scrollTo().click();
        $(".zyJgKm").scrollTo().click();

    }
}

