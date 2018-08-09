package com.soumit.fragmentcomm;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentB extends Fragment {
    private static final String TAG = "FragmentB";

    TextView textView;
    String data;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_b, container, false);
        if(savedInstanceState == null){

        }else {
            data = savedInstanceState.getString("data", "");
            TextView myText = view.findViewById(R.id.textView);
            myText.setText(data);
        }

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        textView = getActivity().findViewById(R.id.textView);
    }

    public void changeText(String data){
        this.data = data;
        textView.setText(data);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("data", data);
    }
}
