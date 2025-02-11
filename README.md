# FxIconics
This project is a JavaFx port of the famous [Android-Iconics](https://github.com/mikepenz/Android-Iconics/) library.


## How to use
### 1. Import
Add `fxiconics-0.0.5-jfx` to your project dependencies.


### 2. Creating a Node
```java
FxIconicsLabel labelDefault =
        (FxIconicsLabel) new FxIconicsLabel.Builder(FxFontGoogleMaterial.Icons.gmd_folder_special)
                .size(24)
                .color(MaterialColor.INDIGO_500)
                .build();
```
or
```java
FxIconicsButton btnDefault =
                (FxIconicsButton) new FxIconicsButton.Builder(FxFontGoogleMaterial.Icons.gmd_folder_special)
                        .size(24)
                        .color(MaterialColor.PINK_500)
                        .build();
```

##Demo
Run `fxiconics-0.0.5-jfx` to get an overview of the containing resources. You may want use this showcase to access the resources more easily. If so, just click an item and the particular icon-name will be clipped to your board. To get a colorized preview click-right an item.
![Image](https://raw.githubusercontent.com/pepperonas/FxIconics/master/img01.png)
![Image](https://raw.githubusercontent.com/pepperonas/FxIconics/master/img02.png)

##Credits
- [Mike Penz](https://github.com/mikepenz/), the Author of [Android-Iconics](https://github.com/mikepenz/Android-Iconics/).
- [Joan Zapata](https://github.com/JoanZapata) for giving Mike Penz the idea to create Android-Iconics.


##Developed By

* Martin Pfeffer - http://www.pepperonas.com - <pepperonas@gmail.com>


##License

    Copyright 2015 Martin Pfeffer

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.


