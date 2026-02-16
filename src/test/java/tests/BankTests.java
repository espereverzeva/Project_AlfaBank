package tests;

import org.junit.jupiter.api.Test;
import pages.*;

public class BankTests extends TestBase {

    MortgagePage mortragePage = new MortgagePage();
    BusinessPage businessPage = new BusinessPage();
    BlogPage blogPage = new BlogPage();
    CreditPage creditPage = new CreditPage();
    FeedbackPage feedbackPage = new FeedbackPage();

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
        //open("/");
        mortragePage.openPage();
        //$(byAttribute("data-test-id", "test-sme")).$(byText("Малому бизнесу и ИП")).shouldBe(visible).click();
        businessPage.smallBusinessIndividualEntrepreneurs("Малому бизнесу и ИП")
                //$(byText("условия для среднего и крупного бизнеса")).scrollTo().click();
                .conditionsLargeMediumBusiness("условия для среднего и крупного бизнеса")
                //$(byText("Все предложения для среднего и крупного бизнеса")).scrollTo().click();
                .allOffersLargeMediumBusiness("Все предложения для среднего и крупного бизнеса");
    }

    @Test
    void usefulArticles() {
        //open("/");
        mortragePage.openPage();
        //$(byText("Блог")).scrollTo().click();
        blogPage.scrollBlogTab("Блог")
                //$(withText("Полезные статьи от Альфа-Банка")).shouldBe(visible);
                .visibleBlogTab("Полезные статьи от Альфа-Банка");
    }

    @Test
    void searchInfoCredit() {
        //open("/");
        mortragePage.openPage();
        //$(".v5qQXQ").click();
        creditPage.clickSearch()
                //$(byAttribute("data-test-id", "search-input")).val("кредит").pressEnter();
                .setSearch("кредит")
                //$(".fdJZg3").shouldHave(text("кредит"));
                .checktSearch("кредит");
    }

    @Test
    void feedbackBank() {
        //open("/");
        mortragePage.openPage();
        //$(byText("Отзывы")).scrollTo().click();
        feedbackPage.scrollFeedback("Отзывы")
                //$(withText("Отзывы об Альфа-Банке")).shouldBe(visible);
                .checktFeedback("Отзывы об Альфа-Банке");
    }
}

