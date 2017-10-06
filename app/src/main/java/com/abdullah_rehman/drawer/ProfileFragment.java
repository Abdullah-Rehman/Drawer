package com.abdullah_rehman.drawer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.HashMap;


public class ProfileFragment extends Fragment {

    TextView tvEmail;

    SessionManager sessionManager;
    HashMap<String, String> userDetails;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        sessionManager = new SessionManager(getActivity().getApplicationContext());
        userDetails = sessionManager.getUserDetails();

        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        tvEmail = (TextView) view.findViewById(R.id.tvEmail);
        String userEmail = userDetails.get(SessionManager.KEY_EMAIL);
        tvEmail.setText(userEmail);

        // Inflate the layout for this fragment
        return view;
    }

}
