package org.example;

import Pages.CalculatorPages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static org.example.LaunchBrowser.driver;

public class Main {
    @Test
    public static void fillDetails(){
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //Soft Assertion
        SoftAssert softAssert = new SoftAssert();
        //Annual income
        driver.findElement(CalculatorPages.objAnnualIncomeIPF).sendKeys("80000");
        //Other Income
        driver.findElement(CalculatorPages.objOtherIncomeIPF).sendKeys("10000");
        //Living Expenses
        driver.findElement(CalculatorPages.objMonthlyLivingExpensesIPF).sendKeys("500");
    //Loan Repayment
        driver.findElement(CalculatorPages.objOtherLoanIPF).sendKeys("100");
        //Credit Card Limits
        driver.findElement(CalculatorPages.objTotalCreditCardLimitsIPF).sendKeys("10000");
        // Click on CTA
        driver.findElement(CalculatorPages.objBorrowCalculatorCTA).click();
        // Total Estimated Amount
//        wait.until(ExpectedConditions.visibilityOfElementLocated(CalculatorPages.objTotalEstimatedAmount));
        WebElement estimate = driver.findElement(CalculatorPages.objTotalEstimatedAmount);
        String estimateAmount = estimate.getText();
        String expectedValue = "$479,000";
        System.out.println("Estimated Amount: "+estimateAmount);
        softAssert.assertEquals(estimateAmount, expectedValue,"Estimate Amount Mismatch");
        //Start Over
        driver.findElement(CalculatorPages.objStartOverCTA).click();
        //Enter $1 for living expense
        driver.findElement(CalculatorPages.objMonthlyLivingExpensesIPF).sendKeys("1");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(CalculatorPages.objBorrowCalculatorCTA).click();

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement eMessage = driver.findElement(CalculatorPages.objBorrowErrorMessage);
        String errorMessage = eMessage.getText();
        System.out.println("Error Message is: "+ errorMessage);
        softAssert.assertEquals(errorMessage,"Based on the details you've entered, we're unable to give you an estimate of your borrowing power with this calculator. For questions, call us on 1800 035 500.","Error Message Mismatch");
        softAssert.assertAll();

    }
}