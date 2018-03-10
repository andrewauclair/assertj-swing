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
package org.assertj.swing.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Tests for {@link TableCellInRowByValue#rowWithValue(String...)}.
 * 
 * @author Alex Ruiz
 */
class TableCellInRowByValue_rowWithValue_Test {
  @Test
  void should_Throw_Error_If_Array_Of_Values_Is_Null() {
    assertThrows(IllegalArgumentException.class, () -> {
      String[] values = null;
      TableCellInRowByValue.rowWithValue(values);
    });
  }
}
