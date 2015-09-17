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

package com.pepperonas.fxiconics.base;

import com.pepperonas.fxiconics.awf.FxFontAwesome;
import com.pepperonas.fxiconics.cmd.FxFontCommunity;
import com.pepperonas.fxiconics.gmd.FxFontGoogleMaterial;
import com.pepperonas.fxiconics.helper.ColorConverter;
import com.pepperonas.fxiconics.met.FxFontMeteoconcs;
import com.pepperonas.fxiconics.oct.FxFontOcticons;

import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Control;
import javafx.scene.paint.Color;

/**
 * @author Martin Pfeffer (pepperonas)
 */
public abstract class BuilderControl extends Control {


    public FxFontBase collection;
    public String icon;
    public int size = 24;
    public Color color = Color.BLACK;
    public String text;
    public int textSize = 12;
    public ContentDisplay contentDisplay = ContentDisplay.RIGHT;

    public FxFontBase getCollection() {
        return collection;
    }

    public void setCollection(FxFontBase collection) {
        this.collection = collection;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ContentDisplay getContentDisplay() {
        return contentDisplay;
    }

    public void setContentDisplay(ContentDisplay contentDisplay) {
        this.contentDisplay = contentDisplay;
    }

    public BuilderControl(FxFontGoogleMaterial.Icons icon) {

        this.collection = new FxFontGoogleMaterial();
        this.icon = icon.toString();
    }

    public BuilderControl(FxFontCommunity.Icons icon) {
        this.collection = new FxFontCommunity();
        this.icon = icon.toString();
    }

    public BuilderControl(FxFontAwesome.Icons icon) {
        this.collection = new FxFontAwesome();
        this.icon = icon.toString();
    }

    public BuilderControl(FxFontOcticons.Icons icon) {
        this.collection = new FxFontOcticons();
        this.icon = icon.toString();
    }

    public BuilderControl(FxFontMeteoconcs.Icons icon) {
        this.collection = new FxFontMeteoconcs();
        this.icon = icon.toString();
    }

    public BuilderControl size(int size) {
        this.size = size;
        return this;
    }

    public BuilderControl color(Color color) {
        this.color = color;
        return this;
    }

    public BuilderControl colorAwt(java.awt.Color color) {
        this.color = ColorConverter.awtToFx(color);
        return this;
    }

    public BuilderControl color(String hex) {
        if (hex.charAt(0) != '#') hex = "#" + hex;
        this.color = Color.web(hex);
        return this;
    }

    public BuilderControl text(String text) {
        this.text = text;
        return this;
    }

    public BuilderControl text(String text, int textSize) {
        this.text = text;
        this.textSize = textSize;
        return this;
    }

    public BuilderControl text(String text, ContentDisplay position) {
        this.text = text;
        this.contentDisplay = position;
        return this;
    }

    public BuilderControl text(String text, int textSize, ContentDisplay position) {
        this.text = text;
        this.textSize = textSize;
        this.contentDisplay = position;
        return this;
    }

    public abstract Control build();


}
