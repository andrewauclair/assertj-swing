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
package org.assertj.swing.junit.ant;

import static java.lang.Double.parseDouble;
import static java.lang.System.currentTimeMillis;
import static org.apache.tools.ant.taskdefs.optional.junit.XMLConstants.ATTR_TIME;
import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.swing.junit.xml.XmlDocument;
import org.assertj.swing.junit.xml.XmlNode;
import org.junit.jupiter.api.Test;

/**
 * Tests for <code>{@link TestXmlNodeWriter#writeError(XmlNode, Throwable)}</code>.
 * 
 * @author Alex Ruiz
 */
class TestXmlNodeWriter_writeTestExecutionTime_Test extends TestXmlNodeWriter_TestCase {

  @Test
  void should_Add_Test_Execution_Time_As_Attribute() {
    XmlNode root = new XmlDocument().newRoot("root");
    assertThat(writer.writeTestExecutionTime(root, currentTimeMillis() - 3000)).isSameAs(writer);
    double time = parseDouble(root.valueOfAttribute(ATTR_TIME));
    assertThat(time).isGreaterThan(0d);
  }
}
