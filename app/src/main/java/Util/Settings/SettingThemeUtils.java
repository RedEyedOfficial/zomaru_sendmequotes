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

import zomaru.sendmequotes.R;

// Settings theme changing utility

public class SettingThemeUtils {
    private static int Theme;
    public static final int LIGHT_THEME = 1;
    public static final int DARK_THEME = 2;
    public static final int BLACK_THEME = 3;
    public static final int AKAME_THEME = 4;
    public static final int ZERO_TWO_THEME = 5;
    public static final int METHODE_THEME = 6;
    public static final int MARY_THEME = 7;
    public static final int INDONESIA_THEME = 8;

    public static void setTheme(Activity activity, int teme) {
        Theme = teme;
        activity.finish();
        activity.startActivity(new Intent(activity, activity.getClass()));
    }

    public static void activityApplyTheme (Activity activity) {
        switch (Theme) {
            default:
            case LIGHT_THEME:
                activity.setTheme(R.style.light_theme);
                break;
            case DARK_THEME:
                activity.setTheme(R.style.dark_theme);
                break;
            case BLACK_THEME:
                activity.setTheme(R.style.black_theme);
                break;
            case AKAME_THEME:
                activity.setTheme(R.style.akame_theme);
                break;
            case ZERO_TWO_THEME:
                activity.setTheme(R.style.zero_two_theme);
                break;
            case METHODE_THEME:
                activity.setTheme(R.style.methode_theme);
                break;
            case MARY_THEME:
                activity.setTheme(R.style.mary_theme);
                break;
            case INDONESIA_THEME:
                activity.setTheme(R.style.indonesia_theme);
                break;
        }
    }
}
