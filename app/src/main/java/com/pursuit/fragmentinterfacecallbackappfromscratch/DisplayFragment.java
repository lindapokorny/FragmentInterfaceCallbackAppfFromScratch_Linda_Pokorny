package com.pursuit.fragmentinterfacecallbackappfromscratch;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DisplayFragment extends Fragment {
    public static final String KEY = "DisplayFragment";
    public static final String ARG_PARAM1 = "param1";
    public static final String ARG_PARAM2 = "param2";
    public static final String ARG_PARAM3 = "param3";
    private String mParam1;
    private String mparam2;
    private String mparam3;
    private View rootView;
    private TextView displayTextView1;
    private TextView displayTextView2;
    private TextView displayTextView3;



    public DisplayFragment() {
        // Required empty public constructor
    }
    public static DisplayFragment newInstance(String param1, String param2, String param3){
        DisplayFragment fragment = new DisplayFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        args.putString(ARG_PARAM3, param3);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null){
            mParam1 = getArguments().getString(ARG_PARAM1);
            mparam2 = getArguments().getString(ARG_PARAM2);
            mparam3 = getArguments().getString(ARG_PARAM3);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_display, container, false);
        displayTextView1 = rootView.findViewById(R.id.display_fragment_textView1);
        displayTextView2 = rootView.findViewById(R.id.display_fragment_textView2);
        displayTextView3 = rootView.findViewById(R.id.display_fragment_textView3);
        displayTextView1.setText(mParam1);
        Log.e("parameter1: ", mParam1);
        displayTextView2.setText(mparam2);
        Log.e("parameter2: ", mparam2);

        displayTextView3.setText(mparam3);
        Log.e("parameter3: ", mparam3);

        return rootView;
    }

}
