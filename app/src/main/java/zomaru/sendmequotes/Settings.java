package zomaru.sendmequotes;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.MultiSelectListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.preference.SwitchPreference;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetSequence;

import Util.Settings.SettingThemeUtils;

public class Settings extends PreferenceActivity implements Preference.OnPreferenceChangeListener {
    public static final String TRANS_SETTING = "trans_setting";
    public static final String THEME_SETTING = "setting_theme";
    public static ListPreference transSetting;
    public static ListPreference themeSetting;
    public static Preference bugReport;
    public static Preference appversion;
    public static SwitchPreference vibrator;
    public static SwitchPreference tutorial;
    public static SwitchPreference customusername;
    public static SwitchPreference customWallpaper;
    public static SwitchPreference buttonshow;
    public static EditTextPreference username;
    public static PreferenceScreen osl;
    public static Preference opensl;
    public static Preference library;
    public static PreferenceScreen permissions;
    public static SwitchPreference externalreq;
    public static SwitchPreference writesettreq;
    public static boolean isTutorOn;
    public static boolean isGetarOn;
    public static boolean isVisible;
    public static SharedPreferences usernamepref;
    public static boolean isUsernameAssigned;
    public static Context context;
    public static String usernameSender;
    public static String usernameBroadcaster;
    public static int WallpaperValue;
    public static boolean isCustomOn;
    public static boolean isWallpaperCustom;
    public boolean saklar;
    public CharSequence appver;
    public static int Themevalues;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        SettingThemeUtils.activityApplyTheme(this);
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings);

        transSetting = (ListPreference) findPreference(TRANS_SETTING);
        transSetting.setTitle("Wallpaper");
        transSetting.setDefaultValue(1);
        transSetting.setSummary("Ganti Wallpaper aplikasi ini");
        transSetting.setIcon(R.drawable.ic_transition);
        transSetting.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object o) {
                final ListPreference listPreference = (ListPreference) preference;
                final int trs = listPreference.findIndexOfValue((String) o);
                listPreference.setSummary(listPreference.getEntries()[trs]);
                switch (listPreference.findIndexOfValue((String) o)) {
                    default:
                    case 0:
                        Toast t = Toast.makeText(Settings.this, "Monika", Toast.LENGTH_SHORT);
                        t.show();
                        WallpaperValue = 1;
                        break;
                    case 1:
                        Toast e = Toast.makeText(Settings.this, "Zero two", Toast.LENGTH_SHORT);
                        e.show();
                        WallpaperValue = 2;
                        break;
                    case 2:
                        Toast s = Toast.makeText(Settings.this, "Akame", Toast.LENGTH_SHORT);
                        s.show();
                        WallpaperValue = 3;
                        break;
                    case 3:
                        Toast w = Toast.makeText(Settings.this, "Mary", Toast.LENGTH_SHORT);
                        w.show();
                        WallpaperValue = 4;
                        break;
                    case 4:
                        Toast d = Toast.makeText(Settings.this, "Methode", Toast.LENGTH_SHORT);
                        d.show();
                        WallpaperValue = 5;
                        break;
                    case 5:
                        Toast g = Toast.makeText(Settings.this, "Nao", Toast.LENGTH_SHORT);
                        g.show();
                        WallpaperValue = 6;
                        break;
                }
                return true;
            }
        });
        themeSetting = (ListPreference) findPreference(THEME_SETTING);
        themeSetting.setTitle("Tema");
        themeSetting.setIcon(R.drawable.ic_theme_settings);
        themeSetting.setOnPreferenceChangeListener(this);
        vibrator = (SwitchPreference)findPreference("vibrate_setting");
        vibrator.setTitle(R.string.pref_vibrate_set);
        vibrator.setSummary(R.string.pref_vibrate_sum);
        vibrator.setIcon(R.drawable.ic_settings_vibration);
        vibrator.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object o){
                    boolean checked = vibrator.isChecked();
                    if (checked) {
                        Toast.makeText(Settings.this, "Getar wafat", Toast.LENGTH_LONG).show();
                        isGetarOn = false;
                    } else {
                        Toast.makeText(Settings.this, "Getar On", Toast.LENGTH_LONG).show();
                        isGetarOn = true;
                    }
                return true;
            }
        });
        bugReport = (Preference)findPreference("bug_report");
        bugReport.setTitle(R.string.pref_report_bug);
        bugReport.setSummary(R.string.pref_report_sum);
        bugReport.setIcon(R.drawable.ic_report_bug);
        bugReport.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://web.facebook.com/notes/renaldy-p/kritik-saran-masukkan-rate-bug-report/1049104175231114/?qid=6511595753070729317&mf_story_key=-5319118526269368343"));
                ResolveInfo resolveInfo = getPackageManager().resolveActivity(intent,PackageManager.MATCH_DEFAULT_ONLY);
                String packageName = resolveInfo.activityInfo.packageName;
                startActivity(getPackageManager().getLaunchIntentForPackage(packageName));
                startActivity(intent);
                return true;
            }
        });

        appversion = (Preference)findPreference("app_version");
        appver = BuildConfig.VERSION_NAME;
        appversion.setSummary(appver);

        tutorial = (SwitchPreference)findPreference("tutorial");
        tutorial.setTitle("Tutorial");
        tutorial.setIcon(R.drawable.ic_tutorial);
        tutorial.setSummary("Mengaktifkan bantuan untuk menggunakan aplikasi ketika mengklik help");
        tutorial.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object o) {
                boolean checked = tutorial.isChecked();
                if (checked) {
                    isTutorOn = false;
                } else {
                    isTutorOn = true;
                }
                return true;
            }
        });

        customusername = (SwitchPreference)findPreference("custom_username");
        customusername.setTitle("Custom Username?");
        customusername.setIcon(R.drawable.ic_username_custom);
        customusername.setSummary("Hidupkan jika anda ingin mengganti tulisan sambutan di halaman awal aplikasi secara keseluruhan");
        customusername.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object o) {
                boolean custom = customusername.isChecked();
                if (custom) {
                    isCustomOn = false;
                } else {
                    isCustomOn = true;
                    final AlertDialog alertDialog = new AlertDialog.Builder(Settings.this).create();
                    alertDialog.setTitle("Jadi gini..");
                    alertDialog.setMessage("Kalau kamu mengaktifkan fitur ini, kamu tinggal nulis aja tulisan selamat datang atau i love you atau apalah terserah di tempat yang sama kamu ngatur username mu (alias dibawah ini coeg!) Developer app ini tidak bertanggungjawab atas kekacauan maupun konflik batin yang (sedang) atau akan dialami para pengguna aplikasinya setelah mengaktifkan fitur ini.");
                    alertDialog.setIcon(R.drawable.zero2);
                    alertDialog.setCancelable(false);
                    alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK!", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            alertDialog.dismiss();
                        }
                    });
                    alertDialog.show();
                    return true;
                }
                return true;
            }
        });

        customWallpaper = (SwitchPreference)findPreference("custom_wallpaper");
        customWallpaper.setTitle("Custom Wallpaper?");
        customWallpaper.setIcon(R.drawable.ic_wallpaper_custom);
        customWallpaper.setSummary("Terapkan wallpaper dari galeri langsung jika kalian bosan dengan pilihan wallpaper bawaan ^^");
        customWallpaper.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object o) {
                boolean wallpaper = customWallpaper.isChecked();
                if (wallpaper) {
                    isWallpaperCustom = false;
                } else {
                    isWallpaperCustom = true;
                    final AlertDialog alertDialog = new AlertDialog.Builder(Settings.this).create();
                    alertDialog.setTitle("Jadi gini..");
                    alertDialog.setMessage("Kalau kamu mengaktifkan fitur ini, kamu tinggal ganti wallpaper sesuai yang kamu mau dengan menekan tombol logo galeri di halaman awal app yang berwarna hijau, awas jangan pasang foto istri orang ya! oh iya, setelah kamu mengganti wallpaper app ini, tombol ganti wallpaper akan menghilang demi kenyamanan bersama :v untuk memunculkannya lagi, tinggal restart app dari menu yang sudah disediakan ^^ ");
                    alertDialog.setIcon(R.drawable.zero2);
                    alertDialog.setCancelable(false);
                    alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK!", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            alertDialog.dismiss();
                        }
                    });
                    alertDialog.show();
                    return true;
            }
                return true;
            }
        });

        buttonshow = (SwitchPreference)findPreference("show_button");
        buttonshow.setTitle("Tombol tak kasap mata");
        buttonshow.setIcon(R.drawable.ic_button_visible);
        buttonshow.setSummary("Mengatur visibilitas tombol pemilih custom wallpaper pada layar utama, jika diaktifkan maka tombol akan tidak terlihat, (aktifkan dahulu custom wallpaper untuk mengaktifkan fitur ini.)");
        buttonshow.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object o) {
                boolean visible = buttonshow.isChecked();
                if (visible) {
                    isVisible = false;
                } else {
                    isVisible = true;
                }
                return true;
            }
        });

        username = (EditTextPreference)findPreference("username");
        username.setTitle("Username");
        username.setIcon(R.drawable.ic_username);
        username.setDialogTitle("Silahkan masukkan username anda^^");
        username.setSummary("Klik untuk mengatur username anda yang akan ditampilkan di halaman awal aplikasi");
        usernamepref = PreferenceManager.getDefaultSharedPreferences(this);
        usernameBroadcaster = usernamepref.getString("username", "");
        saklar = isCustomOn;
        if (isCustomOn) {
            isUsernameAssigned = false;
        } else {
            isUsernameAssigned = true;
        }
        usernameSender = usernameBroadcaster;
        username.setPersistent(true);

        externalreq = (SwitchPreference)findPreference("external_storage");
        externalreq.setTitle("External Storage");
        externalreq.setSummary("Izinkan aplikasi membaca penyimpanan eksternal");
        externalreq.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object o) {
                boolean izinkan = externalreq.isChecked();
                if (izinkan) {
                    Toast noIzin = Toast.makeText(Settings.this, "Izin ditolak :(", Toast.LENGTH_SHORT);
                    noIzin.show();
                } else {
                    if (ContextCompat.checkSelfPermission(Settings.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)!=PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(Settings.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                        Toast dapatIzin = Toast.makeText(Settings.this, "Izin diberikan ^^", Toast.LENGTH_SHORT);
                        dapatIzin.show();
                    }
                }
                return true;
            }
        });

        writesettreq = (SwitchPreference)findPreference("write_settings");
        writesettreq.setTitle("Write Settings");
        writesettreq.setSummary("Izinkan aplikasi untuk mengubah setelan sistem");
        writesettreq.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object o) {
                boolean izinkeun = writesettreq.isChecked();
                if (izinkeun) {
                    Toast noIzin = Toast.makeText(Settings.this, "Izin ditolak :(", Toast.LENGTH_SHORT);
                    noIzin.show();
                } else {
                    if (ContextCompat.checkSelfPermission(Settings.this, Manifest.permission.WRITE_SETTINGS)!= PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(Settings.this, new String[]{Manifest.permission.WRITE_SETTINGS}, 2);
                        Toast dapatIzin = Toast.makeText(Settings.this, "Izin diberikan ^^", Toast.LENGTH_SHORT);
                        dapatIzin.show();
                    }
                }
                return true;
            }
        });

        osl = (PreferenceScreen)findPreference("open_source");

        opensl = (Preference)findPreference("osl");
        opensl.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                startActivity(new Intent(Settings.this, OSLplusLib.class));
                return true;
            }
        });
        library = (Preference)findPreference("library");
        library.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                startActivity(new Intent(Settings.this, OSLplusLib.class));
                return true;
            }
        });

        permissions = (PreferenceScreen)findPreference("permission_section");
        permissions.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                final AlertDialog alertDialog = new AlertDialog.Builder(Settings.this).create();
                alertDialog.setTitle("Perhatian! ");
                alertDialog.setMessage("Kalau smartphonemu menggunakan OS Android dibawah Marshmallow, kamu nggak usah mengaktifkan permintaan izin secara manual dari sini, karena sudah otomatis aktif dari Manifest aplikasi ini." );
                alertDialog.setIcon(R.drawable.zero2);
                alertDialog.setCancelable(false);
                alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        alertDialog.dismiss();
                    }
                });
                alertDialog.show();
                return true;
            }
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast toast = Toast.makeText(Settings.this, "Izin diberikan ^^", Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    Toast toast = Toast.makeText(Settings.this, "Izin ditolak :(", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
            break;
            case 2: {
                if (grantResults.length > 1 && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                    Toast toast = Toast.makeText(Settings.this, "Izin diberikan ^^", Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    Toast toast = Toast.makeText(Settings.this, "Izin ditolak :(", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }

        }
    }


    public boolean onPreferenceChange(Preference preference, Object newValue) {
        final ListPreference listPreference = (ListPreference) preference;
        final int tst = listPreference.findIndexOfValue((String) newValue);
        listPreference.setSummary(listPreference.getEntries()[tst]);
        switch (listPreference.findIndexOfValue((String)newValue)) {
            default:
            case 0:
                lightApply();
                listPreference.setSummary(listPreference.getEntries()[tst]);
                Themevalues = 1;
                break;
            case 1:
                darkApply();
                listPreference.setSummary(listPreference.getEntries()[tst]);
                Themevalues = 2;
                break;
            case 2:
                blackApply();
                listPreference.setSummary(listPreference.getEntries()[tst]);
                Themevalues = 3;
                break;
            case 3:
                akameApply();
                listPreference.setSummary(listPreference.getEntries()[tst]);
                Themevalues = 4;
                break;
            case 4:
                zerotwoApply();
                listPreference.setSummary(listPreference.getEntries()[tst]);
                Themevalues = 5;
                break;
            case 5:
                methodeApply();
                listPreference.setSummary(listPreference.getEntries()[tst]);
                Themevalues = 6;
                break;
            case 6:
                maryApply();
                listPreference.setSummary(listPreference.getEntries()[tst]);
                Themevalues = 7;
                break;
            case 7:
                indonesiaApply();
                listPreference.setSummary(listPreference.getEntries()[tst]);
                Themevalues = 8;
                break;
        } return true;
    }

// importing SettingThemeUtils to theme up
    public void lightApply() {
        SettingThemeUtils.setTheme(this, SettingThemeUtils.LIGHT_THEME);
    }

    public void darkApply () {
        SettingThemeUtils.setTheme(this, SettingThemeUtils.DARK_THEME);
    }

    public void blackApply () {
        SettingThemeUtils.setTheme(this, SettingThemeUtils.BLACK_THEME);
    }

    public void akameApply () {
        SettingThemeUtils.setTheme(this, SettingThemeUtils.AKAME_THEME);
    }

    public void zerotwoApply () {
        SettingThemeUtils.setTheme(this, SettingThemeUtils.ZERO_TWO_THEME);
    }

    public void methodeApply () {
        SettingThemeUtils.setTheme(this, SettingThemeUtils.METHODE_THEME);
    }

    public void maryApply () {
        SettingThemeUtils.setTheme(this, SettingThemeUtils.MARY_THEME);
    }

    public void indonesiaApply () {
        SettingThemeUtils.setTheme(this, SettingThemeUtils.INDONESIA_THEME);
    }

}