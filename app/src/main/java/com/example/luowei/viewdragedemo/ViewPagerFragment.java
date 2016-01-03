package com.example.luowei.viewdragedemo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class ViewPagerFragment extends Fragment {


    private Fragment[] items;

    public ViewPagerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_view_pager, container, false);
        MyViewPager viewPager = (MyViewPager) view.findViewById(R.id.viewPager);

        items = new Fragment[3];
        for (int i = 0; i < 3; i++) {
            items[i] = ItemFragment.newInstance(i + 100);
        }

        viewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return items[position];
            }

            @Override
            public int getCount() {
                return items.length;
            }
        });
        return view;
    }

}
