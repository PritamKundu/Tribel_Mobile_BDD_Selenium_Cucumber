package pages;
import pages.NonUser.nonUser_Page;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class PageObjectManager {

    public WebDriver driver;
    public nonUser_Page newUserPage;
    public common_Page commonPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public nonUser_Page getNonUserPage() {
        newUserPage = new nonUser_Page(driver);
        return newUserPage;
    }

    public common_Page getCommonPage() throws IOException {
        commonPage = new common_Page(driver);
        return commonPage;
    }
}
