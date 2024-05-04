package io.fluentlenium.adapter.spock.smoketest

import io.fluentlenium.adapter.spock.FluentSpecification
import io.github.bonigarcia.wdm.managers.ChromeDriverManager
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions

class SmokeTestNewWebDriverSpec extends FluentSpecification {

    def setupSpec() {
        ChromeDriverManager.chromedriver().setup()
    }

    @Override
    WebDriver newWebDriver() {
        ChromeOptions chromeOptions = new ChromeOptions()
        chromeOptions.addArguments("--headless=new")
        return new ChromeDriver(chromeOptions)
    }

    def "smokeTest"() {
        expect:
        getDriver() instanceof ChromeDriver
    }

}
