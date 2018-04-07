package zomaru.sendmequotes;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class Changelog extends AppCompatActivity {

    public int ThemeValue;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Applytheme(this);
        setContentView(R.layout.new_changelog);

        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapstoolbarchangelog);
        collapsingToolbarLayout.setTitle("Changelog");

        Toolbar toolbar = (Toolbar) findViewById(R.id.tlbchangelog);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        TextView textView = (TextView)findViewById(R.id.desctitlechg);
        textView.setText("19-10-2017");

        TextView isi = (TextView)findViewById(R.id.descisichg);
        isi.setText("App v1.0 | App lahir & menghabiskan waktu liburan kerja");

        TextView textView1 = (TextView)findViewById(R.id.desctitlechg2);
        textView1.setText("20-12-2017");

        TextView isi2 = (TextView)findViewById(R.id.descisichg2);
        isi2.setText("App v1.0.1 | App rebuild | Status aplikasi: beta | Pengaplikasian versi build app dari file build.flavor.desc | Penambahan beberapa fitur");

        TextView textView2 = (TextView)findViewById(R.id.desctitlechg3);
        textView2.setText("26-12-2017");

        TextView isi3 = (TextView)findViewById(R.id.descisichg3);
        isi3.setText("App v1.0.5 | Update versi build app | Merombak UI pada bagian about app | Penambahan SplashScreen & Loading pada SplashScreen | Penambahan beberapa permission pada Manifest | Penambahan menu 'fitur lainnya'");

        TextView textView3 = (TextView)findViewById(R.id.desctitlechg4);
        textView3.setText("04-01-2018");

        TextView isi4 = (TextView)findViewById(R.id.descisichg4);
        isi4.setText("App v1.0.5DP | Developer Preview 1, Developer Preview adalah saat dimana app ini diberikan kepada beta testers dalam hal app ini, itu adalah teman-teman saya :v | Penambahan menu 'Phone info' | Penambahan AlertDialog pada halaman awal aplikasi");

        TextView textView4 = (TextView)findViewById(R.id.desctitlechg5);
        textView4.setText("07-01-2018");

        TextView isi5 = (TextView)findViewById(R.id.descisichg5);
        isi5.setText("App v1.0.5DP | Developer Preview 2 & 3 | Rombak hampir keseluruhan UI menjadi bertema Just Monika | Penambahan beberapa suara-suara mesra pada aplikasi ini");

        TextView textView5 = (TextView)findViewById(R.id.desctitlechg6);
        textView5.setText("16-01-2018");

        TextView isi6 = (TextView)findViewById(R.id.descisichg6);
        isi6.setText("App v1.1.0 | Shape up Settings | Penambahan pengaturan pada aplikasi, untuk memudahkan anda mengatur aplikasi ini | Ganti suara yang digunakan saat aplikasi ini dimulai | Perhalus UI dan penambahan beberapa style baru pada xml | Fix posisi TabLayout pada fitur lainnya | Pindahkan fitur kunjungi media sosial ke Settings atau pengaturan");

        TextView textView6 = (TextView)findViewById(R.id.desctitlechg7);
        textView6.setText("03-04-2018");

        TextView isi7 = (TextView)findViewById(R.id.descisichg7);
        isi7.setText("App v1.1.25.002 | Penambahan beberapa hal dan fitur baru di settings | Transisi gambar dihilangkan | Fix Pengatur getar | Fix tema belang di sisi kanan dan kiri layar | Penambahan tombol pemilih wallpaper langsung dari galeri di layar utama aplikasi | Penambahan teks sambutan di halaman utama app | Perubahan layout pada Changelog |dll");

        TextView textView7 = (TextView)findViewById(R.id.desctitlechg8);
        textView7.setText("06-04-2018");

        TextView isi8 = (TextView)findViewById(R.id.descisichg8);
        isi8.setText("App v1.2.002 | Hotfix untuk stock wallpaper Nao (whore) | Menu tema di navigation drawer dihapus, terapkan tema langsung dari pengaturan | tambah pengatur visibilitas tombol kustom wallpaper | tambah dependesi switch di pengaturan | perubahan icon di pengaturan | penambahan Open Source Aspect | Update trivia | dll");


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
