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
package org.assertj.swing.test.core;

import org.assertj.swing.lock.ScreenLock;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

/**
 * Base class for test classes that use {@link ScreenLock} to guarantee sequential execution of UI tests.
 * 
 * @author Alex Ruiz
 */
public abstract class SequentialEDTSafeTestCase extends EDTSafeTestCase {
  @BeforeEach
  public final void setUp() {
    ScreenLock.instance().acquire(this);
    onSetUp();
  }

  protected void onSetUp() {
  }

  @AfterEach
  public final void tearDown() {
    try {
      onTearDown();
    } finally {
      ScreenLock.instance().release(this);
    }
  }

  protected void onTearDown() {
  }
}
