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

import javax.swing.JButton;

import org.assertj.swing.exception.UnexpectedException;
import org.assertj.swing.test.ExpectedException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Tests for {@link AppletLauncher#applet(String)}.
 * 
 * @author Yvonne Wang
 */
class AppletLauncher_appletWithTypeName_Test extends AppletLauncher_TestCase {
  @Test
  void should_Throw_Error_If_Applet_Type_Name_Is_Null() {
    String type = null;
    assertThrows(IllegalArgumentException.class, () -> AppletLauncher.applet(type));
  }

  @Test
  void should_Throw_Error_If_Applet_Type_Name_Is_Empty() {
    assertThrows(IllegalArgumentException.class, () -> AppletLauncher.applet(""));
  }

  @Test
  void should_Throw_Error_If_Type_Name_Is_Does_Not_Belong_To_An_Applet() {
    assertThrows(IllegalArgumentException.class, () -> AppletLauncher.applet(JButton.class.getName()));
  }

  @Test
  void should_Throw_Error_If_Applet_Type_Does_Not_Exist() {
    ExpectedException.assertContainsMessage(UnexpectedException.class, () -> AppletLauncher.applet("Hello"), "Unable to load class Hello");
  }

  @Test
  void should_Throw_Error_If_Applet_Cannot_Be_Instantiated_From_Type_Name() {
    ExpectedException.assertContainsMessage(UnexpectedException.class, () -> AppletLauncher.applet(AnApplet.class.getName()), "Unable to create a new instance");
  }
}
