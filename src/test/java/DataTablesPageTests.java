import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.DataTablesPage;


public class DataTablesPageTests extends  BaseTest{
    DataTablesPage dataTablesPage;

    @BeforeClass
    public void setUp() {
        super.setUp();
        driver.get("https://the-internet.herokuapp.com/tables");
        dataTablesPage = new DataTablesPage(driver);
    }

    @Test
    public void sortingUpCheck(){
        dataTablesPage.sortingUp(dataTablesPage.lastNameColumn1);
        System.out.println(driver.findElement(By.xpath("//*[@id='table1']/tbody/tr[1]/td[1]")).getDomAttribute("td"));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='table1'']/tbody/tr[1]/td[1]")).getAttribute("td").equals("Smith"));
    }

    @Test
    public void sortingDownCheck(){
        dataTablesPage.sortingDown(dataTablesPage.lastNameColumn1);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='table1']/tbody/tr[1]/td[1]")).getAttribute("td").equals("Bach"));
    }

    @Test
    public void actionClickCheck(){
        dataTablesPage.actionClick();
        Assert.assertTrue(driver.getCurrentUrl().equals(dataTablesPage.DELETE_URL));

    }
}

