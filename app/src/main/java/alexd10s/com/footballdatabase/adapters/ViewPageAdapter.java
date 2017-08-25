package alexd10s.com.footballdatabase.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import alexd10s.com.footballdatabase.fragments.TabFixtures;
import alexd10s.com.footballdatabase.fragments.TabTable;
import alexd10s.com.footballdatabase.fragments.TabTeams;

/**
 * Created by alex on 13/08/2017.
 */

public class ViewPageAdapter extends FragmentPagerAdapter {
    CharSequence Titles[] = {"Table","Teams","Fixtures"};
    int NumbOfTabs = 3;
    private Context mContext;

    // Build a Constructor and assign the passed Values to appropriate values in the class
    public ViewPageAdapter (Context context,FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    //This method return the fragment for the every position in the View Pager
    @Override
    public Fragment getItem(int position) {
        if(position == 0)
        {
            TabTable tab1 = new TabTable();
            return tab1;
        }
        else if(position == 1)
        {
            TabTeams tab2 = new TabTeams();
            return tab2;
        }
        else{
            TabFixtures tab3 = new TabFixtures();
            return tab3;
        }



    }

    // This method return the titles for the Tabs in the Tab Strip

    @Override
    public CharSequence getPageTitle(int position) {
        return Titles[position];
    }

    // This method return the Number of tabs for the tabs Strip

    @Override
    public int getCount() {
        return NumbOfTabs;
    }

}
