package com.example.android.appbar;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by alesiarazumova on 11/14/15.
 */
public class fragmentTab3 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Get the view from fragment_tab_3.xml
        View view = inflater.inflate(R.layout.fragment_tab_3, container, false);
        return view;
    }

}