/**
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 * <p>
 * Copyright 2012-2015 the original author or authors.
 */
package org.assertj.swing.applet;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static javax.swing.SwingUtilities.getAncestorOfClass;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Tests for {@link AppletViewer#newViewer(java.applet.Applet)}.
 *
 * @author Alex Ruiz
 */
class AppletViewer_newViewerWithApplet_Test extends AppletViewer_TestCase {
    @Test
    void should_Throw_Error_If_Applet_Is_Null() {
        assertThrows(IllegalArgumentException.class, () -> AppletViewer.newViewer(null));
    }

    @Test
    void should_Load_Applet_When_Created() {
        assertThatAppletIsShowingAndViewerIsLoaded();
        Container ancestor = getAncestorOfClass(AppletViewer.class, applet);
        assertThat(ancestor).isSameAs(viewer);
        fixture.label("status").requireText("Applet loaded");
        assertThat(viewer.getApplet()).isSameAs(applet);
        assertThat(viewer.getAppletStub()).isInstanceOf(BasicAppletStub.class);
    }
}
