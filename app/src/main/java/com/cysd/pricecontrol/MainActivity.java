package com.cysd.pricecontrol;


import android.app.Activity;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.cysd.pricecontrol.databinding.ActivityMainBinding;
import com.cysd.pricecontrol.entity.TabEntity;
import com.cysd.pricecontrol.fragment.OneFragment;
import com.cysd.pricecontrol.fragment.ThreeFragment;
import com.cysd.pricecontrol.fragment.TwoFragment;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String[] mTitles = {"入库", "物品", "车载", "预警"};
    private int[] mIconUnselectIds = {
            R.mipmap.tab_1_unselect, R.mipmap.tab_2_unselect,
            R.mipmap.tab_3_unselect, R.mipmap.tab_4_unselect};
    private int[] mIconSelectIds = {
            R.mipmap.tab_1_select, R.mipmap.tab_2_select,
            R.mipmap.tab_3_select, R.mipmap.tab_4_select};
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private ArrayList<Fragment> mFragments = new ArrayList<>();

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mFragments.add(new OneFragment());
        mFragments.add(new TwoFragment());
        mFragments.add(new ThreeFragment());
        mFragments.add(new ThreeFragment());


        binding.viewPage.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));

        //tab填充数据
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
        binding.tabLayout.setTabData(mTabEntities);
        binding.tabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                binding.viewPage.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });
        binding.viewPage.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                binding.tabLayout.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        binding.viewPage.setCurrentItem(0);
    }

    //适配器
    private class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }
    }

    protected int dp2px(float dp) {
        final float scale = getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }
}