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
import com.pepperonas.fxiconics.MaterialColor;
import com.pepperonas.fxiconics.awf.FxFontAwesome;
import com.pepperonas.fxiconics.cmd.FxFontCommunity;
import com.pepperonas.fxiconics.gmd.FxFontGoogleMaterial;
import com.pepperonas.fxiconics.met.FxFontMeteoconcs;
import com.pepperonas.fxiconics.oct.FxFontOcticons;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.control.Tooltip;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author Martin Pfeffer (pepperonas)
 */
public class FxIconicsShowcase extends Application {

    private double tabPaneWidth;
    private int fontSize = 24;
    private int lastSelectedTab = 0;
    private long lastSliderChange;
    private boolean hadClicked = false;
    private TabPane tabPane;
    private String searchFilter = "";


    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println(FxIconics.getVersionName());

        Parent root = FXMLLoader.load(getClass().getResource("showroom.fxml"));
        primaryStage.setTitle("FxIconics");
        primaryStage.setScene(new Scene(root, 500, 500));
        primaryStage.show();

        Text t_fontsize = (Text) root.lookup("#t_fontsize");
        t_fontsize.setText("");

        tabPane = (TabPane) root.lookup("#tabpane");
        tabPaneWidth = tabPane.getWidth();
        tabPane.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            lastSelectedTab = (int) newValue;
            loadTabContent(tabPane, (Integer) newValue);
        });

        tabPane.widthProperty().addListener((observable, oldValue, newValue) -> {
            tabPaneWidth = (double) newValue;
        });
        loadTabContent(tabPane, 0);

        Slider sliderSize = (Slider) root.lookup("#slider_size");
        sliderSize.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (lastSliderChange + 100 < System.currentTimeMillis()) {
                lastSliderChange = System.currentTimeMillis();
                fontSize = newValue.intValue();
                t_fontsize.setText("Font size: " + fontSize);
                loadTabContent(tabPane, lastSelectedTab);
            }
        });
        sliderSize.setValue(24);

        primaryStage.widthProperty().addListener((observable, oldValue, newValue) -> {
            loadTabContent(tabPane, lastSelectedTab);
        });


        TextField tf_search = (TextField) root.lookup("#tf_search");
        tf_search.textProperty().addListener((observable, oldValue, newValue) -> {
            searchFilter = newValue;
            System.out.println(searchFilter);
            loadTabContent(tabPane, lastSelectedTab);
        });

        ToolBar toolBar = (ToolBar) root.lookup("#toolbar");

        FxIconicsButton btn_reset =
                (FxIconicsButton) new FxIconicsButton
                        .Builder(FxFontGoogleMaterial.Icons.gmd_highlight_off)
                        .size(18)
                        .text("Reset", 12)
                        .color(MaterialColor.GREY_700).build();
        btn_reset.setOnAction(event -> tf_search.setText(""));

        FxIconicsButton btn_demo =
                (FxIconicsButton) new FxIconicsButton
                        .Builder(FxFontCommunity.Icons.cmd_codepen)
                        .size(18)
                        .text("Demo", 12)
                        .color(MaterialColor.GREY_700).build();
        btn_demo.setOnAction(event -> new DialogPlayGround());

        toolBar.getItems().addAll(btn_reset, btn_demo);
    }


    private void loadTabContent(TabPane tabPane, int selected) {
        VBox vBox = new VBox(3);
        HBox hBox = null;

        Font font = null;
        int ctr = 0;
        switch (selected) {
            case 0: font = FxIconics.getGoogleMaterialFont(getFontSize());
                ctr = FxFontGoogleMaterial.Icons.values().length;
                break;
            case 1: font = FxIconics.getCommunityMaterialFont(getFontSize());
                ctr = FxFontCommunity.Icons.values().length;
                break;
            case 2: font = FxIconics.getAwesomeFont(getFontSize());
                ctr = FxFontAwesome.Icons.values().length;
                break;
            case 3: font = FxIconics.getOcticonsFont(getFontSize());
                ctr = FxFontOcticons.Icons.values().length;
                break;
            case 4: font = FxIconics.getMeteoconsFont(getFontSize());
                ctr = FxFontMeteoconcs.Icons.values().length;
                break;
        }

        for (int i = 0; i < ctr; i++) {
            Label label = new Label();
            label.setFont(font);

            final int finalI = i;
            switch (selected) {
                // hover listener keeps ui responsive
                case 0:
                    if (!searchFilter.isEmpty()) {
                        if (FxFontGoogleMaterial.Icons.values()[i].name().toLowerCase().toLowerCase().contains(searchFilter)) {
                            label.setText(FxFontGoogleMaterial.Icons.values()[i].toString());
                        } else continue;
                    }
                    label.setText(FxFontGoogleMaterial.Icons.values()[i].toString());
                    System.out.println(FxFontGoogleMaterial.Icons.values()[i].name());
                    label.hoverProperty().addListener((observable, oldValue, newValue) -> {
                        if (newValue) {
                            Tooltip tt = new Tooltip(FxFontGoogleMaterial.Icons.values()[finalI].name());
                            label.setTooltip(tt);
                            label.setOnMouseClicked(
                                    event -> {
                                        copyToClipboard(FxFontGoogleMaterial.Icons.values()[finalI].name());
                                        addContextMenuToLabel(label);
                                    });
                        }
                    });
                    break;
                case 1:
                    if (!searchFilter.isEmpty()) {
                        if (FxFontCommunity.Icons.values()[i].name().toLowerCase().toLowerCase().contains(searchFilter)) {
                            label.setText(FxFontCommunity.Icons.values()[i].toString());
                        } else continue;
                    }
                    label.setText(FxFontCommunity.Icons.values()[i].toString());
                    label.hoverProperty().addListener((observable, oldValue, newValue) -> {
                        if (newValue) {
                            Tooltip tt = new Tooltip(FxFontCommunity.Icons.values()[finalI].name());
                            label.setTooltip(tt);
                            label.setOnMouseClicked(
                                    event -> {
                                        copyToClipboard(FxFontCommunity.Icons.values()[finalI].name());
                                        addContextMenuToLabel(label);
                                    });
                        }
                    });
                    break;
                case 2:
                    if (!searchFilter.isEmpty()) {
                        if (FxFontAwesome.Icons.values()[i].name().toLowerCase().toLowerCase().contains(searchFilter)) {
                            label.setText(FxFontAwesome.Icons.values()[i].toString());
                        } else continue;
                    }
                    label.setText(FxFontAwesome.Icons.values()[i].toString());
                    label.hoverProperty().addListener((observable, oldValue, newValue) -> {
                        if (newValue) {
                            Tooltip tt = new Tooltip(FxFontAwesome.Icons.values()[finalI].name());
                            label.setTooltip(tt);
                            label.setOnMouseClicked(
                                    event -> {
                                        copyToClipboard(FxFontAwesome.Icons.values()[finalI].name());
                                        addContextMenuToLabel(label);
                                    });
                        }
                    });
                    break;
                case 3:
                    if (!searchFilter.isEmpty()) {
                        if (FxFontOcticons.Icons.values()[i].name().toLowerCase().toLowerCase().contains(searchFilter)) {
                            label.setText(FxFontOcticons.Icons.values()[i].toString());
                        } else continue;
                    }
                    label.setText(FxFontOcticons.Icons.values()[i].toString());
                    label.hoverProperty().addListener((observable, oldValue, newValue) -> {
                        if (newValue) {
                            Tooltip tt = new Tooltip(FxFontOcticons.Icons.values()[finalI].name());
                            label.setTooltip(tt);
                            label.setOnMouseClicked(
                                    event -> {
                                        copyToClipboard(FxFontOcticons.Icons.values()[finalI].name());
                                        addContextMenuToLabel(label);
                                    });
                        }
                    });
                    break;
                case 4:
                    if (!searchFilter.isEmpty()) {
                        if (FxFontMeteoconcs.Icons.values()[i].name().toLowerCase().toLowerCase().contains(searchFilter)) {
                            label.setText(FxFontMeteoconcs.Icons.values()[i].toString());
                        } else continue;
                    }
                    label.setText(FxFontMeteoconcs.Icons.values()[i].toString());
                    label.hoverProperty().addListener((observable, oldValue, newValue) -> {
                        if (newValue) {
                            Tooltip tt = new Tooltip(FxFontMeteoconcs.Icons.values()[finalI].name());
                            label.setTooltip(tt);
                            label.setOnMouseClicked(
                                    event -> {
                                        copyToClipboard(FxFontMeteoconcs.Icons.values()[finalI].name());
                                        addContextMenuToLabel(label);
                                    });
                        }
                    });
                    break;
            }
            label.setStyle("-fx-cursor: hand;");
            if (!hadClicked) {
                label.hoverProperty().addListener((observable, oldValue, newValue) -> {
                    if (newValue) {
                        Tooltip tt = new Tooltip("copy (click left)\n" +
                                                 "change color (click right)");
                        label.setTooltip(tt);
                    }
                });
            }

            if (i % calculateItemsPerRow() == 0) {
                hBox = new HBox(3);
                // center the notes
                hBox.setAlignment(Pos.CENTER);
                hBox.getChildren().add(label);
                vBox.getChildren().add(hBox);
            } else {
                if (hBox != null && hBox.getChildren().size() != 0) {
                    hBox.getChildren().add(label);
                }
            }
        }

        Tab tab = tabPane.getTabs().get(selected);
        ScrollPane scrollPane = (ScrollPane) tab.getContent();
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        scrollPane.setContent(vBox);
    }


    private void addContextMenuToLabel(Label label) {
        MenuItem miBlack = new MenuItem("black");
        MenuItem miRed = new MenuItem("red");
        MenuItem miYellow = new MenuItem("yellow");
        MenuItem miGreen = new MenuItem("green");
        MenuItem miBlue = new MenuItem("blue");
        MenuItem miOrange = new MenuItem("orange");
        MenuItem miPurple = new MenuItem("purple");
        MenuItem miPink = new MenuItem("pink");
        MenuItem miGrey = new MenuItem("grey");
        miBlack.setOnAction(event1 -> label.setStyle("-fx-text-fill: black; -fx-cursor: hand;"));
        miRed.setOnAction(event1 -> label.setStyle("-fx-text-fill: red; -fx-cursor: hand"));
        miYellow.setOnAction(event1 -> label.setStyle("-fx-text-fill: yellow; -fx-cursor: hand"));
        miGreen.setOnAction(event1 -> label.setStyle("-fx-text-fill: green; -fx-cursor: hand"));
        miBlue.setOnAction(event1 -> label.setStyle("-fx-text-fill: blue; -fx-cursor: hand"));
        miOrange.setOnAction(event1 -> label.setStyle("-fx-text-fill: orange; -fx-cursor: hand"));
        miPurple.setOnAction(event1 -> label.setStyle("-fx-text-fill: purple; -fx-cursor: hand"));
        miPink.setOnAction(event1 -> label.setStyle("-fx-text-fill: deeppink; -fx-cursor: hand"));
        miGrey.setOnAction(event1 -> label.setStyle("-fx-text-fill: grey; -fx-cursor: hand"));

        ContextMenu ctm = new ContextMenu();
        ctm.getItems().addAll(miBlack, miRed, miYellow, miGreen, miBlue, miOrange, miPurple, miPink, miGrey);
        label.setContextMenu(ctm);
    }


    private int calculateItemsPerRow() {
        return /*tabPaneWidth == 0 ? (5) : ((int) */(int) (tabPaneWidth / (getFontSize() * 1.5d));
    }


    public static void main(String[] args) {
        launch(args);
    }


    public int getFontSize() {
        return fontSize;
    }


    public void copyToClipboard(String text) {
        if (!hadClicked) {
            hadClicked = true;
            loadTabContent(tabPane, lastSelectedTab);
        }

        final Clipboard clipboard = Clipboard.getSystemClipboard();
        final ClipboardContent content = new ClipboardContent();
        content.putString(text);
        clipboard.setContent(content);
    }

}
