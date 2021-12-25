import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GithubSelenideWikiSoftAssertionsJUnit5CodeExampleSearch {

    @BeforeAll
    static void browserOpeningConfiguration() {

        Configuration.browser = CHROME;
        Configuration.fastSetValue = false;
        baseUrl = "https://github.com/";

        clearBrowserCookies();

        open(baseUrl);
    }

    @Test
    void GithubSelenideWikiSearch() {

        // На странице github, в поле поиска вводим "Selenide" и нажимаем клавишу 'Enter'
        $("[data-test-selector=nav-search-input]").setValue("Selenide").pressEnter();
        // На странице с результатами поиска выбираем первый элемент из списка
        $$("ul.repo-list li").first().$("a").click();
        // На странице "selenide/selenide", на вкладке "< > Code" ищем вкладку "Wiki" и нажимаем на неё
        $("[data-content='Wiki']").shouldBe(visible).click();
        // На странице "selenide/selenide", на вкладке "Wiki", в меню "Pages" ищем кнопку "Show ... more pages.." и нажимаем на неё
        $(".js-wiki-more-pages-link").click();
        // На странице "selenide/selenide", на вкладке "Wiki", в развернутом меню "Pages" ищем ссылку по тексту "SoftAssertions" и нажимаем на неё
        $("#wiki-pages-box").$(byText("SoftAssertions")).click();
        // На странице "selenide/selenide", на вкладке "Wiki", в статье "SoftAssertions" ищем пример кода
        $("[start='3']").$(byText("Using JUnit5 extend test class:")).shouldBe(visible);

    }

}