package org.example.seleniumtask.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ResultPage {

    @FindBy(css = "#sb_form_q")
    private WebElement searchField;

    @FindBy(css = "h2 > a[href]")
    private List <WebElement> result;

    public void clickElement(int num)
    { result.get(num).click();
        System.out.println("Нажатие на результат под номером: " + num);
    }


    public String getTextFromSearchField(){
       String val = searchField.getAttribute("value");
        System.out.println("В строке поиска текст: " + val);
        return val;
    }

    public ResultPage(WebDriver driver) {
        PageFactory.initElements(driver, this);}
}
