package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.NonUser.nonUser_Page;
//import utils.TestContextSetup;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;


public class common_Page {
    //TestContextSetup testContextSetup;
    nonUser_Page nonUserPage;
    common_Page commonPage;
    FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//src//test//resources//global.properties");
    Properties prop = new Properties();


    WebDriver driver;

    /*Locators*/
    By accept_popup = By.xpath("//a[normalize-space()=\"Accept\"]");
    By accCreateMessage = By.xpath("(//p[@class='bg'])[1]");
    By signInButton = By.xpath("//button[normalize-space()='Sign In']");
    By signUpButton = By.xpath("//a[@class='btn btn-default']");
    By backIcon = By.cssSelector("div[backdrop='static'] span[class='icon-arow_left']");
    By signIn = By.xpath("//a[normalize-space()='Sign In']");
    By likeIcon = By.xpath("//span[@class='icon-like']");
    By commentIcon = By.xpath("//span[@class=\"icon-comment\"]");
    By shareIcon = By.xpath("(//p[contains(text(),'Share')])");
    By shareTribel = By.xpath("//div[@class='my_streamcontent2_like_share open']//li[1]//a[1]");
    By shareFacebook = By.xpath("//div[@class='my_streamcontent2_like_share open']//li[2]//a[1]");
    By copyLink = By.xpath("//span[normalize-space()='Copy link']");
    By copyLinkSuccess = By.xpath("//span[normalize-space()='copied.']");
    By facebookEmail = By.id("email");
    By facebookPassword = By.id("pass");
    By facebookLogin = By.xpath("//input[@name=\"login\"]");
    By postToFacebook = By.xpath("//span[normalize-space()='Post to Facebook']");
    By postComments = By.xpath("(//span[text()='comments'])[1]");
    By allCategory = By.xpath("//span[normalize-space()='All Categories']");
    By myFavourite_cat = By.xpath("//span[normalize-space()='My Favorites']");
    By feed_post_body = By.xpath("(//div[@class='post_body_left'])");
    By single_cat = By.xpath("//span[normalize-space()='Single Category']");
    By everything_except = By.xpath("//span[normalize-space()='Everything Except']");
    By verify_sub_cat = By.cssSelector("span:nth-child(1) > a:nth-child(1)");
    By clearAll = By.xpath("//p[@class='catgery-dropdown-clrall clear-all-btns']");
    By verify_subcat = By.cssSelector(".item.search-filter-category-btn.except_cls");
    By like_avatar = By.xpath("(//ul[@class='circle-container-2021'])");
    By feedUsername = By.xpath("(//span[@class=\"userName\"])");
    By ellipsisIcon_profile = By.xpath("(//span[@class='icon-leftdot'])");
    By ellipsisIcon_post = By.xpath("(//a[@role='button'])");
    By continue_btn = By.xpath("//div[@class='custom-common-but']");
    By message_to = By.xpath("//textarea[@placeholder='Message']");
    By send_btn = By.xpath("//div[contains(text(),'Send')]");
    By navIcon = By.className("icon-navIcon");




    /*Constructor*/
    public common_Page(WebDriver driver) throws IOException {
        this.driver = driver;
    }

    /*Return Element*/
    public void acceptPopup() {
        driver.findElement(accept_popup).click();
    }

    public WebElement accCreateMessage() {
        return driver.findElement(accCreateMessage);
    }

    public WebElement signInButton() {
        return driver.findElement(signInButton);
    }

    public WebElement signUpButton() {
        return driver.findElement(signUpButton);
    }

    public WebElement backIcon() {
        return driver.findElement(backIcon);
    }

    public List<WebElement> setFeedPostBody() {
        return driver.findElements(feed_post_body);
    }

    public List<WebElement> setVerifySubCat() {
        return driver.findElements(verify_sub_cat);
    }

    public WebElement setVerifySubCatAfterClear() {
        return driver.findElement(verify_subcat);
    }

    public List<WebElement> setFeedUserName() {
        return driver.findElements(feedUsername);
    }

    public List<WebElement> setLikeAvatar() {
        return driver.findElements(like_avatar);
    }
    public List<WebElement> setEllipsisIconProfile() {
        return driver.findElements(ellipsisIcon_profile);
    }

    public List<WebElement> setEllipsisIconPost() {
        return driver.findElements(ellipsisIcon_post);
    }

    public List<WebElement> setLikeIcon() {
        return driver.findElements(likeIcon);
    }

    public List<WebElement> setCommentIcon() {
        return driver.findElements(commentIcon);
    }

    public List<WebElement> setShareIcon() {
        return driver.findElements(shareIcon);
    }




