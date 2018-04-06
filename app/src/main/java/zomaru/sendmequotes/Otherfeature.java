package zomaru.sendmequotes;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Toast;
import android.widget.Toolbar;


public class Otherfeature extends FragmentActivity {
    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    FeatureViewPager Adapter;
    public boolean Mcb;
    public int ThemeValue;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Applytheme(this);
        setContentView(R.layout.other_feature);

        toolbar = (Toolbar) findViewById(R.id.other_feature_toolbar);
        setActionBar(toolbar);
        viewPager = findViewById(R.id.view_pager);
        Adapter = new FeatureViewPager(getSupportFragmentManager());
        viewPager.setAdapter(Adapter);
        tabLayout = findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);
        toolbar.setLogo(R.drawable.ic_other_feature);
        toolbar.setTitleTextColor(Color.RED);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        warningSound();
        Mcb = Settings.isGetarOn;
        final Vibrator vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
        final AlertDialog alertDialog = new AlertDialog.Builder(Otherfeature.this).create();
        alertDialog.setTitle("Oops :(");
        alertDialog.setMessage("Saat ini kamu sedang menikmati aplikasi Send Me Quotes dalam versi Developer Preview (3), 'Fitur lainnya' akan diperkenalkan pada Developer Preview (4), jadi mohon bersabar ya ^^ . Doakan saja agar developernya cepat menyelesaikan aplikasi ini, fitur-fiturnya pasti keren kok :D");
        alertDialog.setIcon(R.drawable.my_dear_warning);
        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK ^^", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                alertDialog.dismiss();
            }
        });
        alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Halah dev goblok >:(", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(Otherfeature.this, "Kerad juga kamu ya >:(", Toast.LENGTH_LONG).show();
                if (Mcb) {
                    vibrator.vibrate(5000);
                }
            }
        });
        alertDialog.show();
        alertDialog.setCancelable(false);
    }

    public void warningSound() {
        MediaPlayer mediaPlayer = MediaPlayer.create(Otherfeature.this, R.raw.lowbattery);
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.release();
            }
        });
        mediaPlayer.start();
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