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
package org.assertj.swing.image;

import org.assertj.swing.annotation.RunsInEDT;
import org.assertj.swing.test.core.SequentialEDTSafeTestCase;
import org.assertj.swing.test.swing.TestWindow;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.assertj.swing.edt.GuiActionRunner.execute;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test case for <a href="http://code.google.com/p/fest/issues/detail?id=213">Bug 213</a>.
 *
 * @author Alex Ruiz
 */
public class Bug213_HideCaretInTextFieldWhenTakingScreenshot_Test extends SequentialEDTSafeTestCase {
  private ScreenshotTaker screenshotTaker;
  private MyWindow window;

  @Override
  protected void onSetUp() {
    screenshotTaker = new ScreenshotTaker();
    window = MyWindow.createAndShow();
  }

  @Override
  protected void onTearDown() {
    window.destroy();
  }

  @Test
  @Disabled("Fails on windows 10 because the window is still opening when it tries to take the screenshots")
  void should_Hide_Caret_In_JTextField_When_Taking_Screenshot() {
    BufferedImage currentImage = screenshotTaker.takeScreenshotOf(window);
    for (int i = 0; i < 100; i++) {
      BufferedImage newImage = screenshotTaker.takeScreenshotOf(window);
//      assertThat(newImage).isEqualTo(currentImage);
      assertTrue(bufferedImagesEqual(currentImage, newImage));
    }
  }

  boolean bufferedImagesEqual(BufferedImage img1, BufferedImage img2) {
    File out1 = new File("save1.png");
    File out2 = new File("save2.png");
    int height = img1.getHeight();
    int width = img1.getWidth();
    if (img1.getWidth() == img2.getWidth() && img1.getHeight() == img2.getHeight()) {
      for (int x = 0; x < img1.getWidth(); x++) {
        for (int y = 0; y < img1.getHeight(); y++) {
          int rgb1 = img1.getRGB(x, y);
          int rgb2 = img2.getRGB(x, y);
          if (img1.getRGB(x, y) != img2.getRGB(x, y))

          {
            try {
              ImageIO.write(img1, "png", out1);
            ImageIO.write(img2, "png", out2);

            System.out.println("Wrote to : " + out1.getAbsolutePath());
            } catch (IOException e) {
              e.printStackTrace();
            }
          }

            return false;
        }
      }
    } else {
      return false;
    }
    return true;
  }

  private static class MyWindow extends TestWindow {
    @RunsInEDT
    static MyWindow createAndShow() {
      return execute(() -> display(new MyWindow()));
    }

    final JTextField textField = new JTextField(20);
    final JButton button = new JButton("Hello");

    private MyWindow() {
      super(Bug213_HideCaretInTextFieldWhenTakingScreenshot_Test.class);
      addComponents(textField, button);
    }
  }
}
