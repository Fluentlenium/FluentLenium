package io.fluentlenium.adapter.spock.smoketest

import io.fluentlenium.adapter.spock.FluentSpecification
import io.github.bonigarcia.wdm.managers.ChromeDriverManager
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.events.EventFiringWebDriver

class SmokeTestSpec extends FluentSpecification {

    def setupSpec() {
        ChromeDriverManager.chromedriver().setup()
    }

    def "smokeTest"() {
        expect:
        getDriver() instanceof EventFiringWebDriver
        EventFiringWebDriver driver = getDriver() as EventFiringWebDriver
        driver.getWrappedDriver() instanceof ChromeDriver
    }

}

