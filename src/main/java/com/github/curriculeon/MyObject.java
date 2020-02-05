package com.github.curriculeon;

import com.git_leon.leonium.browsertools.browserhandler.BrowserHandler;
import com.git_leon.leonium.browsertools.browserhandler.ExpectedBrowserCondition;
import com.git_leon.leonium.browsertools.factories.BrowserHandlerFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyObject implements Runnable {
    public void run() {
        BrowserHandler browser = BrowserHandlerFactory.FIREFOX.getBrowserHandler();
        String baseUrl = "http://automationpractice.com/index.php";
        browser.navigateTo(baseUrl);

        String searchQueryTopId = "search_query_top";
        WebElement we = browser.getElement(By.id(searchQueryTopId));
        we.sendKeys("shirt\n");
        we.submit();
        ExpectedBrowserCondition.pageState("ready");
        WebElement firstItemInList = browser.getElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li/div/div[1]/div/a[1]/img"));
        firstItemInList.click();
        ExpectedBrowserCondition.pageState("ready");
    }
}
