package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

        @BeforeAll
        static void setupSelenideConfig() {
            Configuration.browserSize = "1920x1080";
            Configuration.baseUrl = "https://alfabank.ru";
            Configuration.pageLoadStrategy = "eager";
            Configuration.timeout = 5000; // default 4000
        }
}
