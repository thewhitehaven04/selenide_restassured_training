package RedditSteps;

import com.codeborne.selenide.CollectionCondition;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import pages.Reddit.MainPage;

public class MainPageSteps {

    @Step("На странице больше одного поста")
    public void pageHasMoreThanOnePost() {
        new MainPage().getPostCards().shouldHave(CollectionCondition.sizeGreaterThanOrEqual(1));
    }

    @Step("Для каждого поста присутствует название")
    public void isPostNameExistsForEveryPost() {
        MainPage mainPage = new MainPage();
        Assertions.assertEquals(mainPage.getPostCards().size(), mainPage.getPostCardsHeaders().size());
    }

    @Step("Существует коллекция самых растущих коммьюнити из {0} записей")
    public void isTopGrowingCommunitiesCollectionExist(int size){
        MainPage mainPage = new MainPage();
        Assertions.assertTrue(mainPage.getTopGrowingCommunitiesContainerElement().exists());
        Assertions.assertEquals(mainPage.getTopGrowingCommunitiesColleciton().size(), size);
    }
}
