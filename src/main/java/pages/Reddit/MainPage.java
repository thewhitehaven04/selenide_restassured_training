package pages.Reddit;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private static final String ROOT_URL = "https://reddit.com/";
    private static final String TITLE = "Reddit - Dive into anything";

    public void get() {
        open("https://reddit.com", MainPage.class);
    };
    public LoginPage openLoginForm(){
        $(By.xpath("//a[text()='Log In']")).shouldBe(Condition.visible).click();
        return page(LoginPage.class);
    }

    public ElementsCollection getPostCards() {
        return $$(By.xpath("//div[@data-testid=\"post-container\"]"));
    }

    public ElementsCollection getPostCardsHeaders() {
        return $$(By.xpath("//a[@data-click-id=\"body\"]"));
    }

    public SelenideElement getTopGrowingCommunitiesContainerElement() {
        return $(By.xpath("//a[@href=\"subreddits/leaderboard/\"]"));
    }

    public ElementsCollection getTopGrowingCommunitiesColleciton() {
        return $$(By.xpath("//div/following-sibling::ol/li"));
    }
}
