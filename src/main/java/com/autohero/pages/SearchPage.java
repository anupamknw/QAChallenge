package com.autohero.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class SearchPage {
    WebDriver driver = null;

    @FindBy(css = "div[data-qa-selector='filter-year']")
    private WebElement filterYear;

    @FindBy(name = "yearRange.min")
    private WebElement yearRange;

    @FindBy(name = "sort")
    private WebElement sort;

    @FindBy(name = "pageSize")
    private WebElement pageSize;

    @FindBy(css = "div[data-qa-selector='price']")
    private List<WebElement> prices;

    @FindBy(xpath = "//ul[@class='pagination']//li[last()-2]//a")
    private WebElement pageLength;

    @FindBy(xpath = "//ul[@data-qa-selector='spec-list']/li[1]")
    private List<WebElement> years;


    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
    }

    public SearchPage clickOnRegistrationDate() {
        filterYear.click();
        return this;
    }

    public SearchPage selectYearAs() {
        Select select = new Select(yearRange);
        select.selectByValue("6");
        return this;
    }

    public SearchPage sortBy() {
        Select select = new Select(sort);
        select.selectByValue("2");
        return this;
    }

    public SearchPage changePageSize() {
        Select select = new Select(pageSize);
        select.selectByValue("2");
        return this;
    }

    public List<Double> getPrices() throws InterruptedException {
        List<Double> li = new ArrayList<>();

        prices.stream().forEach(price -> {
            li.add(Double.parseDouble(price.getText().split(" ")[0]));
        });

        return li;
    }

    public List<Integer> getYears() throws InterruptedException {
        List<Integer> li = new ArrayList<>();

        years.stream().forEach(year -> {
            li.add(Integer.parseInt(year.getText().split("/")[1]));
        });

        return li;
    }


    public int getPageLength() {
            return Integer.parseInt(pageLength.getText());
    }

    public void clickOnLink(int i) {
        driver.findElement(By.linkText(Integer.toString(i))).click();
    }

}


