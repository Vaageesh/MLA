package com.tabView.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.tabview.mlapp.fragment.*;

/**
 * Created by vageesh on 3/10/15.
 */
public class FragmentAdapter extends FragmentPagerAdapter {
    public FragmentAdapter(FragmentManager fm){
        super(fm);
    }
    @Override
    public Fragment getItem(int index) {

        switch (index) {
            case 0:

                return new NewsFragment();
            case 1:

                return new AboutUsFragment();

            case 2:

                return new BiographyFragment();
            case 3 :
                return new ContactFragment();
            case 4 :
                return new GalleryFragment();
            case 5 :
                return new AudioFragment();
            case 6 :
                return new VideoFragment();
            case 7 :
                return new FacebookFragment();
        }

        return null;
    }

    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 8;
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }
}
