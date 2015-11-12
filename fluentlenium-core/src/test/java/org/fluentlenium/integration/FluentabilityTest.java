/**
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package org.fluentlenium.integration;

import static java.util.concurrent.TimeUnit.NANOSECONDS;
import static org.assertj.core.api.Assertions.assertThat;

import org.fluentlenium.integration.localtest.LocalFluentCase;
import org.junit.Test;

public class FluentabilityTest extends LocalFluentCase {

    @Test
    public void checkIsEnabled() {
        assertThat(
                goTo(DEFAULT_URL).
                        await().
                        atMost(1, NANOSECONDS).
                        until(".small").
                        with("name").
                        equalTo("name").
                        isPresent().
                        find("input").first().isEnabled()).isTrue();
    }

}
