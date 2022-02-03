package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DataTablesPage extends BasePage {
    public DataTablesPage(WebDriver driver) {
        super(driver);
    }

    public final String EDIT_URL = "https://the-internet.herokuapp.com/tables#edit";
    public final String DELETE_URL = "https://the-internet.herokuapp.com/tables#delete";

    @FindBy(tagName = "h3")
    public WebElement mainPageHeader;
    @FindBy(xpath = "//*[@id=\"table1\"]/tbody/tr[1]/td[6]/a[1]")
    public WebElement editAction;
    @FindBy(xpath = "//*[@id=\"table1\"]/tbody/tr[1]/td[6]/a[2]")
    public WebElement deleteAction;

    @FindBy(xpath = "//*[@id=\"table1\"]/thead/tr/th[1]")
    public WebElement lastNameColumn1;

    @FindBy(xpath = "//*[@id=\"table1\"]/thead/tr/th[2]/span")
    public WebElement firstNameColumn1;

    @FindBy(xpath = "//*[@id=\"table1\"]/thead/tr/th[3]/span")
    public WebElement emailColumn1;

    @FindBy(xpath = "//*[@id=\"table1\"]/thead/tr/th[4]/span")
    public WebElement dueColumn1;

    @FindBy(xpath = "//*[@id=\"table1\"]/thead/tr/th[5]/span")
    public WebElement WebsiteColumn1;


    public void sortingUp(WebElement sortColumn) {
        if (sortColumn.getAttribute("class").equals("header headerSortDown")) {
            sortColumn.click();
        }
        if (sortColumn.getAttribute("class").equals("header")) {
            sortColumn.click();
            sortColumn.click();
        } else System.out.println("Już posortowane");

    }

    public void sortingDown(WebElement sortColumn) {
        if (sortColumn.getAttribute("class").equals("header headerSortUp")) {
            sortColumn.click();
        }
        if (sortColumn.getAttribute("class").equals("header")) {
            sortColumn.click();
        } else System.out.println("Już posortowane");

    }

    public void actionClick() {
                    deleteAction.click();
        }
    }



