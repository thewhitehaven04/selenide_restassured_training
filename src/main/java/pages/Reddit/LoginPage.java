package pages.Reddit;


import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {
    private final String LOGIN_TEXT_WARNING = "By continuing, you agree are setting up a Reddit account and " +
            "agree to our User Agreement and Privacy Policy.";

    private final SelenideElement iframeLogin = $(By.xpath("//iframe[contains(@src, \"login\")]"));
    public void loginPageIsVisible(){
        $(By.xpath("//main[@class=\"Login\"]")).shouldBe(visible);
    }

    public void login(String username, String password){
        $("#loginUsername").sendKeys(username);
        $("#loginUsername").shouldHave(value(username));
        $("#loginPassword").sendKeys(password);
        $("#loginPassword").shouldHave(value(password));

        $(By.xpath("//button[@type=\"submit\" and contains(text(), \"Log In\")]")).click();
    }

    public void isLoggedInSuccesfully() {
        $(new ByText("Successfully logged in!")).shouldBe(visible);
    }

    public void switchToLoginFrame() {
        switchTo().frame(iframeLogin);
    }
    public void switchToMainFrame() {
        switchTo().frame(0);
    }

}
