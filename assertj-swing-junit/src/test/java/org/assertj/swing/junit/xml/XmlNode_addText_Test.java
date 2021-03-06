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
package org.assertj.swing.junit.xml;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

/**
 * Tests for <code>{@link XmlNode#addCdata(String)}</code>.
 * 
 * @author Alex Ruiz
 */
class XmlNode_addText_Test extends XmlNode_TestCase {

  @Test
  void should_Add_Text_Node() {
    node.addText("Hello World");
    assertThat(childNodeCountOf(target)).isEqualTo(1);
    Node child = target.getFirstChild();
    assertThat(child).isInstanceOf(Text.class);
    assertThat(dataOf(child)).isEqualTo("Hello World");
  }

}
