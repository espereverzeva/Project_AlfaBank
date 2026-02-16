package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;

public class CreditPage {
    private SelenideElement searchField = $(".v5qQXQ"),
            searchInput = $(byAttribute("data-test-id", "search-input")),
            resultSearch = $(".fdJZg3");

    public CreditPage clickSearch() {
        searchField.click();
        return this;
    }

    public CreditPage setSearch(String value) {
        searchInput.val(value).pressEnter();
        return this;
    }

    public CreditPage checktSearch(String value) {
        resultSearch.shouldHave(text(value));
        return this;
    }
}
