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

import org.assertj.swing.test.ExpectedException;
import org.junit.jupiter.api.Test;

/**
 * Tests for {@link JTextComponentDriver#requireNotEditable(javax.swing.text.JTextComponent)}.
 * 
 * @author Alex Ruiz
 * @author Yvonne Wang
 */
class JTextComponentDriver_requireNotEditable_Test extends JTextComponentDriver_TestCase {
  @Test
  void should_Pass_If_JTextComponent_Is_Not_Editable() {
    makeTextFieldNotEditable();
    driver.requireNotEditable(textField);
  }

  @Test
  void should_Fail_If_JTextComponent_Is_Editable() {
    makeTextFieldEditable();
    ExpectedException.assertContainsMessage(AssertionError.class, () -> driver.requireNotEditable(textField), "property:'editable'", "expected:<[fals]e> but was:<[tru]e>");
  }
}
