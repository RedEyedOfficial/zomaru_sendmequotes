package zomaru.sendmequotes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


/**
 * Created by root on 1/7/18.
 */

public class ThemeSwap {
    private static int Tema;
    public final static int TEMA_BAWAAN = 0;
    public final static int BLAZING_RED = 1;
    public final static int OCEAN_BLUE = 2;
    public final static int MILK_WHITE = 3;
    public final static int LEAFY_GREEN = 4;
    public final static int SOLID_BLACK = 5;
    public final static int BRIGHT_YELLOW = 6;
    public final static int MIX_COCKTAIL = 7;

    public static void applyTheme(Activity activity, int tema) {
        Tema = tema;
        activity.finish();
        activity.startActivity(new Intent(activity, activity.getClass()));
    }

    public static void onActivityCreateSetTheme(Activity activity) {
        switch (Tema) {
            default:
            case TEMA_BAWAAN:
                activity.setTheme(R.style.Theme_AppCompat_Light_DarkActionBar);
                break;
            case BLAZING_RED:
                activity.setTheme(R.style.blazing_red);
                break;
            case OCEAN_BLUE:
                activity.setTheme(R.style.ocean_blue);
                break;
            case MILK_WHITE:
                activity.setTheme(R.style.milk_white);
                break;
            case LEAFY_GREEN:
                activity.setTheme(R.style.leafy_green);
                break;
            case SOLID_BLACK:
                activity.setTheme(R.style.solid_black);
                break;
            case BRIGHT_YELLOW:
                activity.setTheme(R.style.bright_yellow);
                break;
            case MIX_COCKTAIL:
                activity.setTheme(R.style.mix_cocktail);
                break;
        }
    }
}