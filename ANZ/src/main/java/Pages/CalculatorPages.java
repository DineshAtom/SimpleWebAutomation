package Pages;

import org.openqa.selenium.By;

/**
 * All Xpaths regarding to calculator screen saved inside this class file
 */
public class CalculatorPages {

    // IPF = Input Field

    public static By objAnnualIncomeIPF = By.xpath("//input[@aria-labelledby='q2q1']");

    public static By objOtherIncomeIPF = By.xpath("//input[@aria-labelledby='q2q2']");

   public static By objMonthlyLivingExpensesIPF = By.xpath("//input[@id='expenses']");

    public static By objOtherLoanIPF = By.xpath("//input[@id='otherloans']");

    public static By objTotalCreditCardLimitsIPF = By.xpath("//input[@id='credit']");

    public static By objBorrowCalculatorCTA = By.xpath("//Button[@id='btnBorrowCalculater']");

    public static By objTotalEstimatedAmount = By.xpath("//span[@id='borrowResultTextAmount']");

    public static By objStartOverCTA = By.xpath("(//button[@class='start-over'])[1]");

    public static By objBorrowErrorMessage = By.xpath(" //div[@class='borrow__error__text']");


//    public static By objTODO = By.xpath("");
//
//    public static By objTODO = By.xpath("");
//
//    public static By objTODO = By.xpath("");

}
