package zomaru.sendmequotes;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.view.View;
import android.widget.ImageButton;

import zomaru.sendmequotes.ThemeSwap;

//About app activity fragment which displays about app layout//

public class AboutApp extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_app);

        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.cltl);
        collapsingToolbarLayout.setTitle("About app");

        collapsingToolbarLayout.setExpandedTitleColor(Color.BLACK);
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.RED);
    }
}
