package com.abdullah_rehman.drawer;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class LoginFragment extends Fragment {

    Button btnLogin, btnRegister;
    EditText etEmail, etPassword;
    FragmentManager fragmentManager;
    SessionManager sessionManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        fragmentManager = getFragmentManager();
        sessionManager = new SessionManager(getActivity().getApplicationContext());

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        btnLogin = (Button) view.findViewById(R.id.btnLogin);
        btnRegister = (Button) view.findViewById(R.id.btnRegister);
        etEmail = (EditText) view.findViewById(R.id.etEmail);
        etPassword = (EditText) view.findViewById(R.id.etPassword);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentManager.beginTransaction()
                        .replace(R.id.baseContainer, new RegisterFragment())
                        .addToBackStack("").commit();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(etEmail.getText())) {
                    etEmail.setError("Required");
                    etEmail.requestFocus();
                } else if (TextUtils.isEmpty(etPassword.getText())) {
                    etPassword.setError("Required");
                    etPassword.requestFocus();
                } else {
                    String email, password;
                    email = etEmail.getText().toString();
                    password = etPassword.getText().toString();
                    sessionManager.createLoginSession(email, password);
                    getActivity().finish();
                }
            }
        });
        return view;
    }
}
