package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import data.TestData;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.*;

import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {
    MortgagePage mortragePage = new MortgagePage();
    BusinessPage businessPage = new BusinessPage();
    BlogPage blogPage = new BlogPage();
    SearchPage searchPage = new SearchPage();
    FeedbackPage feedbackPage = new FeedbackPage();

    TestData testData = new TestData();

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @BeforeAll
    static void setupSelenideConfig() {
        Configuration.baseUrl = System.getProperty("baseUrl", "https://alfabank.ru");
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserVersion = System.getProperty("browserVersion");
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
        //String remoteUrl = System.getProperty("remoteUrl");
        Configuration.remote = System.getProperty("remoteUrl");

        //Configuration.baseUrl = baseUrl;
        //Configuration.browser = browser;
        //Configuration.browserVersion = browserVersion;
       // Configuration.browserSize = browserSize;

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
        //Configuration.remote = remoteUrl;
        Configuration.timeout = 5000;
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
//        Attach.attachAsText("Some file", "Some content");
        closeWebDriver();
    }
}

