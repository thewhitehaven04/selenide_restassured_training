package RedditSteps;

import io.qameta.allure.Step;
import pages.Reddit.MainPage;

public class GenericSteps {

    @Step("Открыть стартовую страницу")
    public void openMainPage() {
        new MainPage().get();
    }
}
