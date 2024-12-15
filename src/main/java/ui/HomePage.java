package ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePage {

    public static final Target WELCOME_BANNER = Target.the("Example Domains")
            .located(By.xpath("/html/body/div/h1"));

    public static final Target CLICK_MOREINFOLINNK = Target.the("Example Domains")
            .located(By.xpath("//html/body/div/p[2]/a"));

    public static final Target TABLE_ROWS = Target.the("TABLE")
            .located(By.xpath("//*[@id=\"rir-map\"]/table/tbody/tr"));

    public static final Target NUMBERSHEADERS = Target.the("HEADER")
            .located(By.xpath("//*[@id=\"header\"]/div[2]/ul/li[3]/a"));

}
