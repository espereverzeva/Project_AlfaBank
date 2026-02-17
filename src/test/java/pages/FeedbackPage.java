package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class FeedbackPage {

    @Step("Проскроллить страницу доинформационной вкладки \"Отзывы\" и кликнуть по ней")
    public FeedbackPage scrollFeedback(String value) {
        $(byText(value)).scrollTo().click();
        return this;
    }

    @Step("Убедиться в успешном переходе, найдя на странице запись \"Отзывы об Альфа-Банке\"")
    public FeedbackPage checktFeedback(String value) {
        $(byText(value)).shouldBe(visible);
        return this;
    }
}
