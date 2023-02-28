package pages.NonUser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class nonUser_Page {

    WebDriver driver;

    /*Locators*/
    By tribelLogo = By.className("logo_area");

    By signInSignUp_Suggestion = By.xpath("//span[@class='featute-alert-21']");
    By closePopup = By.xpath("//button[@class=\"overview_close_button fly_clos\"]");
    By starContributor = By.xpath("//h6[normalize-space()='Star Contributors']");
    By signInPage = By.xpath("//h3[normalize-space()='Sign In']");
    By menuName = By.xpath("//h2[normalize-space()=['']");
    By feed_post_body = By.xpath("(//div[@class='post_body_left'])");
    By home_menu = By.xpath("(//a[normalize-space()='Home'])[1]");


    public nonUser_Page(WebDriver driver) {
        this.driver = driver;
    }

    public String currentURL() {
        return driver.getCurrentUrl();
    }

    public void setTribelLogo() {
        driver.findElement(tribelLogo).isDisplayed();
        driver.findElement(tribelLogo).click();
    }

    public WebElement setSignInSignUp_Suggestion() {
        return driver.findElement(signInSignUp_Suggestion);
    }

    public void setClosePopup() {
        driver.findElement(closePopup).click();
    }

    public void setStarContributor() {
        driver.findElement(starContributor).isDisplayed();
        driver.findElement(starContributor).click();
    }

    public List<WebElement> setFeedPostBody() {
        return driver.findElements(feed_post_body);
    }

    public void setMenuName(String menu_name) {
        By menuName = By.xpath("(//h6[normalize-space()='" + menu_name + "'])");
        driver.findElement(menuName).isDisplayed();
        driver.findElement(menuName).click();
    }

    public void setHeaderMenuName(String menu_name) {
        By menuName = By.xpath("(//a[normalize-space()='" + menu_name + "'])[2]");
        driver.findElement(menuName).isDisplayed();
        driver.findElement(menuName).click();
    }

    public void setFeedName(String feed_name) {
        By feedName = By.xpath("//h6[normalize-space()='" + feed_name + "']");
        driver.findElement(feedName).isDisplayed();
        driver.findElement(feedName).click();
    }




}







    