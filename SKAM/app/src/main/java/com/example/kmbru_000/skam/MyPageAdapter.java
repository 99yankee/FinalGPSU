package com.example.kmbru_000.skam;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;
import java.util.Locale;

/**
 * Created by kmbru_000 on 4/20/2015.
 */
public class MyPageAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments;

    public MyPageAdapter(FragmentManager fm, List<Fragment>fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return this.fragments.get(position);
    }

    @Override
    public int getCount() {
        return this.fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Locale l = Locale.getDefault();
        String name;
        switch (position) {
            case 0:
                name = "The Quad";
                break;
            case 1:
                name = "Crouse";
                break;
            case 2:
                name = "Hall of Languages";
                break;
            case 3:
                name="Slocum Hall";
                break;
            case 4:
                name="Whitman Hall";
                break;
            case 5:
                name="The University";
                break;
            case 6:
                name="Shaffer Hall";
                break;
            case 7:
                name="Life Sciences";
                break;
            default:
                name="Inside the Dome";
                break;
        }
        return name.toUpperCase();
    }
}
