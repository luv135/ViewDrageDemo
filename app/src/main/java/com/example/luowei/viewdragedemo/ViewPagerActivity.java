package com.example.luowei.viewdragedemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

public class ViewPagerActivity extends AppCompatActivity {

    private Fragment[] items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

//        ViewGroup decorView = (ViewGroup) getWindow().getDecorView();
//        View oldScreen = decorView.getChildAt(0);
//        decorView.removeViewAt(0);
//
//        // Setup the slider panel and attach it to the decor
//        final SliderPanel panel = new SliderPanel(this, oldScreen);
//        panel.setId(R.id.slidable_panel);
//        oldScreen.setId(R.id.slidable_content);
//        panel.addView(oldScreen);
//        decorView.addView(panel, 0);

        final View root = findViewById(R.id.root);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        items = new Fragment[10];
        for (int i = 0; i < 10; i++) {
            items[i] = ItemFragment.newInstance(i);
        }


        items[2] = new BlankFragment();
        items[3] = new ViewPagerFragment();

        MyViewPager viewPager = (MyViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public int getCount() {
                return items.length;
            }

            @Override
            public Fragment getItem(int position) {
                return items[position];
            }
        });


        viewPager.addOnPageChangeListener(new MyViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                d(String.format("position=%d, positionOffset=%f, positionOffsetPixels=%d",
                        position, positionOffset, positionOffsetPixels));
//                if(position==0){
//                    root.setTranslationX(-positionOffsetPixels);
//                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                d("state=" + state);
            }
        });

    }

    private void d(String s) {
        Log.d("HEHE", s);
    }

}
