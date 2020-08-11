package org.fluentlenium.adapter.junit.integration.shareddriver;

import org.fluentlenium.configuration.ConfigurationProperties.DriverLifecycle;
import org.fluentlenium.configuration.FluentConfiguration;
import org.fluentlenium.adapter.junit.integration.IntegrationFluentTest;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.withName;

@FluentConfiguration(driverLifecycle = DriverLifecycle.CLASS)
public class SharedDriverPerClass2 extends IntegrationFluentTest {

    @Test
    public void secondMethod() {
        assertThat($(".small", withName("name"))).isEmpty();
    }

}
