package tests;

import data.TestData;
import org.junit.jupiter.api.Test;
import pages.*;

public class BankTests extends TestBase {

    MortgagePage mortragePage = new MortgagePage();
    BusinessPage businessPage = new BusinessPage();
    BlogPage blogPage = new BlogPage();
    CreditPage creditPage = new CreditPage();
    FeedbackPage feedbackPage = new FeedbackPage();

    TestData testData = new TestData();

    @Test
    void mortgageForSecondaryHousing() {
        mortragePage.openPage()
                .hoverOverTheIndividualsTab("Частным лицам")
                .mortgageTab()
                .readyProperty("Готовая недвижимость")
                .checkMortgageRecord("Ипотека на вторичное жильё");
    }

    @Test
    void businessProposal() {
        mortragePage.openPage();
        businessPage.smallBusinessIndividualEntrepreneurs("Малому бизнесу и ИП")
                .conditionsLargeMediumBusiness("условия для среднего и крупного бизнеса")
                .allOffersLargeMediumBusiness("Все предложения для среднего и крупного бизнеса");
    }

    @Test
    void usefulArticles() {
        mortragePage.openPage();
        blogPage.scrollBlogTab("Блог")
                .visibleBlogTab("Полезные статьи от Альфа-Банка");
    }

    @Test
    void searchInfoCredit() {
        mortragePage.openPage();
        creditPage.clickSearch()
                .setSearch(testData.searchValue)
                .checktSearch(testData.searchValue);
    }

    @Test
    void feedbackBank() {
        mortragePage.openPage();
        feedbackPage.scrollFeedback("Отзывы")
                .checktFeedback("Отзывы об Альфа-Банке");
    }
}

