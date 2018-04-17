package zomaru.sendmequotes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class YoursSincerely extends AppCompatActivity {

    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.private_area);

        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.ctl51);
        collapsingToolbarLayout.setTitle("Area 51");
        android.support.v7.widget.Toolbar toolbar = (Toolbar)findViewById(R.id.tb51);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        CircleImageView imageView = (CircleImageView) findViewById(R.id.your_avatar);
        imageView.setImageResource(R.drawable.about_me);
        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab_edit_data);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(YoursSincerely.this, BiodataInput.class));
            }
        });
    }

    @Override
    protected void onResume () {
        super.onResume();

        TextView textView = (TextView)findViewById(R.id.biodatamu);
        String nama = BiodataInput.bionama;
        String jenkel = BiodataInput.biojk;
        String umur = BiodataInput.bioumur;
        textView.setText("Nama: " + nama + System.lineSeparator() + "Jenis Kelamin: " + jenkel + System.lineSeparator() + "Umur: " + umur);
    }
}
