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
package org.assertj.swing.core;

import static java.awt.event.InputEvent.CTRL_MASK;
import static java.awt.event.InputEvent.SHIFT_MASK;
import static java.awt.event.KeyEvent.VK_C;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * Tests for {@link KeyPressInfo#keyCode(int)}, {@link KeyPressInfo#modifiers(int...)} {@link KeyPressInfo#keyCode()}
 * and {@link KeyPressInfo#modifiers()}.
 * 
 * @author Alex Ruiz
 */
class KeyPressInfo_keyCode_modifiers_Test {
  @Test
  void should_Create_KeyPressInfo_With_Given_Key_And_Modifiers() {
    KeyPressInfo keyPressInfo = KeyPressInfo.keyCode(VK_C).modifiers(SHIFT_MASK, CTRL_MASK);
    assertThat(keyPressInfo.keyCode()).isEqualTo(VK_C);
    assertThat(keyPressInfo.modifiers()).containsOnly(SHIFT_MASK, CTRL_MASK);
  }

  @Test
  void should_Throw_Error_If_Modifier_Array_Is_Null() {
    int[] modifiers = null;
    assertThrows(IllegalArgumentException.class, () -> KeyPressInfo.keyCode(VK_C).modifiers(modifiers));
  }
}
