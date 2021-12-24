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

    void GithubSelenideWikiSearch() {

        $("[data-test-selector=nav-search-input]").setValue("Selenide").pressEnter();

        $$("ul.repo-list li").first().$("a").click();

        $("[data-content='Wiki']").shouldBe(visible);

        $("[data-content='Wiki']").click();

        $(".js-wiki-more-pages-link").click();

        sleep(3000);

        $(byText("SoftAssertions")).shouldBe(visible);

        sleep(3000);

        $(byText("Soft assertions")).click();

        $("[start='3']").$(byText("Using JUnit5 extend test class:")).shouldBe(visible);

    }

}