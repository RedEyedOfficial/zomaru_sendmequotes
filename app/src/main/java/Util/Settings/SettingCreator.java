/*
 * Copyright (C) 2018 Red Eyed Official
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package Util.Settings;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.widget.Toast;

import zomaru.sendmequotes.MainActivity;

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
