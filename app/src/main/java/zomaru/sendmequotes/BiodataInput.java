package zomaru.sendmequotes;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BiodataInput extends AppCompatActivity{

    public static String bionama;
    public static String biojk;
    public static String bioumur;
    public SharedPreferences sharedPreferencesnama;
    public SharedPreferences sharedPreferencesjk;
    public SharedPreferences sharedPreferencesumur;

    @BindView(R.id.bio_nama)
    EditText bioinputnama;
    @BindView(R.id.bio_jk)
    EditText bioinputjk;
    @BindView(R.id.bio_umur)
    EditText bioinputumur;

    @BindView(R.id.bio_save_button)
    Button buttonsave;

    @BindView(R.id.view_nama)
    TextView hasilnama;
    @BindView(R.id.view_jk)
    TextView hasiljk;
    @BindView(R.id.view_umur)
    TextView hasilumur;

    public void onDestroy () {
        super.onDestroy();
        if (bioinputnama!=null & bioinputjk!=null & bioinputumur!=null) {
            sharedPreferencesnama = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = sharedPreferencesnama.edit();
            editor.putString("nama", "");
            editor.apply();
            bionama = sharedPreferencesnama.getString("nama", "");
            sharedPreferencesjk = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor1 = sharedPreferencesjk.edit();
            editor1.putString("jk", "");
            editor1.apply();
            biojk = sharedPreferencesjk.getString("jk", "");
            sharedPreferencesumur = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor2 = sharedPreferencesumur.edit();
            editor2.putString("umur", "");
            editor2.apply();
            bioumur = sharedPreferencesumur.getString("umur", "");
        }
    }

    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.biodata_input);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.bio_save_button)
    public void onClick() {
        String nama = bioinputnama.getText().toString();
        hasilnama.setText(nama);
        sharedPreferencesnama = PreferenceManager.getDefaultSharedPreferences(this);

        String jk = bioinputjk.getText().toString();
        hasiljk.setText(jk);
        sharedPreferencesjk = PreferenceManager.getDefaultSharedPreferences(this);

        String umur = bioinputumur.getText().toString();
        hasilumur.setText(umur);
        sharedPreferencesumur = PreferenceManager.getDefaultSharedPreferences(this);
    }
}
