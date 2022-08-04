package org.fluentlenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.fluentlenium.adapter.testng.FluentTestNgSpringTest;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.BeforeSuite;

import static org.fluentlenium.utils.UrlUtils.getAbsoluteUrlFromFile;

@ContextConfiguration(locations = {"classpath:spring-test-config.xml"})
public class IntegrationFluentTestNg extends FluentTestNgSpringTest {

    public static final String DEFAULT_URL;
    public static final String PAGE_2_URL;

    static {
        DEFAULT_URL = getAbsoluteUrlFromFile("index.html");
        PAGE_2_URL = getAbsoluteUrlFromFile("page2.html");
    }

    @BeforeSuite
    public void setUpChrome() {
        WebDriverManager.chromedriver().setup();
    }

}