    public void setEllipsisIconSubMenu(String ellipsis_sub_menu) {
        try{
            By ellipsisIcon_submenu = By.xpath("//a[normalize-space()='"+ellipsis_sub_menu+"']");
            driver.findElement(ellipsisIcon_submenu).click();
        }
        catch (Exception e){
            System.out.println("Non user can't access the block from user post !! ");
        }
    }

    public void setReportViolationCategory(String report_violation_category) {
        By reportViolation_category = By.xpath("//span[normalize-space()='"+report_violation_category+"']");
        driver.findElement(reportViolation_category).click();
    }

    public void setReportToTribelOrPostOwner(String report_to_tribel_or_user) {
        By report_to = By.xpath("//span[normalize-space()='"+report_to_tribel_or_user+"']");
        driver.findElement(report_to).click();
    }

    /*Methods*/
    public void nonUserAccCreateMessage() {
        signUpButton().isDisplayed();
        signUpButton().isEnabled();
        signInButton().isDisplayed();
        signInButton().isEnabled();
        backIcon().click();
    }

    public void signIn() {
        driver.findElement(signIn).isDisplayed();
        driver.findElement(signIn).isEnabled();
        driver.findElement(signIn).click();
    }

    public void likeIcon(int index) {
        setLikeIcon().get(index).isDisplayed();
        setLikeIcon().get(index).click();
    }

    public void commentIcon(int index) {
        setCommentIcon().get(index).isDisplayed();
        setCommentIcon().get(index).click();
    }

    public void shareIcon (int index) throws InterruptedException {
        setShareIcon().get(index).isDisplayed();
        setShareIcon().get(index).click();
        Thread.sleep(2000);

    }

    public void setShareTribel() {
        driver.findElement(shareTribel).isDisplayed();
        driver.findElement(shareTribel).click();
    }

    public void setCopyLink() throws InterruptedException {
        driver.findElement(copyLink).isDisplayed();
        driver.findElement(copyLink).click();
        Thread.sleep(2000);
        driver.findElement(copyLinkSuccess).isDisplayed();
    }

    public void setShareFacebook() throws InterruptedException {
        driver.findElement(shareFacebook).isDisplayed();
        driver.findElement(shareFacebook).click();

        String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
        String subWindowHandler = null;

        Set<String> handles = driver.getWindowHandles(); // get all window handles
        Iterator<String> iterator = handles.iterator();
        while (iterator.hasNext()) {
            subWindowHandler = iterator.next();
        }
        driver.switchTo().window(subWindowHandler); // switch to popup window

        // perform operations on popup
        driver.findElement(facebookEmail).sendKeys("mehercyra+remi@gmail.com");
        driver.findElement(facebookPassword).sendKeys("Agile123");
        driver.findElement(facebookLogin).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(postToFacebook).click();
        driver.close();
        Thread.sleep(3000);
        driver.switchTo().window(parentWindowHandler);
    }

    public void setPostComments() {
        driver.findElement(postComments).isDisplayed();
        driver.findElement(postComments).click();
    }

    public void allCategory() {
        driver.findElement(allCategory).isDisplayed();
        driver.findElement(allCategory).click();
    }

    public void myFavourite_cat() {
        driver.findElement(myFavourite_cat).isDisplayed();
        driver.findElement(myFavourite_cat).click();
    }

    public void personalizeYourFeed() {
        //driver.findElement(personalizeYourFeed).isDisplayed();
        Actions build = new Actions(driver); // heare you state ActionBuider
        build.doubleClick(driver.findElement(By.xpath("//input[@placeholder='Personalize your feed...']"))).perform();
    }

    public void categoryName(String cat_name) {
        By Categrory = By.xpath("//span[normalize-space()='" + cat_name + "']");
        driver.findElement(Categrory).isDisplayed();
        driver.findElement(Categrory).click();
    }


    By sub_Categrory = By.xpath("//body[1]/div[1]/div[1]/div[1]/div[5]/div[1]/div[1]/div[2]/div[7]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/ul[1]/li/ul[1]/li");

    public List<WebElement> setsub_cat() {
        return driver.findElements(sub_Categrory);
    }

    //By sub_Categrory_icon = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[5]/div[1]/div[1]/div[2]/div[7]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/ul[1]/li/ul//li/a/span");
    By sub_Categrory_icon = By.className("sub-cat-add-img");

    public List<WebElement> setsub_cat_icon() {
        return driver.findElements(sub_Categrory_icon);
    }

/*    public void subCategoryName(String sub_cat_name) {
        By sub_Categrory = By.xpath("//span[normalize-space()='" + sub_cat_name + "']");
        driver.findElement(sub_Categrory).isDisplayed();
        driver.findElement(sub_Categrory).click();
    }*/

