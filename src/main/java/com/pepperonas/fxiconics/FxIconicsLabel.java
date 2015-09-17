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
import com.pepperonas.fxiconics.base.BuilderControl;
import com.pepperonas.fxiconics.cmd.FxFontCommunity;
import com.pepperonas.fxiconics.gmd.FxFontGoogleMaterial;
import com.pepperonas.fxiconics.helper.ColorConverter;
import com.pepperonas.fxiconics.met.FxFontMeteoconcs;
import com.pepperonas.fxiconics.oct.FxFontOcticons;

import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * @author Martin Pfeffer (pepperonas)
 */
public class FxIconicsLabel extends Label {

    public FxIconicsLabel(BuilderControl builder) {

        Font font = null;

        if (builder.collection instanceof FxFontGoogleMaterial) {
            font = FxIconics.getGoogleMaterialFont(builder.size);
        }
        if (builder.collection instanceof FxFontCommunity) {
            font = FxIconics.getCommunityMaterialFont(builder.size);
        }
        if (builder.collection instanceof FxFontAwesome) {
            font = FxIconics.getAwesomeFont(builder.size);
        }
        if (builder.collection instanceof FxFontOcticons) {
            font = FxIconics.getOcticonsFont(builder.size);
        }
        if (builder.collection instanceof FxFontMeteoconcs) {
            font = FxIconics.getMeteoconsFont(builder.size);
        }

        this.setText(builder.icon);
        this.setFont(font);
        if (builder.text != null && !builder.text.isEmpty()) {
            Text text = new Text(builder.text);
            text.setStyle("-fx-font-size: " + builder.textSize);
            this.setText(builder.icon);
            this.setGraphic(text);
            this.setContentDisplay(builder.contentDisplay);
        }
        this.setStyle("-fx-text-fill: " + ColorConverter.toRgbString(builder.color) + "");
    }


    public static class Builder extends BuilderControl {

        public Builder(FxFontGoogleMaterial.Icons icon) {
            super(icon);
        }

        public Builder(FxFontCommunity.Icons icon) {
            super(icon);
        }

        public Builder(FxFontAwesome.Icons icon) {
            super(icon);
        }

        public Builder(FxFontOcticons.Icons icon) {
            super(icon);
        }

        public Builder(FxFontMeteoconcs.Icons icon) {
            super(icon);
        }

        public FxIconicsLabel build() {
            return new FxIconicsLabel(this);
        }
    }

}
