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
package org.assertj.swing.launcher;

import org.assertj.swing.core.GenericTypeMatcher;
import org.assertj.swing.exception.UnexpectedException;
import org.assertj.swing.finder.WindowFinder;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.launcher.JavaApp.ArgumentObserver;
import org.assertj.swing.test.ExpectedException;
import org.assertj.swing.test.core.RobotBasedTestCase;
import org.junit.jupiter.api.Test;

import javax.annotation.Nonnull;
import java.awt.*;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Tests for {@link ApplicationLauncher#start()}.
 * 
 * @author Yvonne Wang
 */
class ApplicationLauncher_start_Test extends RobotBasedTestCase {
  @Test
  void should_Throw_Error_If_Application_Class_Name_Is_Invalid() {
    ExpectedException.assertContainsMessage(UnexpectedException.class, () -> ApplicationLauncher.application("Hello").start(), "Unable to load class 'Hello'");
  }

  @Test
  void should_Launch_Application_Without_Arguments() {
    ApplicationLauncher.application(JavaApp.class).start();
    assertFrameIsShowing();
  }

  @Test
  void should_Launch_Application_Without_Arguments_Using_FQCN() {
    ApplicationLauncher.application(JavaApp.class.getName()).start();
    assertFrameIsShowing();
  }

  @Test
  void should_Launch_Application_Using_Arguments() {
    final List<String> arguments = newArrayList();
    ArgumentObserver observer = new ArgumentObserver() {
      @Override
      public void arguments(String[] args) {
        arguments.addAll(newArrayList(args));
      }
    };
    JavaApp.add(observer);
    ApplicationLauncher.application(JavaApp.class).withArgs("arg1", "arg2").start();
    assertFrameIsShowing();
    assertThat(arguments).containsOnly("arg1", "arg2");
  }

  @Test
  void should_Throw_Error_If_Argument_Array_Is_Null() {
    String[] args = null;
    assertThrows(IllegalArgumentException.class, () -> ApplicationLauncher.application(JavaApp.class).withArgs(args).start());
  }

  private void assertFrameIsShowing() {
    FrameFixture frameFixture = WindowFinder.findFrame(new GenericTypeMatcher<Frame>(Frame.class) {
      @Override
      protected boolean isMatching(@Nonnull Frame frame) {
        return "Java Application".equals(frame.getTitle()) && frame.isShowing();
      }
    }).using(robot);
    assertThat(frameFixture).isNotNull();
  }
}
