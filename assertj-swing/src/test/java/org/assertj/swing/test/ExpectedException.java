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
package org.assertj.swing.test;

import org.junit.jupiter.api.function.Executable;

import java.util.regex.Pattern;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Allows in-test specification of expected exception types and messages.
 *
 * @author Alex Ruiz
 */
public class ExpectedException {//implements TestRule {
//  private final org.junit.rules.ExpectedException delegate = org.junit.rules.ExpectedException.none();

  public static ExpectedException none() {
    return new ExpectedException();
  }

  private ExpectedException() {
  }

//  @Override
//  public Statement apply(Statement base, Description description) {
//    return delegate.apply(base, description);
//  }

  public void expectAssertionError(String message) {
    expect(AssertionError.class, message);
  }

  public static void assertAssertionError(Executable executable, String message) {
    assertContainsMessage(AssertionError.class, executable, message);
  }

  private void expectAssertionError(String property, String expected, String actual) {
    expectAssertionErrorForProperty(property, doubleQuote(expected), doubleQuote(actual));
  }

  public static void assertAssertionError(Executable executable, String property, String expected, String actual) {
    assertAssertionErrorForProperty(executable, property, doubleQuote(expected), doubleQuote(actual));
  }

  private void expectAssertionError(String property, int expected, int actual) {
    expectAssertionErrorForProperty(property, quote(expected), quote(actual));
  }

  public static void assertAssertionError(Executable executable, String property, int expected, int actual) {
    assertAssertionErrorForProperty(executable, property, quote(expected), quote(actual));
  }

  private static String quote(int actual) {
    return "[" + actual + "]";
  }

  private static String doubleQuote(String string) {
    return "\"" + string + "\"";
  }

  public void expectAssertionError(String property, String[] expected, String[] actual) {
    expectAssertionErrorForProperty(property, buildStringForMessage(expected), buildStringForMessage(actual));
  }

  public static void assertAssertionError(Executable executable, String property, String[] expected, String[] actual) {
    assertAssertionErrorForProperty(executable, property, buildStringForMessage(expected), buildStringForMessage(actual));
  }

  private void expectAssertionErrorForProperty(String property, String expected, String actual) {
    expect(AssertionError.class);
    expectMessageToContain("property:'" + property + "'");
    expectMessageToContain("expected:<" + expected + ">");
    expectMessageToContain("but was:<" + actual + ">");
  }

  private static void assertAssertionErrorForProperty(Executable executable, String property, String expected, String actual) {
    assertContainsMessage(AssertionError.class, executable, "property:" + property + "'", "expected:<" + expected + ">", "but was:<" + actual + ">");
  }

  public void expectAssertionError(String property, String content, Pattern pattern) {
    expect(AssertionError.class);
    expectMessageToContain("property:'" + property + "'");
    expectMessageToContain("\nExpecting:\n \"" + content + "\"\nto match pattern:\n \"" + pattern.pattern() + "\"");
  }

  public static void assertAssertionError(Executable executable, String property, String content, Pattern pattern) {
    Throwable exception = assertThrows(AssertionError.class, executable);
    assertTrue(exception.getMessage().contains("property:" + property + "'"));
    assertTrue(exception.getMessage().contains("\nExpecting:\n \"" + content + "\"\nto match pattern:\n \"" + pattern.pattern() + "\""));
  }

  private static String buildStringForMessage(String[] array) {
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    for (int i = 0; i < array.length; ++i) {
      sb.append("\"").append(array[i]).append("\"");
      if (i + 1 < array.length) {
        sb.append(", ");
      }
    }
    sb.append("]");
    return sb.toString();
  }

  public void expectNullPointerException(String message) {
    expect(NullPointerException.class, message);
  }

  public void expectIllegalArgumentException(String message) {
    expect(IllegalArgumentException.class, message);
  }

  public void expectIndexOutOfBoundsException(String message) {
    expect(IndexOutOfBoundsException.class, message);
  }

  public void expectUnsupportedOperationException(String message) {
    expect(UnsupportedOperationException.class, message);
  }

  private void expect(Class<? extends Throwable> type, String message) {
    expect(type);
    expectMessage(message);
  }

  private void expect(Throwable error) {
    expect(error.getClass());
    expectMessage(error.getMessage());
  }

  public void expect(Class<? extends Throwable> type) {
//    delegate.expect(type);
  }

  private void expectMessage(String message) {
//    delegate.expectMessage(message);
  }

  public void expectMessageToContain(final String... strings) {
//    delegate.expectMessage(new TypeSafeMatcher<String>() {
//      @Override
//      public void describeTo(org.hamcrest.Description description) {
//        description.appendText("containing: " + Arrays.toString(strings));
//      }
//
//      @Override
//      public boolean matchesSafely(String item) {
//        for (String s : strings) {
//          if (!item.contains(s)) {
//            return false;
//          }
//        }
//        return true;
//      }
//    });
  }

  public void expectMessageNotToContain(final String... strings) {
//    delegate.expectMessage(new TypeSafeMatcher<String>() {
//      @Override
//      public void describeTo(org.hamcrest.Description description) {
//        description.appendText("not containing: " + Arrays.toString(strings));
//      }
//
//      @Override
//      public boolean matchesSafely(String item) {
//        for (String s : strings) {
//          if (item.contains(s)) {
//            return false;
//          }
//        }
//        return true;
//      }
//    });
  }

  public void expectWrappingException(Class<? extends Throwable> type, final Throwable wrapped) {
//    expect(type);
//    delegate.expect(new TypeSafeMatcher<Throwable>() {
//
//      @Override
//      public void describeTo(org.hamcrest.Description description) {
//        description.appendText("cause is: " + wrapped);
//      }
//
//      @Override
//      public boolean matchesSafely(Throwable item) {
//        return item.getCause() == wrapped;
//      }
//    });
  }

  public static void assertIllegalStateIsNotShowingComponent(Executable executable) {
    Throwable exception = assertThrows(IllegalStateException.class, executable);
    assertTrue(exception.getMessage().contains("Expecting component"));
    assertTrue(exception.getMessage().contains("to be showing on the screen"));
  }

  public static void assertIllegalStateIsNotResizableComponent(Executable executable) {
    Throwable exception = assertThrows(IllegalStateException.class, executable);
    assertTrue(exception.getMessage().contains("Expecting component"));
    assertTrue(exception.getMessage().contains("to be resizable by the user"));
  }

  public static void assertIllegalStateIsDisabledComponent(Executable executable) {
    Throwable exception = assertThrows(IllegalStateException.class, executable);
    assertTrue(exception.getMessage().contains("Expecting component"));
    assertTrue(exception.getMessage().contains("to be enabled"));
  }

  public static void assertContainsMessage(Class<? extends Throwable> exceptionClass, Executable executable, String ... messages) {
    Throwable exception = assertThrows(exceptionClass, executable);
    for (String message : messages) {
      assertThat(exception.getMessage()).contains(message);
    }
  }

  public static void assertDoesNotContainMessage(Class<? extends Throwable> exceptionClass, Executable executable, String ... messages) {
    Throwable exception = assertThrows(exceptionClass, executable);
    for (String message : messages) {
      assertThat(exception.getMessage()).doesNotContain(message);
    }
  }
}
