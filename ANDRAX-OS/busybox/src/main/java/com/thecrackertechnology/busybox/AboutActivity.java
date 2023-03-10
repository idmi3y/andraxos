package com.thecrackertechnology.busybox;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.LinkMovementMethod;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

/**
 * Created by anton on 19.09.15.
 */
public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);

        getSupportActionBar().setTitle(getString(R.string.title_activity_about));

        setContentView(R.layout.activity_aboutbusybox);

        TextView aboutView = (TextView) findViewById(R.id.aboutTextView);
        aboutView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    @Override
    public void setTheme(int resid) {
        super.setTheme(PrefStore.getTheme(this));
    }

}
