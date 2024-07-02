package org.example.seleniumtask.tests;

import org.example.seleniumtask.pages.MainPage;
import org.example.seleniumtask.pages.ResultPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BingSearchTest {

    private WebDriver driver;
    String input = "Selenium";
    MainPage mp;
    ResultPage rp;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.bing.com/");
        mp = new MainPage(driver);
        rp = new ResultPage(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }


    @Test
    public void searchFieldTest() {
        mp.sendText(input);
        assertEquals(input, rp.getTextFromSearchField(), "Текст не совпал");

//WebElement submitButton = driver.findElement(By.cssSelector("button[data-test='full-search-button']"));
//submitButton.click();
//        WebElement searchPageField = driver.findElement(By.cssSelector("#sb_form_q"));
//        assertEquals(input, searchPageField.getAttribute("value"));
    }

    @Test
    public void searchResultTest() {
        mp.sendText(input);
        rp.clickElement(0);

        String currentUrl = driver.getCurrentUrl();
        assertEquals("https://www.selenium.dev/", currentUrl, "Адрес текущей страницы не про selenium"); // Проверка, что ссылка совподает

//        driver.navigate().refresh(); // Обновление страницы
//        WebElement searchField = driver.findElement(By.cssSelector("#sb_form_q")); // Поиск элемента по css
//ExpectedConditions.attributeContains(By.cssSelector("h2 > a[href]"), "href", "selenium"),
//        List<WebElement> result = driver.findElements(By.cssSelector("h2 > a[href]")); // поиск списка элементов на странице
//        for (WebElement elements : result) {   // вывести список элементов на консоль
//            System.out.println(elements.getText());
//        }

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
