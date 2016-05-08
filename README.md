##EffectiveShapeView
------
A fast，flexible，lightweight(under 400 code line) ImageView that supports rounded corners，circles，polygon.This is based on [RoundedImageView from Vince Mi](https://github.com/vinc3m1/RoundedImageView).
![Alt text](./1878785256.jpg)
![Alt text](./1969793156.jpg)

Also has support for: 
- anti-aliased 
- Borders (with Colors)
- Hardware acceleration
- Decorations (with Direction)

###Gradle
------
>dependencies {
    ...
}

###Usage
------
><tangxiaolv.com.library.EffectiveShapeView
        android:id="@+id/shape"
        android:layout_width="72dp"
        android:layout_height="72dp"
        android:layout_marginLeft="72dp"
        android:layout_marginTop="16dp"
        android:layout_toRightOf="@id/container"
        android:background="#000000"
        android:scaleType="centerCrop"
        android:src="@drawable/android"
        app:shape="polygon"
        app:sides="6"/>
###Changelog
------
**1.0.0**
- Initial release 

###License
------
>Copyright 2016 - 2017 tangxiaolv
	  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at
 
      http://www.apache.org/licenses/LICENSE-2.0
 
  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
