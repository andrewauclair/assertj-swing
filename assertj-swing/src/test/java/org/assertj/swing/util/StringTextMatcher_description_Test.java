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
package org.assertj.swing.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link StringTextMatcher#description()}.
 * 
 * @author Alex Ruiz
 */
class StringTextMatcher_description_Test {
  @Test
  void should_Return_Value_Word_As_Description_If_Matcher_Has_Only_One_Value() {
    StringTextMatcher matcher = new StringTextMatcher("one");
    assertThat(matcher.description()).isEqualTo("value");
  }

  @Test
  void should_Return_Values_Word_As_Description_If_Matcher_Has_More_Than_One_Value() {
    StringTextMatcher matcher = new StringTextMatcher("one", "two");
    assertThat(matcher.description()).isEqualTo("values");
  }
}
