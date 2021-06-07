package org.fluentlenium.adapter.kotest.featurespec

import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldContain
import org.fluentlenium.adapter.kotest.*
import org.fluentlenium.adapter.kotest.TestConstants.DEFAULT_URL

class ExampleFeatureSpec : FluentFeatureSpec({
    feature("Free Spec") {
        scenario("Title should be correct") {
            goTo(DEFAULT_URL)
            jq("#name").fill().with("FluentLenium")
            el("#name").value() shouldBe "FluentLenium"
            window().title() shouldContain "Fluent"
        }
    }
})
