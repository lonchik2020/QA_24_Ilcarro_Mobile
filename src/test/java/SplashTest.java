import config.AppiumConfig;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.SplashScreen;

public class SplashTest extends AppiumConfig {

    @Test
    public void validateVersion(){
        Assert.assertTrue(new SplashScreen(driver).validateVersionApp());
    }
}
