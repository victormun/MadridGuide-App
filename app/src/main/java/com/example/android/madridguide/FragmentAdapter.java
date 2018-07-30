package com.example.android.madridguide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Custom FragmentPagerAdapter that allows to implement the Fragment View
 */

public class FragmentAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public FragmentAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    /** @return the fragment based on the position of the ViewPager **/
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new MuseumsFragment();
        } else if (position == 1){
            return new ParksFragment();
        } else if (position == 2){
            return new SightseeingsFragment();
        } else {
            return new RestaurantsFragment();
        }
    }

    /** @return the title of each page of the ViewPager **/
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.title_museums);
        } else if (position == 1) {
            return mContext.getString(R.string.title_parks);
        } else if (position == 2) {
            return mContext.getString(R.string.title_sightseeings);
        } else {
            return mContext.getString(R.string.title_restaurants);
        }
    }

    /** @return the number of pages contained by the ViewPager **/
    @Override
    public int getCount() { return 4; }
}
