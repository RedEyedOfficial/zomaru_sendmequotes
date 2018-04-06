package zomaru.sendmequotes;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

// Created by Renaldy P on 01-07-2018
// menampilkan layout changelog

public class Changelog extends Activity {

    private RecyclerView recyclerView;
    private AdapterChangelog adapterChangelog;
    private ArrayList<ChangelogInfo>changelogArrayList;
    public int ThemeValue;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.changelog_layout);

        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.cltl2);
        collapsingToolbarLayout.setTitle("Changelog");

        collapsingToolbarLayout.setExpandedTitleColor(Color.BLACK);
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.RED);
        android.widget.Toolbar toolbar = (android.widget.Toolbar)findViewById(R.id.tb2);
        setActionBar(toolbar);
        toolbar.setTitleTextColor(Color.RED);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        imporData();
        recyclerView = (RecyclerView)findViewById(R.id.recycler_changelog);
        adapterChangelog = new AdapterChangelog(changelogArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Changelog.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterChangelog);


    }

    void imporData() {
        CharSequence changelog1;
        CharSequence changelog2;
        CharSequence changelog3;
        CharSequence changelog4;
        CharSequence changelog5;
        CharSequence changelog6;
        CharSequence changelog7;
        CharSequence changelog8;
        CharSequence doneBy;
        changelog1 = "19-10-2017: App v1.0 | App lahir & menghabiskan waktu liburan kerja";
        changelog2 = "20-12-2017: App v1.0.1 | App rebuild | Status aplikasi: beta | Pengaplikasian versi build app dari file build.flavor.desc | Penambahan beberapa fitur";
        changelog3 = "26-12-2017: App v1.0.5 | Update versi build app | Merombak UI pada bagian about app | Penambahan SplashScreen & Loading pada SplashScreen | Penambahan beberapa permission pada Manifest | Penambahan menu 'fitur lainnya' ";
        changelog4 = "04-01-2018: App v1.0.5DP | Developer Preview 1, Developer Preview adalah saat dimana app ini diberikan kepada beta testers dalam hal app ini, itu adalah teman-teman saya :v | Penambahan menu 'Phone info' | Penambahan AlertDialog pada halaman awal aplikasi";
        changelog5 = "07-01-2018: App v1.0.5DP | Developer Preview 2 & 3 | Rombak hampir keseluruhan UI menjadi bertema Just Monika | Penambahan beberapa suara-suara mesra pada aplikasi ini";
        changelog6 = "16-01-2018: App v1.1.0 | Shape up Settings | Penambahan pengaturan pada aplikasi, untuk memudahkan anda mengatur aplikasi ini | Ganti suara yang digunakan saat aplikasi ini dimulai | Perhalus UI dan penambahan beberapa style baru pada xml | Fix posisi TabLayout pada fitur lainnya | Pindahkan fitur kunjungi media sosial ke Settings atau pengaturan";
        changelog7 = "03-04-2018: App v1.1.25.002 | Penambahan beberapa hal dan fitur baru di settings | Transisi gambar dihilangkan | Fix Pengatur getar | Fix tema belang di sisi kanan dan kiri layar | Penambahan tombol pemilih wallpaper langsung dari galeri di layar utama aplikasi | Penambahan teks sambutan di halaman utama app | Perubahan layout pada Changelog |dll";
        changelog8 = "06-04-2018: App v1.2.002 | Hotfix untuk stock wallpaper Nao (whore) | Menu tema di navigation drawer dihapus, terapkan tema langsung dari pengaturan | tambah pengatur visibilitas tombol kustom wallpaper | tambah dependesi switch di pengaturan | perubahan icon di pengaturan | penambahan Open Source Aspect | Update trivia | dll";
        doneBy = " Done by: ZmR x Zero Two";

        changelogArrayList = new ArrayList<>();
        changelogArrayList.add(new ChangelogInfo(changelog1, doneBy));
        changelogArrayList.add(new ChangelogInfo(changelog2, doneBy));
        changelogArrayList.add(new ChangelogInfo(changelog3, doneBy));
        changelogArrayList.add(new ChangelogInfo(changelog4, doneBy));
        changelogArrayList.add(new ChangelogInfo(changelog5, doneBy));
        changelogArrayList.add(new ChangelogInfo(changelog6, doneBy));
        changelogArrayList.add(new ChangelogInfo(changelog7, doneBy));
        changelogArrayList.add(new ChangelogInfo(changelog8, doneBy));
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
