package zomaru.sendmequotes;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.view.View;

/**
 * Created by root on 1/10/18.
 */

public class Trivia extends Activity {

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_trivia);
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.cltl3);
        collapsingToolbarLayout.setTitle("Trivia");

        collapsingToolbarLayout.setExpandedTitleColor(Color.BLACK);
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.RED);
        android.widget.Toolbar toolbar = (android.widget.Toolbar)findViewById(R.id.tb3);
        setActionBar(toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setLogo(R.drawable.ic_info_trivia);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}
