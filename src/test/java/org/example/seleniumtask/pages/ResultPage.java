package org.example.seleniumtask.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ResultPage {

    WebDriver driver;

    @FindBy(css = "#sb_form_q")
    private WebElement searchField;

    @FindBy(css = "h2 > a[href]")
    private List <WebElement> result;

    public void clickElement(int num)
    {
        By locator = By.cssSelector("h2 > a[href]");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6)); // явное ожидание 6 сек
        wait.until(ExpectedConditions.and(
                ExpectedConditions.elementToBeClickable(locator) // явное ожидание пока элемент не станет кликабельным
        ));
        result.get(num).click();
        List<String> tabs = new ArrayList<>(driver.getWindowHandles()); // когда открывается новая страница
        driver.switchTo().window(tabs.get(1));

        System.out.println("Нажатие на результат под номером: " + num);
    }

    public String getTextFromSearchField(){
        String val = searchField.getAttribute("value");
        System.out.println("В строке поиска текст: " + val);
        return val;
    }



    public ResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);}

}
