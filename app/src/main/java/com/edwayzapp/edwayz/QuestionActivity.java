package com.edwayzapp.edwayz;

import android.media.MediaPlayer;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.edwayzapp.fragments.QuestionFragment;

import java.util.ArrayList;
import java.util.List;

public class QuestionActivity extends AppCompatActivity {

    ViewPagerAdapter adapter;
    MediaPlayer mPlayer2;
    ImageView iv_error;
    ViewPager viewPager;

    private Button nextBtn = null;
    private Button prevBtn = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        initViews();
        initListeners();
    }

    private void initViews() {
        nextBtn = (Button) findViewById(R.id.btn_next);
        prevBtn = (Button) findViewById(R.id.btn_last);
        iv_error = (ImageView) findViewById(R.id.iv_error);
        mPlayer2 = MediaPlayer.create(QuestionActivity.this, R.raw.ring);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        setupViewPager(viewPager);
    }


    private void initListeners() {
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (adapter != null) {
                    if (mPlayer2.isPlaying()) {
                        mPlayer2.stop();
                    }
                    iv_error.setVisibility(View.GONE);
                    viewPager.setCurrentItem(viewPager.getCurrentItem() + 1, true);

                }
            }
        });

        prevBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (adapter != null) {
                    viewPager.setCurrentItem(viewPager.getCurrentItem() - 1, true);
                    if (mPlayer2.isPlaying()) {
                        mPlayer2.stop();
                    }
                    iv_error.setVisibility(View.GONE);
                }
            }
        });
    }

    private void setupViewPager(ViewPager viewPager) {

        adapter.addFrag(QuestionFragment.newInstance(), "P0166");
        adapter.addFrag(QuestionFragment.newInstance(), "P0166");
        adapter.addFrag(QuestionFragment.newInstance(), "P0166");
        adapter.addFrag(QuestionFragment.newInstance(), "P0166");
        adapter.addFrag(QuestionFragment.newInstance(), "P0166");
        adapter.addFrag(QuestionFragment.newInstance(), "P0166");
        adapter.addFrag(QuestionFragment.newInstance(), "P0166");
        adapter.addFrag(QuestionFragment.newInstance(), "P0166");
        adapter.addFrag(QuestionFragment.newInstance(), "P0166");
        adapter.addFrag(QuestionFragment.newInstance(), "P0166");
        viewPager.setAdapter(adapter);
    }

    public void play() {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                blink();
                mPlayer2.prepareAsync();
                mPlayer2.start();
            }
        };
        new android.os.Handler().postDelayed(runnable, 300);
        mPlayer2.stop();
        iv_error.setVisibility(View.GONE);
    }

    public void blink() {
        iv_error.setVisibility(View.VISIBLE);
        Animation animation1 =
                AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.blinkanim);
        iv_error.startAnimation(animation1);
    }


    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
