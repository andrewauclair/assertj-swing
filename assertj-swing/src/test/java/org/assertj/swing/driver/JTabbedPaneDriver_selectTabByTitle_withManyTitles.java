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

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collection;

import static org.assertj.core.util.Lists.newArrayList;

/**
 * Tests for {@link JTabbedPaneDriver#selectTab(javax.swing.JTabbedPane, String)}.
 * 
 * @author Alex Ruiz
 * @author Yvonne Wang
 */
class JTabbedPaneDriver_selectTabByTitle_withManyTitles extends JTabbedPaneDriver_TestCase {
  private static Collection<Object[]> indices() {
    return newArrayList(new Object[][] { { "One", 0 }, { "Two", 1 } });
  }

  @ParameterizedTest
  @MethodSource("indices")
  void should_Select_Tab_With_Equal_Title(String title, int index) {
    showWindow();
    driver.selectTab(tabbedPane, title);
    assertThatSelectedTabIndexIs(index);
  }
}
