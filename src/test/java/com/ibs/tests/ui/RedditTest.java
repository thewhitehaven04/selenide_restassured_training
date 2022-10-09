package com.ibs.tests.ui;

import RedditSteps.GenericSteps;
import RedditSteps.LoginSteps;
import RedditSteps.MainPageSteps;
import credentials.RedditCredentials;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class RedditTest extends BaseTest {

    private GenericSteps genericSteps;

    @BeforeEach
    public void openMain() {
        genericSteps = new GenericSteps();
        genericSteps.openMainPage();
    }

    @Test
    @Story("Базовый функционал Reddit")
    @Description("Авторизация на Reddit")
    public void redditLoginTest(){
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.openRedditLoginForm();
        loginSteps.redditLogin(RedditCredentials.LOGIN, RedditCredentials.PASSWORD);
    }

    @Test
    @Story("Базовый функционал Reddit")
    @Description("Карточки постов")
    public void postCardsTest(){
        MainPageSteps mainPageSteps = new MainPageSteps();
        mainPageSteps.pageHasMoreThanOnePost();
        mainPageSteps.isPostNameExistsForEveryPost();
    }

    @Test
    @Story("Базовый функционал Reddit")
    @Description("Растущие коммьюнити")
    public void topGrowingCommunitiesExistsAndOfSize(){
        MainPageSteps mainPageSteps = new MainPageSteps();
        mainPageSteps.isTopGrowingCommunitiesCollectionExist(5);
    }
}
