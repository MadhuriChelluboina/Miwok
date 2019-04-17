package com.example.miwok;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    Context mContext;
    public ViewPagerAdapter(FragmentManager fm, Context mContext) {
        super(fm);
        this.mContext=mContext;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return mContext.getString(R.string.numbers_label);
            case 1:
                return mContext.getString(R.string.familyMembers_label);
            case 2:
                return mContext.getString(R.string.colors_label);
            case 3:
                return mContext.getString(R.string.phrases_label);
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new NumberFragment();
            case 1:
                return new FamilyFragment();
            case 2:
                return new ColorsFragment();
            case 3:
                return new PhrasesFragment();
            default:
                return null;
        }

    }

}
