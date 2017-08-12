package com.jx372.myapp.ui;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;

import com.jx372.myapp.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_main );

        new MainTabsAdapter(
            this,
            (TabHost)findViewById( android.R.id.tabhost ),
            (ViewPager)findViewById( R.id.pager ) );

//        ((ViewPager)findViewById( R.id.pager )).setAdapter( new MainTabsAdapter2( this ) );
    }
}
