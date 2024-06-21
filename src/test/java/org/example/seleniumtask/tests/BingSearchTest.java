package org.example.seleniumtask.tests;

import com.sun.tools.javac.Main;
import org.example.seleniumtask.pages.MainPage;
import org.example.seleniumtask.pages.ResultPage;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BingSearchTest {

    private WebDriver driver;


    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        // Fix the issue https://github.com/SeleniumHQ/selenium/issues/11750
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.bing.com/");

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void searchResultTest() {
        String input = "Selenium";
        MainPage mp = new MainPage(driver);
        mp.sendText(input);
        ResultPage rp = new ResultPage(driver);

//        driver.navigate().refresh(); // Обновление страницы
//        WebElement searchField = driver.findElement(By.cssSelector("#sb_form_q")); // Поиск элемента по css

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6)); // явное ожидание 6 сек
        wait.until(ExpectedConditions.and(
                //ExpectedConditions.attributeContains(By.cssSelector("h2 > a[href]"), "href", "selenium"),
                ExpectedConditions.elementToBeClickable(By.cssSelector("h2 > a[href]")) // явное ожидание пока элемент не станет кликабельным
        ));
        rp.clickElement(0);
//        List<WebElement> result = driver.findElements(By.cssSelector("h2 > a[href]")); // поиск списка элементов на странице


        List<String> tabs = new ArrayList<> (driver.getWindowHandles()); // когда открывается новая страница
        driver.switchTo().window(tabs.get(1));
        assertEquals("https://www.selenium.dev/", driver.getCurrentUrl(), "Адрес текущей страницы не про selenium"); // Проверка, что ссылка совподает


//        for (WebElement elements : result) {   // вывести список элементов на консоль
//            System.out.println(elements.getText());
//        }


        }

    @Test
    public void searchFieldTest() {
            String input = "Selenium";

            MainPage mp = new MainPage(driver);
            mp.sendText(input);

        ResultPage rp = new ResultPage(driver);

            assertEquals(input, rp.getTextFromSearchField(),"Текст не совпал");

        //WebElement submitButton = driver.findElement(By.cssSelector("button[data-test='full-search-button']"));
        //submitButton.click();

//        WebElement searchPageField = driver.findElement(By.cssSelector("#sb_form_q"));
//        assertEquals(input, searchPageField.getAttribute("value"));
    }

//    @Test
//    public void example() {
//        List<String> strings = new ArrayList<>();
//        String a = "First string";
//        String b = "Second string";
//        strings.add(a);
//        strings.add(b);
//
//    }
}
