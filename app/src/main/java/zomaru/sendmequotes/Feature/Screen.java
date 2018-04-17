package zomaru.sendmequotes.Feature;


import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceScreen;
import android.preference.SwitchPreference;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.content.ContextCompat;
import android.view.Display;
import android.widget.Toast;


import zomaru.sendmequotes.R;
import zomaru.sendmequotes.Settings;

public class Screen extends PreferenceActivity {
    public PreferenceScreen normalfeature;
    public PreferenceScreen rootfeature;
    public PreferenceScreen gesture;
    public Preference setwallpapersystem;
    public SwitchPreference torch;
    public SwitchPreference mcb;
    public SwitchPreference fingerss;
    public SwitchPreference dttw;
    public SwitchPreference opencam;
    public SwitchPreference zmrswitch;
    public SwitchPreference dtts;
    public SwitchPreference ojoganggu;
    public int permissionGiven;
    public static Context context;
    public static boolean kontrolPanel;
    public static int DISPLAYSTATUS;
    public int ThemeValue;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        Applytheme(this);
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.feature);

        normalfeature = (PreferenceScreen) findPreference("normal_feature");
        normalfeature.setTitle("Fitur Standar");
        normalfeature.setSummary("Berisi fitur-fitur standar yang kami sediakan untuk smartphone anda");
        normalfeature.setIcon(R.drawable.ic_feature_normal);

        rootfeature = (PreferenceScreen) findPreference("root_feature");
        rootfeature.setTitle("Fitur Lanjutan");
        rootfeature.setSummary("Berisi fitur-fitur lainnya yang membutuhkan akses root atau superuser untuk diterapkan.");
        rootfeature.setIcon(R.drawable.ic_feature_root);

        setwallpapersystem = (Preference) findPreference("setsystem_wallpaper");
        setwallpapersystem.setTitle("Wallpaper & Lockscreen");
        setwallpapersystem.setSummary("Ubah wallpaper & lockscreen bawaan smartphonemu dengan sekali klik");
        setwallpapersystem.setIcon(R.drawable.ic_wallpaper_custom);
        setwallpapersystem.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                Toast toast = Toast.makeText(Screen.this, "Memeriksa izin..", Toast.LENGTH_SHORT);
                toast.show();
                if (ContextCompat.checkSelfPermission(Screen.this, Manifest.permission.SET_WALLPAPER) !=PackageManager.PERMISSION_GRANTED) {
                    permissionGiven = 2;
                    ActivityCompat.requestPermissions(Screen.this, new String[]{Manifest.permission.SET_WALLPAPER}, 1);
                    if (ContextCompat.checkSelfPermission(Screen.this, Manifest.permission.SET_WALLPAPER) != PackageManager.PERMISSION_DENIED) {
                        permissionGiven = 1;
                    }
                } else {
                    Toast toast1 = Toast.makeText(Screen.this, "Izin sudah diberikan :)", Toast.LENGTH_LONG);
                    toast1.show();
                    permissionGiven = 1;
                }

                switch (permissionGiven) {
                    case 1:
                        startActivity(new Intent(Intent.ACTION_SET_WALLPAPER));
                        break;
                    case 2:
                        Toast toast1 = Toast.makeText(Screen.this, "Izin belum diberikan :( sudahkah mengeceknya melalui pengaturan > perizinan?", Toast.LENGTH_LONG);
                        toast1.show();
                        break;
                }
                return true;
            }
        });

        torch = (SwitchPreference)findPreference("torch");
        torch.setTitle("Senter");
        torch.setSummary("Menghidupkan senter");
        torch.setIcon(R.drawable.ic_torch);
        torch.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object o) {
                boolean hidup = torch.isChecked();
                if (hidup) {
                    Toast toast = Toast.makeText(Screen.this, "Senter wafat", Toast.LENGTH_SHORT);
                    toast.show();
                    try {
                        if (Build.VERSION.SDK_INT >= 23) {
                            CameraManager cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
                            String string = cameraManager.getCameraIdList()[0];
                            cameraManager.setTorchMode(string, false);
                        } else if (Build.VERSION.SDK_INT < 23) {
                            Camera camera = Camera.open();
                            Camera.Parameters parameters = camera.getParameters();
                            parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                            camera.setParameters(parameters);
                            camera.stopPreview();
                        }
                    } catch (CameraAccessException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                    if (Build.VERSION.SDK_INT < 23) {
                        Camera camera = Camera.open();
                        Camera.Parameters parameters = camera.getParameters();
                        parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                        camera.setParameters(parameters);
                        camera.startPreview();
                    } else if (Build.VERSION.SDK_INT >= 23) {
                        CameraManager cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
                        String idcam = cameraManager.getCameraIdList()[0];
                        cameraManager.setTorchMode(idcam, true);
                        }
                    } catch (CameraAccessException e) {
                        e.printStackTrace();
                    }
                }
                return true;
            }
        });
        gesture = (PreferenceScreen)findPreference("gesture");
        gesture.setTitle("Gestur");
        gesture.setSummary("Menyediakan kontrol dan akses penuh terhadap perintah saat menekan / mengusap layar");
        gesture.setIcon(R.drawable.ic_gesture);
        gesture.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                final AlertDialog alertDialog = new AlertDialog.Builder(Screen.this).create();
                alertDialog.setTitle("Perhatian! ");
                alertDialog.setMessage("Untuk mengaktifkan fitur-fitur gestur ini, kamu harus pergi ke pengaturan sistem smartphonemu, lalu ke bagian Aksesibilitas atau Accessibility, aktifkan layanan Zomaru Screen Gesture, jangan tanya kenapa ya..." );
                alertDialog.setIcon(R.drawable.zero2);
                alertDialog.setCancelable(false);
                alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "OKE BOSS!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        alertDialog.dismiss();
                    }
                });
                alertDialog.show();
                return true;
            }
        });

        mcb = (SwitchPreference)findPreference("mcb_utama");
        mcb.setTitle("Kontrol Gestur");
        mcb.setIcon(R.drawable.ic_accessibility_gesture);
        mcb.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object o) {
                boolean nilai = mcb.isChecked();
                if (nilai) {
                    kontrolPanel = false;
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        // Create the NotificationChannel, but only on API 26+ because
                        // the NotificationChannel class is new and not in the support library
                        CharSequence name = getString(R.string.channel_name);
                        String description = getString(R.string.channel_desc);
                        int importance = NotificationManager.IMPORTANCE_DEFAULT;
                        NotificationChannel channel = new NotificationChannel("G", name, importance);
                        channel.setDescription(description);
                        // Register the channel with the system
                        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                        notificationManager.createNotificationChannel(channel);

                        NotificationCompat.Builder builder = new NotificationCompat.Builder(Screen.this);
                        builder.setContentTitle("Zomaru Screen Gesture");
                        builder.setContentText("Is on fire now");
                        builder.setChannelId("G");
                        builder.setNumber(1);
                        builder.setSmallIcon(R.drawable.ic_accessibility_gesture);
                        builder.setOngoing(true);
                        builder.setWhen(System.currentTimeMillis());
                        builder.setPriority(Notification.PRIORITY_HIGH);
                        notificationManager.cancel(1);
                    }

                } else {
                    kontrolPanel = true;
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        // Create the NotificationChannel, but only on API 26+ because
                        // the NotificationChannel class is new and not in the support library
                        CharSequence name = getString(R.string.channel_name);
                        String description = getString(R.string.channel_desc);
                        int importance = NotificationManager.IMPORTANCE_DEFAULT;
                        NotificationChannel channel = new NotificationChannel("G", name, importance);
                        channel.setDescription(description);
                        // Register the channel with the system
                        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                        notificationManager.createNotificationChannel(channel);

                        NotificationCompat.Builder builder = new NotificationCompat.Builder(Screen.this);
                        builder.setContentTitle("Zomaru Screen Gesture");
                        builder.setContentText("Is on fire now");
                        builder.setChannelId("G");
                        builder.setNumber(1);
                        builder.setSmallIcon(R.drawable.ic_accessibility_gesture);
                        builder.setOngoing(true);
                        builder.setWhen(System.currentTimeMillis());
                        builder.setPriority(Notification.PRIORITY_HIGH);
                        notificationManager.notify(1, builder.build());
                    }
                }
                return true;
            }
        });


        fingerss = (SwitchPreference)findPreference("three_finger_ss");
        fingerss.setTitle("Three Finger Screenshot");
        fingerss.setSummary("Jika diaktifkan, maka kamu akan bisa mengambil screenshot langsung dengan mengusap 3 jari ke layar");
        fingerss.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object o) {
                boolean finger = fingerss.isChecked();
                if (finger) {

                } else {

                }
                return true;
            }
        });

        dttw = (SwitchPreference)findPreference("double_tap");
        dttw.setTitle("Double Tap To Wake");
        dttw.setSummary("Aktifkan layar dengan 2x menyentuhnya pada saat posisi layar mati");
        dttw.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object o) {
                boolean dt = dttw.isChecked();
                if (dt) {

                } else {
                    displayStateDetector();
                }
                return true;
            }
        });

        opencam = (SwitchPreference)findPreference("open_camera");
        opencam.setTitle("Open Camera");
        opencam.setSummary("Buka kamera langsung dengan menggambar O pada saat posisi layar mati");
        opencam.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object o) {
                boolean cam = opencam.isChecked();
                if (cam) {

                } else {
                    displayStateDetector();
                }
                return true;
            }
        });

        zmrswitch = (SwitchPreference)findPreference("zmr_switch");
        zmrswitch.setTitle("Favorit App");
        zmrswitch.setSummary("Usap 'Z' pada layar untuk membuka aplikasi favoritmu");

        dtts = (SwitchPreference)findPreference("dtts");
        dtts.setTitle("Double Tap To Sleep");
        dtts.setSummary("Sentuh 2x pada status bar untuk menonaktifkan layar");

        ojoganggu = (SwitchPreference)findPreference("dnd_please");
        ojoganggu.setTitle("Ojo Ganggu Mode");
        ojoganggu.setSummary("Ojo Ganggu Mode, aktifkan mode ini dikala sedang bermain game, mode ini akan memblokir semua notifikasi yang masuk beserta menonaktifkan tombol kapasitif smartphonemu. Pokok e ojo ganggu :) ");
        ojoganggu.setIcon(R.drawable.ic_ojo_ganggu_cok);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast toast = Toast.makeText(Screen.this, "Izin diberikan ^^", Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    Toast toast = Toast.makeText(Screen.this, "Izin ditolak :(", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
            break;
        }
    }

    public static void displayStateDetector() {
        DisplayManager dm = (DisplayManager) context.getSystemService(Context.DISPLAY_SERVICE);
        for (Display display : dm.getDisplays()) {
            if (display.getState() != Display.STATE_OFF) {
                DISPLAYSTATUS = 1;
            } else if (display.getState() != Display.STATE_ON) {
                DISPLAYSTATUS = 0;
            }
        }
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
