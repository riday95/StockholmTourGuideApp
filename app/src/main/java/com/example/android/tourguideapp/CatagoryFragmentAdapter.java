package com.example.android.tourguideapp;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class CatagoryFragmentAdapter extends FragmentPagerAdapter {

    private Context context;

    public CatagoryFragmentAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new SightsFragment();
        } else if (position == 1) {
            return new ShopsFragment();
        } else if (position == 2){
            return new FoodFragment();
        } else {
            return new TransportFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return context.getString(R.string.catagory_sights);
        } else if (position == 1) {
            return context.getString(R.string.catagory_shops);
        } else if (position == 2) {
            return context.getString(R.string.catagory_food);
        } else {
            return context.getString(R.string.catagory_transport);
        }
    }
}
