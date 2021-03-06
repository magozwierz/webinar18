import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.DynamicLoadingPage;

import java.time.Duration;

import static pages.DynamicLoadingPage.EXPECTED_CONFIRMATION_TEXT;

public class DynamicLoadingPageTests extends BaseTest {
    DynamicLoadingPage dynamicLoadingPage;

    @BeforeClass
    public void setUp() {
        super.setUp();
        driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");
        dynamicLoadingPage = new DynamicLoadingPage(driver);
    }

    @Test
    public void checkConfirmationText() {
        dynamicLoadingPage.clickStartButton();
        //Rozbudować checkConfirmationText() o sprawdzenie loadingBar - czy jest widoczny i następnie czy zniknął
        Assert.assertTrue((dynamicLoadingPage.loadingBar.getAttribute("style")).isEmpty());
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("finish")));
        //w metodzie checkConfirmationText() zmienić wait, aby korzystał z webelementu finishTextHeader
        wait.until(ExpectedConditions.textToBePresentInElement(dynamicLoadingPage.finishTextHeader, EXPECTED_CONFIRMATION_TEXT));
        Assert.assertEquals(dynamicLoadingPage.getFinishLoadingConfirmation(), EXPECTED_CONFIRMATION_TEXT);
        Assert.assertEquals(dynamicLoadingPage.loadingBar.getAttribute("style"), "display: none;");

    }
}