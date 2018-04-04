package Util.Settings;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.widget.Toast;

import zomaru.sendmequotes.MainActivity;

/**
 * Created by root on 1/22/18.
 */

public class SettingCreator {
    public static String deviceModel;
    public static boolean saklarutama;
    public static boolean Mcbcreator;
    public static boolean Mcbcabangcreator;

    //Dialog creator//
    public static void mainActivityDialogCreator(final Activity activity) {
        deviceModel = Build.MODEL;
        Mcbcreator = true;
        final AlertDialog alertDialog = new AlertDialog.Builder(activity).create();
        alertDialog.setTitle("Hp sampah teredeteksi !!!");
        alertDialog.setMessage(deviceModel + " " + "Anda sepertinya cacad seperti muka anda :<");
        alertDialog.setCancelable(false);
        alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Bacod gblk >:(", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int which) {
                alertDialog.cancel();
                instalasiSaklar(activity);
            }
        });
        alertDialog.show();
    }

    public static void instalasiSaklar(final Activity activity) {
        if (Mcbcreator) {
            Mcbcabangcreator = true;
            final AlertDialog alertDialog = new AlertDialog.Builder(activity).create();
            alertDialog.setTitle("Moshi-moshi ^^");
            alertDialog.setCancelable(false);
            alertDialog.setMessage("Apakah anda mau memulai tutorial menggunakan aplikasi ini?");
            alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Ya", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    alertDialog.cancel();
                    Toast listrikOn = Toast.makeText(activity, "Silahkan menuju pengaturan di pojok kanan atas layar, lalu aktifkan tutorial", Toast.LENGTH_LONG);
                    listrikOn.show();
                    saklarutama = true;
                }
            });
            alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Tidak", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    alertDialog.cancel();
                    Toast listrikOff = Toast.makeText(activity, "Ok :(", Toast.LENGTH_SHORT);
                    listrikOff.show();
                    saklarutama = false;
                }
            });
            alertDialog.show();
        }

    }
}
