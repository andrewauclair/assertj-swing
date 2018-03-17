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

import org.assertj.swing.exception.WaitTimedOutError;
import org.assertj.swing.test.core.RobotBasedTestCase;
import org.assertj.swing.test.swing.TestWindow;
import org.assertj.swing.test.util.StopWatch;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.swing.test.util.StopWatch.startNewStopWatch;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Tests for {@link ComponentShownWaiter#waitTillShown(java.awt.Component)}.
 * 
 * @author Alex Ruiz
 */
public class ComponentShownWaiter_waitTillShown_Test extends RobotBasedTestCase {
  private TestWindow window;

  @Override
  protected void onSetUp() {
    window = TestWindow.createNewWindow(getClass());
  }

  @Test
  void should_Use_Default_Timeout() {
    StopWatch stopWatch = startNewStopWatch();
    try {
      assertThrows(WaitTimedOutError.class, () -> ComponentShownWaiter.waitTillShown(window));
    } finally {
      stopWatch.stop();
      assertThat(stopWatch.ellapsedTime()).isGreaterThanOrEqualTo(5000);
    }
  }
}
