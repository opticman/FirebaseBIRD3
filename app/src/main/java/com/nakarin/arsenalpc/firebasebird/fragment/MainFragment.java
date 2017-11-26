package com.nakarin.arsenalpc.firebasebird.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.nakarin.arsenalpc.firebasebird.R;
import com.nakarin.arsenalpc.firebasebird.utility.MyAlertDialog;


/**
 * Created by masterung on 25/11/2017 AD.
 */

public class MainFragment extends Fragment{

    //    Explicit
    private String emailString, passwordString;


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        Register Controller
        registerController();

//        Login Controller
        loginController();

    }   // Main Method

    private void loginController() {

        Button button = getView().findViewById(R.id.btnlogin);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Initial View
                EditText emailEditText = getView().findViewById(R.id.edtemail);
                EditText passwordEditText = getView().findViewById(R.id.edtpassword);

//                Get Value From EditText
                emailString = emailEditText.getText().toString().trim();
                passwordString = passwordEditText.getText().toString().trim();
//                Check Spec
                if (emailString.isEmpty() || passwordString.isEmpty()) {
//                    Have Spec
                    MyAlertDialog myAlertDialog = new MyAlertDialog(getActivity());
                    myAlertDialog.myNormalDialog("Have spec", getString(R.string.sub_register));
                } else{
//                    NO Space

                    CheckEmailAnpass ();
                }

            }
        });

    }

    private void CheckEmailAnpass() {

        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.signInWithEmailAndPassword(emailString, passwordString)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {

                            Toast.makeText(getActivity(),"welcome",
                                    Toast.LENGTH_SHORT).show();

                        } else {

                            MyAlertDialog myAlertDialog = new MyAlertDialog(getActivity());
                            myAlertDialog.myNormalDialog("Authen False",
                                    task.getException().getMessage());

                        }
                    }
                });
    }

    private void registerController() {
        TextView textView = getView().findViewById(R.id.txtNewregister);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contentMainFragment, new RegisterFragment())
                        .addToBackStack(null).commit();

            }   // onClick
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        return view;
    }
}   // Main Class