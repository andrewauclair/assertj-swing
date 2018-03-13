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

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link JAppletDriver#getParameter(javax.swing.JApplet, String)}.
 * 
 * @author Alex Ruiz
 */
class JAppletDriver_getParameter_Test extends JAppletDriver_TestCase {
  @Test
  void should_Retrieve_Parameter_Value() {
    applet().addParameter("firstName", "Luke");
    String value = driver().getParameter(applet(), "firstName");
    assertThat(value).isEqualTo("Luke");
    assertThat(applet().wasMethodCalledInEDT("getParameter('firstName')")).isTrue();
  }
}
