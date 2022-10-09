package RedditSteps;

import io.qameta.allure.Step;
import pages.Reddit.LoginPage;
import pages.Reddit.MainPage;

public class LoginSteps {

    @Step("Открыть форму логина")
    public void openRedditLoginForm(){
        LoginPage loginPage = new MainPage().openLoginForm();
        loginPage.switchToLoginFrame();
        loginPage.loginPageIsVisible();
    };
    @Step("Ввести авторизационные данные: логин \"{0}\", пароль \"{1}\"")
    public void redditLogin(String login, String password){
        LoginPage loginPage = new LoginPage();
        loginPage.login(login, password);
        loginPage.switchToMainFrame();
        loginPage.isLoggedInSuccesfully();
    }
}
