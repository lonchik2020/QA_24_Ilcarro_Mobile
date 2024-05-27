package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseScreen {

    AppiumDriver<MobileElement>driver;

    public int[] getScreenSize() {// get screen size [0] height, [1] - weight
        int height = driver.manage().window().getSize().getHeight();
        int wight = driver.manage().window().getSize().getWidth();
        return new int[]{height, wight};
    }

    public BaseScreen(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        // page factory allows to use annotation find by
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);//connection between appium and driver
    }

    public void pause(int time){
        try {
            Thread.sleep(time*1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean textInElementPresent(MobileElement element, String text, int time){
        //oontains text check
        try {
            return new WebDriverWait(driver, time)
                    .until(ExpectedConditions.textToBePresentInElement(element, text));
        }catch (TimeoutException e){
            System.out.println("create exception");
            e.printStackTrace();
            return false;
        }
    }

    public boolean isElementPresentWithWait(MobileElement element, int time){
      return  !new WebDriverWait(driver, time)
                .until(ExpectedConditions.invisibilityOf(element));
    }

}