package io.fluentlenium.adapter.kotest.featurespec

import io.kotest.datatest.withData
import io.fluentlenium.adapter.kotest.FluentFeatureSpec
import io.fluentlenium.adapter.kotest.TestConstants

class DataDrivenSpec : FluentFeatureSpec({
    feature("feature") {
        withData(listOf("A", "B")) {
            goTo(TestConstants.DEFAULT_URL)
        }
    }

    withData(listOf("C")) {
        goTo(TestConstants.DEFAULT_URL)
    }
})
