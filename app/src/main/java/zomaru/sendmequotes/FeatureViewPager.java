package zomaru.sendmequotes;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import layout.normal;
import layout.root;

public class FeatureViewPager extends FragmentPagerAdapter{

    public static int number_tabs = 2;
    private String tabTitle[] = new String[] {"Normal", "Extreme (ROOT)"};

    public FeatureViewPager(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new normal();
            case 1:
                return new root();
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
