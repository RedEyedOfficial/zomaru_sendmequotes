package zomaru.sendmequotes;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

//About app activity fragment which displays about app layout//

public class AboutApp extends Activity {
    public int ThemeValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Applytheme(this);
        setContentView(R.layout.about_app);
        Toolbar toolbar = (Toolbar) findViewById(R.id.tb);
        setActionBar(toolbar);
        toolbar.setTitle("About App");
        ImageView imageView = (ImageView) findViewById(R.id.logoapp);
        TextView textView = (TextView) findViewById(R.id.appvertext);

        imageView.setImageResource(R.drawable.about_me);
        textView.setText("Send Me Quotes!" + System.lineSeparator() + "Developer: Renaldy P" + System.lineSeparator() + "App Version: " + BuildConfig.VERSION_NAME + System.lineSeparator() + "Copyright (C) 2018 Red Eyed Official" + System.lineSeparator() + "All rights reserved.");


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
