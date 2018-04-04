package zomaru.sendmequotes;

import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetSequence;

import Util.Settings.SettingCreator;
import Util.Settings.SettingTransitionPickerUtils;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public boolean Mcb;
    public boolean sekring;
    public boolean fuse;
    public boolean relay;
    private static final int WALLPAPER = 1;
    public static ImageView ima1;
    public static Drawable drw;
    public boolean McbGetar;
    public int intReceiver;
    public static TextView usernameUser;
    public static String UsernameRetriever;
    public static ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ThemeSwap.onActivityCreateSetTheme(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ima1 = (ImageView)findViewById(R.id.monika);
        final ImageButton imageButton = (ImageButton) findViewById(R.id.wallpaperpicker);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                relay = Settings.isWallpaperCustom;
                // jika user sudah mengaktifkan custom wallpaper, maka kode berikut akan dieksekusi //
                if (relay) {
                    Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(intent, WALLPAPER);
                    imageButton.setVisibility(View.INVISIBLE);
                } else {
                    Toast toast = Toast.makeText(MainActivity.this, "Aktifin dulu custom wallpaper di pengaturan gan!", Toast.LENGTH_LONG);
                    toast.show();
                    // jika tidak, maka kode diatas akan dieksekusi //
                }
            }
        });
        usernameUser = (TextView)findViewById(R.id.username_preview);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        welcomeSound();
        BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_help:
                        Mcb = Settings.isTutorOn;
                        if (Mcb) {
                            startTargetViewOnNavbar();
                        } else {
                            Toast noTutor = Toast.makeText(MainActivity.this, "No tutorial :(", Toast.LENGTH_LONG);
                            noTutor.show();
                        }
                        break;
                    case R.id.menu_trivia:
                        startActivity(new Intent(MainActivity.this, Trivia.class));
                        break;
                }
                return false;
            }
        });
        SettingCreator.mainActivityDialogCreator(this);
        vibrateOn(this);
    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onResume() {
        super.onResume();
        sekring = Settings.isUsernameAssigned;
        fuse = Settings.isCustomOn;
        UsernameRetriever = Settings.usernameBroadcaster;
        if (sekring) {
            usernameUser.setText("Selamat Datang, " + UsernameRetriever);
        } else if (fuse) {
            usernameUser.setText(UsernameRetriever);
        }
        intReceiver = Settings.WallpaperValue;
        switch (intReceiver) {
            case 1:
                imageButton = (ImageButton)findViewById(R.id.wallpaperpicker);
                ima1.setImageResource(R.drawable.my_dear);
                imageButton.setVisibility(View.INVISIBLE);
                break;
            case 2:
                imageButton = (ImageButton)findViewById(R.id.wallpaperpicker);
                ima1.setImageResource(R.drawable.zerotwo);
                imageButton.setVisibility(View.INVISIBLE);
                break;
            case 3:
                imageButton = (ImageButton)findViewById(R.id.wallpaperpicker);
                ima1.setImageResource(R.drawable.akame2);
                imageButton.setVisibility(View.INVISIBLE);
                break;
            case 4:
                imageButton = (ImageButton)findViewById(R.id.wallpaperpicker);
                ima1.setImageResource(R.drawable.mary2);
                imageButton.setVisibility(View.INVISIBLE);
                break;
            case 5:
                imageButton = (ImageButton)findViewById(R.id.wallpaperpicker);
                ima1.setImageResource(R.drawable.methode);
                imageButton.setVisibility(View.INVISIBLE);
                break;
            case 6:
                imageButton = (ImageButton)findViewById(R.id.wallpaperpicker);
                ima1.setImageResource(R.drawable.nao);
                imageButton.setVisibility(View.INVISIBLE);
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case WALLPAPER:
                if (resultCode == RESULT_OK) {
                    Uri uri = data.getData();
                    String[] wallpaper = {MediaStore.Images.Media.DATA};
                    Cursor cursor = getContentResolver().query(uri, wallpaper, null, null, null);
                    cursor.moveToFirst();

                    int IndexKolom = cursor.getColumnIndex(wallpaper[0]);
                    String pathMenujuFile = cursor.getString(IndexKolom);
                    cursor.close();

                    Bitmap bitmap = BitmapFactory.decodeFile(pathMenujuFile);
                    Drawable drawable = new BitmapDrawable(bitmap);
                    ima1.setImageDrawable(drawable);
                }
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void vibrateOn(Context context) {
        McbGetar = Settings.isGetarOn;
        if (McbGetar) {
            final Vibrator vibrator = ((Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE));
            vibrator.vibrate(5000);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.exit) {
            exitSound();
            final AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
            alertDialog.setTitle("m͏̣̼̻͔̟o͔̝͖̣̭͓͎n̟i̼͕̘̗͚ka̶̝͉m͉̜̼̼̲̠̜ó͔̮̟͙̙͙n̼i̺̗̻̯k̬͚a̛͔͚m̨͔o̶̪̺̠̞ͅn̗̟̬͇i̭̳̘͢ͅķ͕̮a͕̠̹͕͖̪͞ͅm̢͚o̷͎̖̭͓n̹̺̘̞i̡ͅk̘͢a̘̦̖ͅm̴o͎n̥̭̮͈ͅͅiͅͅk̙̰͕̘͎̤a̡̟͇");
            alertDialog.setMessage("Monika is watching!! Apa kamu yakin mau menutup app ini? Monika selalu mengawasimu, jangan salahkan aplikasi ini ketika suatu saat HPmu tiba-tiba mengalami bootloop :>");
            alertDialog.setIcon(R.drawable.my_dear);
            alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Bacod ngentod >:(", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            });
            alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Just MONIKA", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    alertDialog.dismiss();
                    Toast.makeText(MainActivity.this, "m͏̣̼̻͔̟o͔̝͖̣̭͓͎n̟i̼͕̘̗͚ka̶̝͉m͉̜̼̼̲̠̜ó͔̮̟͙̙͙n̼i̺̗̻̯k̬͚a̛͔͚m̨͔o̶̪̺̠̞ͅn̗̟̬͇i̭̳̘͢ͅķ͕̮a͕̠̹͕͖̪͞ͅm̢͚o̷͎̖̭͓n̹̺̘̞i̡ͅk̘͢a̘̦̖ͅm̴o͎n̥̭̮͈ͅͅiͅͅk̙̰͕̘͎̤a̡̟͇", Toast.LENGTH_LONG).show();
                }
            });
            alertDialog.show();
            return true;
        }
        if (id == R.id.restart) {
            this.finish();
            startActivity(new Intent(this, MainActivity.class));
        }

        if (id == R.id.settings) {
            startActivity(new Intent(this, Settings.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.about_app) {
            startActivity(new Intent(this, AboutApp.class));
        } else if (id == R.id.about_phone) {
            startActivity(new Intent(this, AboutPhone.class));
        } else if (id == R.id.changelog) {
            startActivity(new Intent(this, Changelog.class));
        } else if (id == R.id.other_feature) {
            startActivity(new Intent(this, Otherfeature.class));
        } else if (id == R.id.clean_ram) {
            final String availableRAM;
            String percentRAM;
            final String availableMem;
            availableRAM = "RAM tersisa: ";
            percentRAM = "Persentase RAM tersisa adalah: ";
            availableMem = "MB";
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ActivityManager activityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
            activityManager.getMemoryInfo(memoryInfo);
            final double availRAM = memoryInfo.availMem / 0x100000L;
            double percentageRAM = memoryInfo.availMem / (double) memoryInfo.totalMem * 100.0;
            final AlertDialog cleanRAM = new AlertDialog.Builder(MainActivity.this).create();
            cleanRAM.setTitle("Bersihkan RAM?");
            cleanRAM.setIcon(R.drawable.ic_autorenew);
            cleanRAM.setMessage("Bersihkan RAM sekarang juga? saat ini" + " " + percentRAM + percentageRAM + "%");
            cleanRAM.setButton(DialogInterface.BUTTON_POSITIVE, "Ya!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    System.runFinalization();
                    Runtime.getRuntime().gc();
                    System.gc();
                    Toast.makeText(MainActivity.this, "Selamat! sekarang sisa ram anda adalah: " + availRAM + availableMem + " " + "tersisa", Toast.LENGTH_LONG).show();
                }
            });
            cleanRAM.setButton(DialogInterface.BUTTON_NEGATIVE, "Ogah!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(MainActivity.this, "Sayang sekali :( hp anda tambah lemot!" + " " + availableRAM + availRAM + availableMem, Toast.LENGTH_LONG).show();
                }
            });
            cleanRAM.show();
        } else if (id == R.id.share) {
            McbGetar = Settings.isGetarOn;
            warningSound();
            final Vibrator getar = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            final AlertDialog pendingFeature = new AlertDialog.Builder(MainActivity.this).create();
            pendingFeature.setTitle("Oops! >:(");
            pendingFeature.setMessage("Fitur ini nyusul ya gan, app ini hanya developer version ^^ . Doakan saja developernya cepat menyelesaikan app ini ^^");
            pendingFeature.setIcon(R.drawable.my_dear_warning);
            pendingFeature.setButton(DialogInterface.BUTTON_POSITIVE, "Amin", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    pendingFeature.dismiss();
                }
            });
            pendingFeature.setButton(DialogInterface.BUTTON_NEGATIVE, "Halah dev pekok! >:(", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(MainActivity.this, "Kerad juga kamu ya :)", Toast.LENGTH_LONG).show();
                    if (McbGetar) {
                        getar.vibrate(5000);
                    }
                }
            });
            pendingFeature.show();
            return true;
        } else if (id == R.id.monika_chat) {
            String monikaChat = "Apa elo tega ngechat kok karakter 2D? XD";
            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
            final EditText editText = new EditText(MainActivity.this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            editText.setLayoutParams(layoutParams);
            editText.setHint(monikaChat);
            alertDialog.setView(editText);
            alertDialog.setTitle("Katakan sesuatu pada Monika! ^^");
            alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Kirim", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(MainActivity.this, "m͏̣̼̻͔̟o͔̝͖̣̭͓͎n̟i̼͕̘̗͚ka̶̝͉m͉̜̼̼̲̠̜ó͔̮̟͙̙͙n̼i̺̗̻̯k̬͚a̛͔͚m̨͔o̶̪̺̠̞ͅn̗̟̬͇i̭̳̘͢ͅķ͕̮a͕̠̹͕͖̪͞ͅm̢͚o̷͎̖̭͓n̹̺̘̞i̡ͅk̘͢a̘̦̖ͅm̴o͎n̥̭̮͈ͅͅiͅͅk̙̰͕̘͎̤a̡̟͇", Toast.LENGTH_LONG).show();
                }
            });
            alertDialog.show();
        } else if (id == R.id.theme_swap) {
            ThemeSwap.applyTheme(this, ThemeSwap.BLAZING_RED);
        } else if (id == R.id.theme_swap_blue) {
            ThemeSwap.applyTheme(this, ThemeSwap.OCEAN_BLUE);
        } else if (id == R.id.theme_swap_white) {
            ThemeSwap.applyTheme(this, ThemeSwap.MILK_WHITE);
        } else if (id == R.id.theme_swap_green) {
            ThemeSwap.applyTheme(this, ThemeSwap.LEAFY_GREEN);
        } else if (id == R.id.theme_swap_default) {
            ThemeSwap.applyTheme(this, ThemeSwap.TEMA_BAWAAN);
        } else if (id == R.id.theme_swap_yellow) {
            ThemeSwap.applyTheme(this, ThemeSwap.BRIGHT_YELLOW);
        } else if (id == R.id.theme_swap_mix) {
            ThemeSwap.applyTheme(this, ThemeSwap.MIX_COCKTAIL);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void welcomeSound() {
        MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.welcome);
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.release();
            }
        });
        mediaPlayer.start();
    }

    public void exitSound() {
        MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.poweroff);
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.release();
            }
        });
        mediaPlayer.start();
    }

    public void warningSound() {
        MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.lowbattery);
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.release();
            }
        });
        mediaPlayer.start();
    }

    public void startTargetViewOnNavbar () {
        if (Settings.isTutorOn = true) {
            final TapTargetSequence tapTargetSequence = new TapTargetSequence(this);
            tapTargetSequence.continueOnCancel(true);
            tapTargetSequence.targets(
                    TapTarget.forView(findViewById(R.id.toolbar), "Hai, aku adalah monika, senang bertemu denganmu^^ aku akan memandumu mengenai aplikasi gak guna ini, ok?")
                            .textColor(R.color.white)
                            .targetCircleColor(R.color.red)
                            .descriptionTextColor(R.color.white)
                            .titleTextColor(R.color.white)
                            .outerCircleAlpha(0.76f),
                    TapTarget.forView(findViewById(R.id.bottom_nav), "Ini adalah menu navigasi bawah")
                            .textColor(R.color.white)
                            .targetCircleColor(R.color.red)
                            .descriptionTextColor(R.color.white)
                            .titleTextColor(R.color.white)
                            .outerCircleAlpha(0.76f),
                    TapTarget.forView(findViewById(R.id.menu_trivia), "ini adalah trivia, klik kalau kamu ingin melihat apa saja yang menginspirasi developer dalam mengembangkan app ini")
                            .textColor(R.color.white)
                            .targetCircleColor(R.color.red)
                            .descriptionTextColor(R.color.white)
                            .titleTextColor(R.color.white)
                            .outerCircleAlpha(0.76f))
                    .start();
        } else if (Settings.isTutorOn = false){
            Toast noTutor = Toast.makeText(MainActivity.this, "No tutorial :(", Toast.LENGTH_LONG);
            noTutor.show();
        }
    }

}
