package tests;

import data.TestData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.*;

@DisplayName("Тесты для сайта Альфа-Банка")
public class BankTests extends TestBase {

    MortgagePage mortragePage = new MortgagePage();
    BusinessPage businessPage = new BusinessPage();
    BlogPage blogPage = new BlogPage();
    SearchPage searchPage = new SearchPage();
    FeedbackPage feedbackPage = new FeedbackPage();

    TestData testData = new TestData();

    @DisplayName("Проверка на наличие ипотечной программы на вторичное жилье")
    @Test
    void mortgageForSecondaryHousing() {
        mortragePage.openPage()
                .hoverOverTheIndividualsTab("Частным лицам")
                .mortgageTab()
                .readyProperty("Готовая недвижимость")
                .checkMortgageRecord("Ипотека на вторичное жильё");
    }

    @DisplayName("Проверка просмотра страницы с предложениями для бизнеса")
    @Test
    void businessProposal() {
        mortragePage.openPage();
        businessPage.smallBusinessIndividualEntrepreneurs("Малому бизнесу и ИП")
                .conditionsLargeMediumBusiness("условия для среднего и крупного бизнеса")
                .allOffersLargeMediumBusiness("Все предложения для среднего и крупного бизнеса");
    }

    @DisplayName("Проверка открытия и просмтра страницы блога")
    @Test
    void blogInfo() {
        mortragePage.openPage();
        blogPage.scrollBlogTab("Блог")
                .visibleBlogTab("Полезные статьи от Альфа-Банка");
    }

    @DisplayName("Проверка поиска")
    @Test
    void searchInfo() {
        mortragePage.openPage();
        searchPage.clickSearch()
                .setSearch(testData.searchValue)
                .checktSearch(testData.searchValue);
    }

    @DisplayName("Проверка страницы с отзывами")
    @Test
    void feedbackBank() {
        mortragePage.openPage();
        feedbackPage.scrollFeedback("Отзывы")
                .checktFeedback("Отзывы об Альфа-Банке");
    }
}

