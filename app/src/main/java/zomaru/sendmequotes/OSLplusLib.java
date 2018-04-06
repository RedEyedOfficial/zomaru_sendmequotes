package zomaru.sendmequotes;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Toolbar;


public class OSLplusLib extends FragmentActivity {
    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    FVPoslpluslib Adapter;
    public int ThemeValue;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Applytheme(this);
        setContentView(R.layout.oslpluslibrary);

        toolbar = (Toolbar) findViewById(R.id.osltool);
        setActionBar(toolbar);

        viewPager = findViewById(R.id.vposl);
        Adapter = new FVPoslpluslib(getSupportFragmentManager());
        viewPager.setAdapter(Adapter);
        tabLayout = findViewById(R.id.tlosl);
        tabLayout.setupWithViewPager(viewPager);
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
