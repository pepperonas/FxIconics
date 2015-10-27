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

package com.pepperonas;

import com.pepperonas.fxiconics.FxIconics;
import com.pepperonas.fxiconics.FxIconicsButton;
import com.pepperonas.fxiconics.FxIconicsLabel;
import com.pepperonas.fxiconics.MaterialColor;
import com.pepperonas.fxiconics.cmd.FxFontCommunity;
import com.pepperonas.fxiconics.gmd.FxFontGoogleMaterial;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * @author Martin Pfeffer (pepperonas)
 */
public class DialogPlayGround {

    private static final double SPACING_VBOX = 18;
    private static final int LABEL_TEXT_SIZE = 18;
    private static final String LABEL_CSS = "-fx-font-size: " + LABEL_TEXT_SIZE + "pt;" +
                                            "-fx-font-weight: bold;";


    public DialogPlayGround() {
        Stage dialog = new Stage(StageStyle.UTILITY);

        HBox hbox = new HBox(40);
        VBox vBox0 = new VBox(SPACING_VBOX);
        VBox vBox1 = new VBox(SPACING_VBOX);
        VBox vBox2 = new VBox(SPACING_VBOX);
        VBox vBox3 = new VBox(SPACING_VBOX);

        hbox.getChildren().addAll(vBox0, vBox1, vBox2, vBox3);

        hbox.setAlignment(Pos.CENTER);
        vBox0.setAlignment(Pos.CENTER);
        vBox1.setAlignment(Pos.CENTER);
        vBox2.setAlignment(Pos.CENTER);
        vBox3.setAlignment(Pos.CENTER);

        initFxIconicsLabel(vBox0);
        initFxIconicsButton(vBox1);
        initFxIconicsLabelText(vBox2);
        initFxIconicsButtonText(vBox3);

        Scene scene = new Scene(hbox, 1000, 600);
        dialog.setScene(scene);
        dialog.show();

    }


    private void initFxIconicsLabel(VBox box) {
        Label l_fx_iconics_label = new Label("FxIconicsLabel");
        l_fx_iconics_label.setStyle(LABEL_CSS);

        FxIconicsLabel labelDefault =
                (FxIconicsLabel) new FxIconicsLabel.Builder(FxIconics.findGmdFont("gmd_folder_special"))
                        .size(24)
                        .color(MaterialColor.INDIGO_500)
                        .build();

        FxIconicsLabel labelColored =
                (FxIconicsLabel) new FxIconicsLabel.Builder(FxFontCommunity.Icons.cmd_xml)
                        .size(24)
                        .color(MaterialColor.INDIGO_500)
                        .build();

        FxIconicsLabel labelResized =
                (FxIconicsLabel) new FxIconicsLabel.Builder(FxFontCommunity.Icons.cmd_leaf)
                        .size(36)
                        .color(MaterialColor.INDIGO_500)
                        .build();

        box.getChildren().addAll(l_fx_iconics_label, labelDefault, labelColored, labelResized);
    }


    private void initFxIconicsButton(VBox box) {
        Label l_fx_iconics_button = new Label("FxIconicsButton");
        l_fx_iconics_button.setStyle(LABEL_CSS);

        FxIconicsButton btnDefault =
                (FxIconicsButton) new FxIconicsButton.Builder(FxFontGoogleMaterial.Icons.gmd_folder_special)
                        .size(24)
                        .color(MaterialColor.PINK_500)
                        .build();

        FxIconicsButton btnColored =
                (FxIconicsButton) new FxIconicsButton.Builder(FxFontCommunity.Icons.cmd_xml)
                        .size(24)
                        .color(MaterialColor.PINK_500)
                        .build();

        FxIconicsButton btnResized =
                (FxIconicsButton) new FxIconicsButton.Builder(FxFontCommunity.Icons.cmd_leaf)
                        .size(36)
                        .color(MaterialColor.PINK_500)
                        .build();

        box.getChildren().addAll(l_fx_iconics_button, btnDefault, btnColored, btnResized);
    }


    private void initFxIconicsLabelText(VBox box) {
        Label l_fx_iconics_label_text = new Label("FxIconicsLabel (Text)");
        l_fx_iconics_label_text.setStyle(LABEL_CSS);

        FxIconicsLabel labelTextDefault =
                (FxIconicsLabel) new FxIconicsLabel.Builder(FxFontGoogleMaterial.Icons.gmd_folder_special)
                        .size(24)
                        .text("Right (default)")
                        .color(MaterialColor.ORANGE_500)
                        .build();

        FxIconicsLabel labelTextLeft =
                (FxIconicsLabel) new FxIconicsLabel.Builder(FxFontCommunity.Icons.cmd_xml)
                        .size(24)
                        .text("Left", ContentDisplay.LEFT)
                        .color(MaterialColor.ORANGE_500)
                        .build();

        FxIconicsLabel labelTextTop =
                (FxIconicsLabel) new FxIconicsLabel.Builder(FxFontCommunity.Icons.cmd_leaf)
                        .size(36)
                        .text("Top", ContentDisplay.TOP)
                        .color(MaterialColor.ORANGE_500)
                        .build();

        FxIconicsLabel labelTextBottom =
                (FxIconicsLabel) new FxIconicsLabel.Builder(FxFontCommunity.Icons.cmd_contrast)
                        .size(36)
                        .text("Bottom", ContentDisplay.BOTTOM)
                        .color(MaterialColor.ORANGE_500)
                        .build();

        box.getChildren().addAll(l_fx_iconics_label_text, labelTextDefault, labelTextLeft, labelTextTop, labelTextBottom);
    }


    private void initFxIconicsButtonText(VBox box) {
        Label l_fx_iconics_button_text = new Label("FxIconicsButton (Text)");
        l_fx_iconics_button_text.setStyle(LABEL_CSS);

        FxIconicsButton btnTextDefault =
                (FxIconicsButton) new FxIconicsButton.Builder(FxFontGoogleMaterial.Icons.gmd_folder_special)
                        .size(24)
                        .text("Right (default)")
                        .color(MaterialColor.TEAL_500)
                        .build();

        FxIconicsButton btnTextLeft =
                (FxIconicsButton) new FxIconicsButton.Builder(FxFontCommunity.Icons.cmd_xml)
                        .size(24)
                        .text("Left", ContentDisplay.LEFT)
                        .color(MaterialColor.TEAL_500)
                        .build();

        FxIconicsButton btnTextTop =
                (FxIconicsButton) new FxIconicsButton.Builder(FxFontCommunity.Icons.cmd_leaf)
                        .size(36)
                        .text("Top", ContentDisplay.TOP)
                        .color(MaterialColor.TEAL_500)
                        .build();

        FxIconicsButton btnTextBottom =
                (FxIconicsButton) new FxIconicsButton.Builder(FxFontCommunity.Icons.cmd_contrast)
                        .size(36)
                        .text("Bottom", ContentDisplay.BOTTOM)
                        .color(MaterialColor.TEAL_500)
                        .build();

        box.getChildren().addAll(l_fx_iconics_button_text, btnTextDefault, btnTextLeft, btnTextTop, btnTextBottom);
    }

}
