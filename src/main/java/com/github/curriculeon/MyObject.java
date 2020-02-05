package com.github.curriculeon;

import com.git_leon.leonium.browsertools.browserhandler.BrowserHandler;
import com.git_leon.leonium.browsertools.factories.BrowserHandlerFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyObject implements Runnable {
    public void run() {
        WebDriver driver = BrowserHandlerFactory.FIREFOX.getDriver();
        // declaration and instantiation of objects/variables
//        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
//        WebDriver driver = new FirefoxDriver();
        //comment the above 2 lines and uncomment below 2 lines to use Chrome
//        System.setProperty("webdriver.chrome.driver","G:\\chromedriver.exe");
//        WebDriver driver = new ChromeDriver();

        BrowserHandler browser = BrowserHandlerFactory.FIREFOX.getBrowserHandler();

        String baseUrl = "http://automationpractice.com/index.php";
        String expectedTitle = "Welcome: Mercury Tours";
        String actualTitle = "";

        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);

        // get the actual value of the title
        actualTitle = driver.getTitle();
        String searchQueryTopId  = "search_query_top";
        WebElement we = driver.findElement(By.id(searchQueryTopId));

        we.sendKeys("shirt");
        we.submit();

        /*
         * compare the actual title of the page with the expected one and print
         * the result as "Passed" or "Failed"
         */
        if (actualTitle.contentEquals(expectedTitle)) {
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }

        //close Fire fox
        driver.close();

    }
}