    public List<WebElement> setsubCategoryName() {
        By sub_Categrory = By.xpath("//li//ul//li");
        return driver.findElements(sub_Categrory);
    }

    public void subCategoryName(String sub_cat_name) {
        for (WebElement all: setsubCategoryName()) {
            if (Objects.equals(all.getText(), sub_cat_name)){
                System.out.println(all.getText());
                all.click();
            }
        }
    }

    public void feedPost() {
        if (setFeedPostBody().size() > 0) {
            System.out.println("Feed post count is : " + setFeedPostBody().size());
            System.out.println("---------------------------------------------");
            for (int i = 0; i < setFeedPostBody().size(); i++) {
                setFeedPostBody().get(i).isDisplayed();
                //*Print every feed post*//*
                System.out.println(setFeedPostBody().get(i).getText());
                System.out.println("---------------------------------------------");
            }
        } else {
            System.out.println("Feed post not found !!");
        }
    }

    public void single_Cat() {
        driver.findElement(single_cat).isDisplayed();
        driver.findElement(single_cat).click();
    }

    public void select_a_cat() {
        Actions build = new Actions(driver);
        build.doubleClick(driver.findElement(By.xpath("//input[@id='single_cat_input']"))).perform();
    }

    public void setEverything_except() {
        driver.findElement(everything_except).isDisplayed();
        driver.findElement(everything_except).click();
    }


    public void verifySubcategoryNotFound(String cat, String sub_cat) {
        System.out.println("Category count is : " + setVerifySubCat().size());
        System.out.println("---------------------------------------------");
        for (WebElement elements : setVerifySubCat()) {
            String data = elements.getText();
            //if (!(data.equals("Arts - Painting"))){
            if (!(data.equals(cat + "-" + sub_cat))) {
                System.out.println("Everything Except Category Not Found :" + elements.getText());
            } else {
                System.out.println("Everything Except Category Found :" + cat + "-" + sub_cat);
                System.exit(0);
            }
        }
    }

        /*try{
            if (setVerifySubCat().size()>0) {
                System.out.println("Feed post count is : " +setVerifySubCat().size());
                System.out.println("---------------------------------------------");
                for (int i = 0; i <setVerifySubCat().size(); i++) {
                    String subcat = "Advice - Dating";
                    if (!setVerifySubCat().get(i).getText().equals(subcat)){
                        setVerifySubCat().get(i).isDisplayed();
                    }
                    else if (setVerifySubCat().get(i).getText().equals(subcat)) {
                        System.out.println("Except category not working properly !!");
                    }
                }
            }else{
                System.out.println("Feed post not found !!");
            }
        }
        catch (Exception e){
            System.out.println(e);
        }*/


    public void clearAll() {
        driver.findElement(clearAll).isDisplayed();
        driver.findElement(clearAll).click();
    }


    public void likeAvatar() throws InterruptedException {
        for (int i = 0; i < setLikeAvatar().size(); i++) {
            int count = i + 3;
            if (count <= 5) {
                setLikeAvatar().get(count).isDisplayed();
                setLikeAvatar().get(count).click();
                Thread.sleep(5000);
                driver.navigate().back();
                Thread.sleep(5000);
            }
        }
    }


    public void postUsernameOnFeed(int feed_username_number){
        try{
            setFeedUserName().get(feed_username_number).isDisplayed();
            setFeedUserName().get(feed_username_number).click();
        }
        catch (Exception e){
            System.out.println("Feed post not found !");
        }
    }

    public void ellipsisIcon(String postEllipsisName) throws InterruptedException {

        switch (postEllipsisName.toLowerCase()) {
            case "profile":
                setEllipsisIconProfile().get(0).isDisplayed();
                setEllipsisIconProfile().get(0).click();
                Thread.sleep(5000);
                break;
            case "post":
                setEllipsisIconPost().get(0).isDisplayed();
                setEllipsisIconPost().get(0).click();
                Thread.sleep(5000);
        }
    }

    public void continueButton(){
        driver.findElement(continue_btn).isDisplayed();
        driver.findElement(continue_btn).click();
    }

    public void reportMessage(String message){
        driver.findElement(message_to).isDisplayed();
        driver.findElement(message_to).sendKeys(message);
    }

    public void sendButton(){
        driver.findElement(send_btn).isDisplayed();
        driver.findElement(send_btn).click();
    }

    public void setProfileMenu(String profileMenu) {
        try{
            By profile_menu = By.partialLinkText(profileMenu);
            driver.findElement(profile_menu).click();
        }
        catch (Exception e){
            System.out.println("Profile menu not found !! ");
       }
    }

    public void navIcon() {
        driver.findElement(navIcon).isDisplayed();
        driver.findElement(navIcon).click();
    }

}




    