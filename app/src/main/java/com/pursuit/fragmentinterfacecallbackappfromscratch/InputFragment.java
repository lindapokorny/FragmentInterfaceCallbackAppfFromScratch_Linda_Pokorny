package com.pursuit.fragmentinterfacecallbackappfromscratch;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class InputFragment extends Fragment {
    private View rootView;
    private EditText input1;
    private EditText input2;
    private EditText input3;
    private Button submitButton;
    private FragmentInterface listener;

    public static InputFragment newInstance() {
        return new InputFragment();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_input, container, false);
        input1 = rootView.findViewById(R.id.edit_text1);
        input2 = rootView.findViewById(R.id.edit_text2);
        input3 = rootView.findViewById(R.id.edit_text3);
        submitButton = rootView.findViewById(R.id.submit_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputtextString1 = input1.getText().toString();
                String inputtextString2 = input2.getText().toString();
                String inputtextString3 = input3.getText().toString();
                onButtonPressed(inputtextString1, inputtextString2, inputtextString3); {
                }
            }
        });
        return rootView;
    }

    public void onButtonPressed(String input1, String input2, String input3) {
        if (listener != null) {
            listener.toDisplayFragment(input1, input2, input3);
        }

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentInterface) {
            listener = (FragmentInterface) context;
        } else {
            throw new RuntimeException(context.toString() + "input fragment");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;

    }

    public interface FragmentInterface {
        void toDisplayFragment(String input1, String input2, String input3);

    }
}