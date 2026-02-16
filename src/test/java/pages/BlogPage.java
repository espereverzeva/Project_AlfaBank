package pages;


import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class BlogPage {

    public BlogPage scrollBlogTab(String value) {
        $(byText(value)).scrollTo().click();
        return this;
    }

    public BlogPage visibleBlogTab(String value) {
        $(withText(value)).shouldBe(visible);
        return this;
    }
}
