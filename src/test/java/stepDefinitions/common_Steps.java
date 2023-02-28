package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.NonUser.nonUser_Page;
import pages.common_Page;
import utils.TestContextSetup;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class common_Steps {

    TestContextSetup testContextSetup;
    nonUser_Page nonUserPage;
    common_Page commonPage;
    FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//src//test//resources//global.properties");
    Properties prop = new Properties();

    /*Constructor*/
    public common_Steps(TestContextSetup testContextSetup) throws IOException {
        this.testContextSetup = testContextSetup;
        this.nonUserPage = testContextSetup.pageObjectManager.getNonUserPage();
        this.commonPage = testContextSetup.pageObjectManager.getCommonPage();
        prop.load(fis);
    }

    /*Implementation of Gherkin Syntex*/
    @Given("Go to Tribel.com")
    public void goToTribelCom() throws InterruptedException {
        testContextSetup.testBase.driver.get(prop.getProperty("Url"));
        testContextSetup.testBase.driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS) ;
        commonPage.acceptPopup();
        Thread.sleep(6000);
    }

    @Then("Click on {string}")
    public void clickOnMenu(String menu) {
        testContextSetup.testBase.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
        nonUserPage.setMenuName(menu);
        testContextSetup.testBase.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
        Assert.assertEquals(commonPage.accCreateMessage().getText(), prop.getProperty("signInPageVerify"));
        commonPage.nonUserAccCreateMessage();
    }

    @Then("Click on {string} feed posts")
    public void clickOnFeedPosts(String feed) throws InterruptedException {
        Thread.sleep(2000);
        nonUserPage.setFeedName(feed);
        Thread.sleep(2000);
        String braekingurl = prop.getProperty("BreakingUrl");
        String trendingurl = prop.getProperty("TrendingUrl");

        String currentURL = testContextSetup.testBase.driver.getCurrentUrl();
        if (currentURL.equals(braekingurl)) {
            System.out.println(currentURL);
        } else if (currentURL.equals(trendingurl)) {
            System.out.println(currentURL);
        }
        Thread.sleep(2000);
        commonPage.feedPost();
    }

    @Then("Click on Sign-in")
    public void clickOnSignIn() {
        commonPage.signIn();
        Assert.assertEquals(testContextSetup.testBase.driver.getCurrentUrl(), prop.getProperty("SignInUrl"));
    }

    @Then("Click like on posts in the feed")
    public void clickLikeOnPostsInTheFeed(){
        commonPage.likeIcon(1);
        testContextSetup.testBase.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
        Assert.assertEquals(commonPage.accCreateMessage().getText(), prop.getProperty("signInPageVerify"));
        commonPage.nonUserAccCreateMessage();
    }

    @Then("Click on comment on any posts")
    public void clickOnCommentOnAnyPosts() {
        commonPage.commentIcon(1);
        testContextSetup.testBase.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
        Assert.assertEquals(commonPage.accCreateMessage().getText(), prop.getProperty("signInPageVerify"));
        commonPage.nonUserAccCreateMessage();
    }

    @Then("Click share on tribel")
    public void clickShareOnTribel() {
        commonPage.setShareTribel();
        Assert.assertEquals(commonPage.accCreateMessage().getText(), prop.getProperty("signInPageVerify"));
        commonPage.nonUserAccCreateMessage();
    }

    @When("Click on select My Favorites category")
    public void clickOnSelectMyFavoritesCategory() {
        commonPage.allCategory();
        commonPage.myFavourite_cat();
    }

    @Then("Click on personalize your feed, category {string} & sub category {string}")
    public void clickCategorySubCategory(String category, String sub_category) {
        //commonPage.select_a_cat();
        commonPage.categoryName(category);
        commonPage.subCategoryName(sub_category);
        //testContextSetup.testBase.driver.navigate().back();
        //commonPage.select_a_cat();
        //commonPage.feedPost();
    }

    @When("Click on select single category")
    public void clickOnSelectSingleCategory() {
        commonPage.allCategory();
        commonPage.single_Cat();
    }

    @When("Click on everything except the category")
    public void clickOnEverythingExceptTheCategory() {
        commonPage.allCategory();
        commonPage.setEverything_except();
    }

    @Then("Click on personalize your feed, category {string} & sub category {string} for everything except")
    public void clickOnEverythingExcept(String category, String sub_category) {
        commonPage.categoryName(category);
        commonPage.subCategoryName(sub_category);
        commonPage.verifySubcategoryNotFound(category, sub_category);
    }

    @Then("Click on clear all the selected categories for a personalized feed")
    public void clickOnClearAllTheSelectedCategories() {
        commonPage.clearAll();
        try{
            Assert.assertFalse(commonPage.setVerifySubCatAfterClear().isDisplayed());
        }
        catch (Exception e){
            System.out.println("Clear all functionality working properly !!");
        }
    }

    @Then("Click on the avatar of liked person from posts.")
    public void clickOnTheAvatarOfLikedPersonFromPosts() throws InterruptedException {
        commonPage.likeAvatar();
    }

    @Then("There will show the most trending and breaking posts in those feeds.")
    public void trendingAndBreakingPostsInThoseFeeds() {
        commonPage.feedPost();
    }

    @Then("Copy the link to the post")
    public void copyTheLinkToThePost() throws InterruptedException {
        commonPage.shareIcon(1);
        commonPage.setCopyLink();
    }

    @Then("Click on a user's profile {int}")
    public void clickOnAUserSProfile(int feed_username_number){
        String username = commonPage.setFeedUserName().get(feed_username_number).getText();
        commonPage.postUsernameOnFeed(feed_username_number);
        testContextSetup.testBase.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertEquals(commonPage.setFeedUserName().get(0).getText(), username);
    }


    @Then("Click on user report post from ellipsis icon {string}, {string}, {string}, {string}, {string}")
    public void userReportProfile(String ellipsisIconName, String ellipsisSubMenu, String violationCategory, String reportTo, String reportMessage ) throws InterruptedException {
        Thread.sleep(3000);
        testContextSetup.testBase.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
        commonPage.ellipsisIcon(ellipsisIconName);
        commonPage.setEllipsisIconSubMenu(ellipsisSubMenu);
        commonPage.setReportViolationCategory(violationCategory);
        commonPage.continueButton();
        commonPage.setReportToTribelOrPostOwner(reportTo);
        commonPage.continueButton();
        commonPage.reportMessage(reportMessage);
        commonPage.sendButton();
        Thread.sleep(2000);
    }

    @Then("Click on the user profile block from the ellipsis icon {string}, {string}")
    public void profileBlockFromTheEllipsisIcon(String ellipsisIconName, String ellipsisSubMenu) throws InterruptedException {
        commonPage.ellipsisIcon(ellipsisIconName);
        commonPage.setEllipsisIconSubMenu(ellipsisSubMenu);
        commonPage.nonUserAccCreateMessage();
    }

    @Then("Click on the user posts block from the ellipsis icon {string}, {string}")
    public void postsBlockFromTheEllipsisIcon(String ellipsisIconName, String ellipsisSubMenu) throws InterruptedException {
        commonPage.ellipsisIcon(ellipsisIconName);
        commonPage.setEllipsisIconSubMenu(ellipsisSubMenu);
        commonPage.nonUserAccCreateMessage();
    }

    @And("Click on the share")
    public void clickOnTheShare() throws InterruptedException {
        testContextSetup.testBase.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
        commonPage.shareIcon(1);
    }

    @Then("Click on user's profile menu {string}")
    public void clickOnUserProfileMenu(String menu_name) {
        commonPage.setProfileMenu(menu_name);
        try{
            /*Need to implement active user base test case in try block*/
            commonPage.shareIcon(1);
        }
        catch (Exception e){
            Assert.assertEquals(commonPage.accCreateMessage().getText(), prop.getProperty("signInPageVerify"));
            commonPage.nonUserAccCreateMessage();
        }
    }
}




