/**
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright 2012-2015 the original author or authors.
 */
package org.assertj.swing.driver;

import org.assertj.swing.test.data.BooleanProvider;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

/**
 * Tests for {@link JAppletDriver#isActive(JApplet)}.
 * 
 * @author Alex Ruiz
 */
class JAppletDriver_isActive_Test extends JAppletDriver_TestCase {
  static Collection<Object[]> booleans() {
    return newArrayList(BooleanProvider.booleans());
  }

  @ParameterizedTest
  @MethodSource("booleans")
  void should_Return_Is_Active(boolean active) {
    applet().setActive(active);
    boolean result = driver().isActive(applet());
    assertThat(result).isEqualTo(active);
    assertThat(applet().wasMethodCalledInEDT("isActive")).isTrue();
  }
}
