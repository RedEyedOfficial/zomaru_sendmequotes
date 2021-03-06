package zomaru.sendmequotes;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.view.View;

/**
 * Created by root on 1/10/18.
 */

public class Trivia extends Activity {
    public int ThemeValue;

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Applytheme(this);
        setContentView(R.layout.fragment_trivia);
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.cltl3);
        collapsingToolbarLayout.setTitle("Trivia");

        collapsingToolbarLayout.setExpandedTitleColor(Color.BLACK);
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.RED);
        android.widget.Toolbar toolbar = (android.widget.Toolbar)findViewById(R.id.tb3);
        setActionBar(toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setLogo(R.drawable.ic_info_trivia);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    public void Applytheme (Activity activity) {
        ThemeValue = Settings.Themevalues;
        switch (ThemeValue) {
            case 1:
                activity.setTheme(R.style.light_theme);
                break;
            case 2:
                activity.setTheme(R.style.dark_theme);
                break;
            case 3:
                activity.setTheme(R.style.black_theme);
                break;
            case 4:
                activity.setTheme(R.style.akame_theme);
                break;
            case 5:
                activity.setTheme(R.style.zero_two_theme);
                break;
            case 6:
                activity.setTheme(R.style.methode_theme);
                break;
            case 7:
                activity.setTheme(R.style.mary_theme);
                break;
            case 8:
                activity.setTheme(R.style.indonesia_theme);
                break;
        }
    }
}
