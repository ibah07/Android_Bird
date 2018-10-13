package com.support.android.dicoding;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Transition;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class BurungDetailActivity extends AppCompatActivity {

    public static final String EXTRA_NAME = "cheese_name";
    public static final String EXTRA_IMAGE = "cheese_image";

    private String cheeseName;
    private CollapsingToolbarLayout collapsingToolbar;
    private Toolbar toolbar;
    private FloatingActionButton fab;
    private AppBarLayout appBarLayout;
    private boolean back = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportPostponeEnterTransition();
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        cheeseName = intent.getStringExtra(EXTRA_NAME);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        collapsingToolbar = findViewById(R.id.collapsing_toolbar);

        fab = findViewById(R.id.fab);
        appBarLayout = findViewById(R.id.appbar);

        loadBackdrop(intent.getIntExtra(EXTRA_IMAGE, -1));

        if (savedInstanceState == null && Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().getEnterTransition().addListener(new TransitionAdapter());
        } else {
            collapsingToolbar.setTitleEnabled(true);
            collapsingToolbar.setTitle(cheeseName);
        }

        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {

                if (verticalOffset == 0 && back) {
                    BurungDetailActivity.super.onBackPressed();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (collapsingToolbar.getContentScrim().getAlpha() == 255) {
                finish();
            } else {
                back = true;
                fab.setVisibility(View.INVISIBLE);
                appBarLayout.setExpanded(true);

            }
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return back || super.dispatchTouchEvent(ev);
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private class TransitionAdapter implements Transition.TransitionListener {
        @Override
        public void onTransitionStart(Transition transition) {
            collapsingToolbar.setTitleEnabled(false);
            toolbar.setVisibility(View.GONE);
            fab.setVisibility(View.INVISIBLE);
        }

        @Override
        public void onTransitionEnd(Transition transition) {
            fab.show();
            collapsingToolbar.setTitleEnabled(true);
            collapsingToolbar.setTitle(cheeseName);
            toolbar.setVisibility(View.VISIBLE);
            getWindow().getEnterTransition().removeListener(this);
        }

        @Override
        public void onTransitionCancel(Transition transition) {

        }

        @Override
        public void onTransitionPause(Transition transition) {

        }

        @Override
        public void onTransitionResume(Transition transition) {

        }
    }

    private void loadBackdrop(final int drawable) {
        final ImageView imageView = (ImageView) findViewById(R.id.backdrop);

        Picasso.with(getApplicationContext())
                .load(drawable)
                .into(imageView, new Callback() {
                    @Override
                    public void onSuccess() {
                        BurungDetailActivity.this.supportStartPostponedEnterTransition();
                    }

                    @Override
                    public void onError() {
                    }
                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sample_actions, menu);
        return true;
    }

}