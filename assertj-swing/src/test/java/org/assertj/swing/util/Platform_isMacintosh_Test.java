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
package org.assertj.swing.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.swing.util.OSIdentifierStub.macintosh;
import static org.assertj.swing.util.OSIdentifierStub.osX;
import static org.assertj.swing.util.OSIdentifierStub.windowsXP;

/**
 * Tests for {@link Platform#isMacintosh()}.
 * 
 * @author Alex Ruiz
 */
class Platform_isMacintosh_Test extends Platform_TestCase {
  @Test
  void should_Return_True_If_OS_Is_MacOS_X() {
    Platform.initialize(osX(), toolkit);
    assertThat(Platform.isMacintosh()).isTrue();
  }

  @Test
  void should_Return_False_If_OS_Is_Macintosh() {
    Platform.initialize(macintosh(), toolkit);
    assertThat(Platform.isMacintosh()).isFalse();
  }

  @Test
  void should_Return_False_If_OS_Is_Not_Macintosh() {
    Platform.initialize(windowsXP(), toolkit);
    assertThat(Platform.isMacintosh()).isFalse();
  }
}
