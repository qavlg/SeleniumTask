package org.example.seleniumtask.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// https://www.bing.com/?)

public class MainPage {

//        @FindBy(xpath = "//*[@data-test-marker='Developer Tools']")
//        public WebElement seeDeveloperToolsButton;
//
//        @FindBy(xpath = "//*[@data-test='suggestion-action']")
//        public WebElement findYourToolsButton;
//
//        @FindBy(xpath = "//div[@data-test='main-menu-item' and @data-test-marker = 'Developer public Tools']")
//        WebElement toolsMenu;

    @FindBy(css = "#sb_form_q")
    private WebElement searchField;

    public void sendText (String text){
        searchField.sendKeys(text); // Отправить значение
        searchField.submit(); // Клик
        System.out.println("Введен текст: " + text);
    }

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


}
