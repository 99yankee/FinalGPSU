package com.example.kmbru_000.skam;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
/**
 * Created by kmbru_000 on 4/19/2015.
 *
 * This activity is called by the navigation bar.
 * It contains a list of the fragments used in the MyPageAdapter
 * and the animation to use when swiping between fragments.f
 *
 */
public class ViewsofCuseActivity extends FragmentActivity {

    MyPageAdapter pageAdapter;
    ViewPager pager;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewsof_cuse);
        List<Fragment> fragments = getFragments();
        pageAdapter = new MyPageAdapter(getSupportFragmentManager(), fragments);
        pager = (ViewPager)findViewById(R.id.pager);
        customizeViewPager(); //customize to add animation when sliding between fragments
        pager.setAdapter(pageAdapter);
    }

    //Create list of fragment instances to pass to ViewsofCuseFragment
    private List<Fragment> getFragments() {
        List<Fragment> fList = new ArrayList<Fragment>();

        fList.add(ViewsofCuseFragment.newInstance("0"));
        fList.add(ViewsofCuseFragment.newInstance("1"));
        fList.add(ViewsofCuseFragment.newInstance("2"));
        fList.add(ViewsofCuseFragment.newInstance("3"));
        fList.add(ViewsofCuseFragment.newInstance("4"));
        fList.add(ViewsofCuseFragment.newInstance("5"));
        fList.add(ViewsofCuseFragment.newInstance("6"));
        fList.add(ViewsofCuseFragment.newInstance("7"));
        fList.add(ViewsofCuseFragment.newInstance("8"));

        return fList;
    }

    //Adds animation when sliding between fragments
    private void customizeViewPager() {

        pager.setPageTransformer(false, new ViewPager.PageTransformer() {
            @Override
            public void transformPage(View page, float position) {
                //scaling animation
                final float normalizedposition = Math.abs(Math.abs(position) - 1);
                page.setScaleX(normalizedposition / 2 + 0.5f);
                page.setScaleY(normalizedposition / 2 + 0.5f);

            }
        });

        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i2) {
            }

            @Override
            public void onPageSelected(int i) {
            }

            @Override
            public void onPageScrollStateChanged(int i) {
            }
        });
    }
}