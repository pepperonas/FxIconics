/*
 * Copyright (c) 2015 Martin Pfeffer
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.pepperonas.fxiconics.helper;

import javafx.scene.paint.Color;

/**
 * @author Martin Pfeffer (pepperonas)
 */
public class ColorConverter {

    public static String toRgbString(Color c) {
        return "rgb(" + to255Int(c.getRed()) + "," + to255Int(c.getGreen()) + "," + to255Int(c.getBlue()) + ")";
    }

    private static int to255Int(double d) {
        return (int) (d * Math.pow(2, 8) - 1);
    }

    public static Color awtToFx(java.awt.Color awtColor) {
        int r = awtColor.getRed();
        int g = awtColor.getGreen();
        int b = awtColor.getBlue();
        int a = awtColor.getAlpha();
        double opacity = a / (Math.pow(2, 8) - 1);
        return javafx.scene.paint.Color.rgb(r, g, b, opacity);
    }

}
