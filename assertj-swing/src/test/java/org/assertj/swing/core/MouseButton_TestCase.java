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

import java.util.Collection;

import static java.awt.event.InputEvent.*;
import static org.assertj.core.util.Lists.newArrayList;
import static org.assertj.swing.core.MouseButton.*;

/**
 * Base test case for {@link MouseButton}.
 * 
 * @author Alex Ruiz
 */
public abstract class MouseButton_TestCase {
  final MouseButton button;
  final int mask;

  public static Collection<Object[]> mouseButtonMasks() {
    return newArrayList(new Object[][] { { LEFT_BUTTON, BUTTON1_MASK }, { MIDDLE_BUTTON, BUTTON2_MASK },
        { RIGHT_BUTTON, BUTTON3_MASK }, });
  }

  public MouseButton_TestCase(MouseButton button, int mask) {
    this.button = button;
    this.mask = mask;
  }
}
