package io.fluentlenium.adapter.spock.description

import io.fluentlenium.adapter.spock.FluentSpecification
import io.github.bonigarcia.wdm.managers.ChromeDriverManager

class TestDescriptionAccessSpec extends FluentSpecification {

    def TEST_METHOD = "shouldRetrieveNames"
    def TEST_CLASS = TestDescriptionAccessSpec.class

    def setupSpec() {
        ChromeDriverManager.chromedriver().setup()
    }

    def setup() {
        getTestClass() == TEST_CLASS
        getTestMethodName() == TEST_METHOD
    }

    def shouldRetrieveNames() {
        expect:
        getTestClass() == TEST_CLASS
        getTestMethodName() == TEST_METHOD
    }

    def cleanup() {
        getTestClass() == TEST_CLASS
        getTestMethodName() == TEST_METHOD
    }

}
