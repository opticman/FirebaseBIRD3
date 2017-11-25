package com.nakarin.arsenalpc.firebasebird.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.nakarin.arsenalpc.firebasebird.MainActivity;
import com.nakarin.arsenalpc.firebasebird.R;

/**
 * Created by Arsenal Pc on 25-Nov-17.
 */

public class RegisterFragment extends Fragment {

    //    Explict
    private String tag = "25Nov1";
    private String nameString, emailString, passwordString;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        Create Toolbar
        createToolbar();

//        create menu icon

        setHasOptionsMenu(true);

    }//Main method

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.itemSave) {
            CheckSpec();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void CheckSpec() {

        Log.d(tag, "CheckSpec Work");

//        Initial View
        EditText nameEditText = getView().findViewById(R.id.edtname);
        EditText emailEditText = getView().findViewById(R.id.edtemail);
        EditText passwodEditText = getView().findViewById(R.id.edtpassword);

//        Get Value Frome EditText
        nameString = nameEditText.getText().toString().trim();
        emailString = emailEditText.getText().toString().trim();
        passwordString = passwodEditText.getText().toString().trim();


    }//Check spec

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        inflater.inflate(R.menu.menu_save, menu);

        super.onCreateOptionsMenu(menu, inflater);

    }


    private void createToolbar() {
        Toolbar toolbar = getView().findViewById(R.id.toolberResgiter);
        ((MainActivity) getActivity()).setSupportActionBar(toolbar);

//        setup title
        ((MainActivity) getActivity()).getSupportActionBar().setSubtitle(getString(R.string.register));
        ((MainActivity) getActivity()).getSupportActionBar().setSubtitle(getString(R.string.sub_register));

//        back Icon
        ((MainActivity) getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
        ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        return view;

    }
} //Main Class
