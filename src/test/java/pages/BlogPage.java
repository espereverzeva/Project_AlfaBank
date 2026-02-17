package pages;


import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class BlogPage {

    @Step("Проскроллить страницу, в конце странице найти информационную вкладку \"Блог\", кликнуть по ней")
    public BlogPage scrollBlogTab(String value) {
        $(byText(value)).scrollTo().click();
        return this;
    }
    @Step("Убедиться в успешном переходе на страницу с блогом, найдя запись \"Полезные статьи от Альфа-Банка\"")
    public BlogPage visibleBlogTab(String value) {
        $(withText(value)).shouldBe(visible);
        return this;
    }
}
