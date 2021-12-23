import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.conditions.Text;
import com.codeborne.selenide.conditions.Visible;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class GithubSelenideWikiSoftAssertionsJUnit5CodeExampleSearch {

    @BeforeAll
    static void browserOpeningConfiguration() {

        Configuration.browser = CHROME;
        Configuration.fastSetValue = false;
        // Configuration.browserSize = "1920x1080";
        baseUrl = "https://github.com/";

        clearBrowserCookies();

        open(baseUrl);
    }

    @Test
    @Order(1)
    void GithubSelenideWikiSearch() {

        $("[data-test-selector=nav-search-input]").setValue("Selenide").pressEnter();

        $$("ul.repo-list li").first().$("a").click();

        $("[data-content='Wiki']").shouldBe(visible);

    }

    @Test
    @Order(2)
    void SoftAssertionLinkSearch() {

        $("[data-content='Wiki']").click();

        $("[class='markdown-body']").$(byText("Soft assertions")).shouldBe(visible);

    }

    @Test
    @Order(3)
    void SoftAssertionJUnit5ExampleSearch() {

        $(byText("Soft assertions")).click();

        $("[start='3']").$(byText("Using JUnit5 extend test class:")).shouldBe(visible);

    }

}