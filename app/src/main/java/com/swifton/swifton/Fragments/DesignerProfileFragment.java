package com.swifton.swifton.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.swifton.swifton.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class DesignerProfileFragment extends Fragment {


    public DesignerProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_designer_profile, container, false);
    }

}
