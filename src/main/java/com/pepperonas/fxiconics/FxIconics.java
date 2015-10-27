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

package com.pepperonas.fxiconics;

import com.pepperonas.fxiconics.awf.FxFontAwesome;
import com.pepperonas.fxiconics.cmd.FxFontCommunity;
import com.pepperonas.fxiconics.gmd.FxFontGoogleMaterial;
import com.pepperonas.fxiconics.met.FxFontMeteoconcs;
import com.pepperonas.fxiconics.oct.FxFontOcticons;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javafx.scene.text.Font;

/**
 * @author Martin Pfeffer (pepperonas)
 */
public class FxIconics {

    public static Font getGoogleMaterialFont() {
        return Font.loadFont(FxIconics.class.getResource("google_material_design.ttf").toExternalForm(), 24);
    }


    public static Font getCommunityMaterialFont() {
        return Font.loadFont(FxIconics.class.getResource("materialdesignicons-webfont.ttf").toExternalForm(), 24);
    }


    public static Font getAwesomeFont() {
        return Font.loadFont(FxIconics.class.getResource("fontawesome-webfont-4.3.0.ttf").toExternalForm(), 24);
    }


    public static Font getOcticonsFont() {
        return Font.loadFont(FxIconics.class.getResource("octicons.ttf").toExternalForm(), 24);
    }


    public static Font getMeteoconsFont() {
        return Font.loadFont(FxIconics.class.getResource("meteocons.ttf").toExternalForm(), 24);
    }


    public static Font getGoogleMaterialFont(int fontSize) {
        return Font.loadFont(FxIconics.class.getResource("google_material_design.ttf").toExternalForm(), fontSize);
    }


    public static Font getCommunityMaterialFont(int fontSize) {
        return Font.loadFont(FxIconics.class.getResource("materialdesignicons-webfont.ttf").toExternalForm(), fontSize);
    }


    public static Font getAwesomeFont(int fontSize) {
        return Font.loadFont(FxIconics.class.getResource("fontawesome-webfont-4.3.0.ttf").toExternalForm(), fontSize);
    }


    public static Font getOcticonsFont(int fontSize) {
        return Font.loadFont(FxIconics.class.getResource("octicons.ttf").toExternalForm(), fontSize);
    }


    public static Font getMeteoconsFont(int fontSize) {
        return Font.loadFont(FxIconics.class.getResource("meteocons.ttf").toExternalForm(), fontSize);
    }


    public static String getLibraryName() {
        Properties prop = getProp();
        return prop.getProperty("libraryName");
    }


    public static String getVersionName() {
        Properties prop = getProp();
        return prop.getProperty("versionName");
    }


    private static Properties getProp() {
        Properties prop = new Properties();
        String propFileName = "lib.properties";
        InputStream inputStream = FxIconics.class.getClassLoader().getResourceAsStream(propFileName);
        try {
            prop.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }


    public static FxFontAwesome.Icons findAweFont(String font) {
        try {
            return FxFontAwesome.Icons.valueOf(font);
        } catch (IllegalArgumentException e) {
            System.out.println("Font not found.");
        }
        return null;
    }


    public static FxFontGoogleMaterial.Icons findGmdFont(String font) {
        try {
            return FxFontGoogleMaterial.Icons.valueOf(font);
        } catch (IllegalArgumentException e) {
            System.out.println("Font not found.");
        }
        return null;
    }


    public static FxFontCommunity.Icons findCmdFont(String font) {
        try {
            return FxFontCommunity.Icons.valueOf(font);
        } catch (IllegalArgumentException e) {
            System.out.println("Font not found.");
        }
        return null;
    }


    public static FxFontOcticons.Icons findOctFont(String font) {
        try {
            return FxFontOcticons.Icons.valueOf(font);
        } catch (IllegalArgumentException e) {
            System.out.println("Font not found.");
        }
        return null;
    }


    public static FxFontMeteoconcs.Icons findMetFont(String font) {
        try {
            return FxFontMeteoconcs.Icons.valueOf(font);
        } catch (IllegalArgumentException e) {
            System.out.println("Font not found.");
        }
        return null;
    }

}
