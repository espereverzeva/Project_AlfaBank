package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;

public class SearchPage {
    private SelenideElement searchField = $(".v5qQXQ"),
            searchInput = $(byAttribute("data-test-id", "search-input")),
            resultSearch = $(".fdJZg3");

    @Step("Кликнуть по значку поиска")
    public SearchPage clickSearch() {
        searchField.click();
        return this;
    }
    @Step("В поисковое поле ввести \"{value}\"")
    public SearchPage setSearch(String value) {
        searchInput.val(value).pressEnter();
        return this;
    }

    @Step("Ппрверить, что поиск производится по запросу \"{value}\"")
    public SearchPage checktSearch(String value) {
        resultSearch.shouldHave(text(value));
        return this;
    }
}
