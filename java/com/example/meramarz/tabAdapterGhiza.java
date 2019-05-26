package com.example.meramarz;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


public class tabAdapterGhiza extends FragmentStatePagerAdapter {

    String[] tabarray = new String[]{"ذیابیطس", "دل کے امراض",};
    Integer tabnumber = 2;

    public tabAdapterGhiza(FragmentManager fm) {
        super(fm);
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return tabarray[position];
    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                AllVideos all =new AllVideos();
                return all;
            case 1:
                RecommendedVideos recommend = new RecommendedVideos();
                return recommend;
        }
        return null;
    }

    @Override
    public int getCount() {
        return tabnumber;
    }
}
