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

import org.assertj.swing.annotation.RunsInEDT;
import org.assertj.swing.test.core.RobotBasedTestCase;
import org.assertj.swing.test.swing.TestWindow;

import javax.swing.*;
import java.awt.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.swing.edt.GuiActionRunner.execute;
import static org.assertj.swing.test.task.ComponentSetEnabledTask.disable;

/**
 * Base test case for {@link JTabbedPaneDriver}.
 * 
 * @author Alex Ruiz
 * @author Yvonne Wang
 * @author William Bakker
 */
public abstract class JTabbedPaneDriver_TestCase extends RobotBasedTestCase {
  JTabbedPaneDriver driver;
  MyWindow window;
  JTabbedPane tabbedPane;

  @Override
  protected final void onSetUp() {
    driver = new JTabbedPaneDriver(robot);
    window = MyWindow.createNew(getClass());
    tabbedPane = window.tabbedPane;
  }

  final void showWindow() {
    robot.showWindow(window);
  }

  @RunsInEDT
  final void disableTabbedPane() {
    disable(tabbedPane);
    robot.waitForIdle();
  }

  static Object[][] tabIndices() {
    return new Object[][] { { 0 }, { 1 } };
  }

  @RunsInEDT
  final void assertThatSelectedTabIndexIs(int expected) {
    int selectedIndex = selectedIndexIn(tabbedPane);
    assertThat(selectedIndex).isEqualTo(expected);
  }

  @RunsInEDT
  private static int selectedIndexIn(final JTabbedPane tabbedPane) {
    return execute(() -> tabbedPane.getSelectedIndex());
  }

  private static class MyWindow extends TestWindow {
    final JTabbedPane tabbedPane = new JTabbedPane();

    @RunsInEDT
    static MyWindow createNew(final Class<?> testClass) {
      return execute(() -> new MyWindow(testClass));
    }

    private MyWindow(Class<?> testClass) {
      super(testClass);
      tabbedPane.addTab("One", null, panelWithName("panel1"), "tip1");
      tabbedPane.addTab("Two", null, panelWithName("panel2"), "tip2");
      tabbedPane.addTab("Three", null, panelWithName("panel3"), "tip3");
      tabbedPane.setEnabledAt(tabbedPane.indexOfTab("Three"), false);
      add(tabbedPane);
      setPreferredSize(new Dimension(100, 100));
    }

    private JPanel panelWithName(String name) {
      JPanel panel = new JPanel();
      panel.setName(name);
      return panel;
    }
  }
}
