package zomaru.sendmequotes;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import layout.osl;
import layout.library;

public class FVPoslpluslib extends FragmentPagerAdapter {

    public static int number_tabs = 2;
    private String tabTitle[] = new String[] {"Open Source License", "Library"};

    public FVPoslpluslib(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new osl();
            case 1:
                return new library();
        }
        return null;
    }

    @Override
    public int getCount() {
        return number_tabs;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitle[position];
    }
}
