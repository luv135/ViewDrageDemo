package com.example.luowei.viewdragedemo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ItemFragment extends Fragment {


    private static final String POS = "POS";

    public ItemFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_item, container, false);
        TextView textView = (TextView) view.findViewById(R.id.text);
        Bundle arguments = getArguments();
        textView.setText(String.valueOf(arguments.getInt(POS)));
        return view;
    }

    public static Fragment newInstance(int pos) {
        ItemFragment fragment = new ItemFragment();
        Bundle bundle=new Bundle();
        bundle.putInt(POS,pos);
        fragment.setArguments(bundle);
        return fragment;
    }
}
