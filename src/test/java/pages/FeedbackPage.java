package pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class FeedbackPage {

    public FeedbackPage scrollFeedback(String value) {
        $(byText(value)).scrollTo().click();
        return this;
    }

    public FeedbackPage checktFeedback(String value) {
        $(withText(value)).shouldBe(visible);
        return this;
    }
}
