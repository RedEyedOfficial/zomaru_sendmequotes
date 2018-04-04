/*
 * Copyright (C) 2018 Red Eyed Official
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package Util.Settings;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.widget.ImageView;
import android.widget.Toast;

import zomaru.sendmequotes.MainActivity;
import zomaru.sendmequotes.R;

public class SettingTransitionPickerUtils {
    private static int Wallpaper;
    public static final int MONIKA = 1;
    public static final int ZEROTWO = 2;
    public static final int AKAME = 3;
    public static final int MARY = 4;
    public static final int METHODE = 5;
    public static final int NAO = 6;
    public static Resources resources;
    public static ImageView imageView;
    public static ImageView view;

    public static void setTransition (Activity activity, int tdb) {
        Wallpaper = tdb;
        activity.finish();
        activity.startActivity(new Intent(activity, activity.getClass()));
    }

    public static void applyTransition (Activity activity) {
        imageView = MainActivity.ima1;
        switch (Wallpaper) {
            default:
            case MONIKA:
                MainActivity.ima1.setImageResource(R.drawable.my_dear);
                break;
            case ZEROTWO:
                MainActivity.ima1.setImageResource(R.drawable.zerotwo);
                break;
            case AKAME:
                MainActivity.ima1.setImageResource(R.drawable.akame2);
                break;
            case MARY:
                MainActivity.ima1.setImageResource(R.drawable.mary2);
                break;
            case METHODE:
                MainActivity.ima1.setImageResource(R.drawable.methode);
                break;
            case NAO:
                MainActivity.ima1.setImageResource(R.drawable.nao);
                break;
        }
    }
}
