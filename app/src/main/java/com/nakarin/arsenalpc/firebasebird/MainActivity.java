package com.nakarin.arsenalpc.firebasebird;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.nakarin.arsenalpc.firebasebird.fragment.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //addfragment
        if (savedInstanceState == null) {

            //ADD Fragment to activity

            getSupportFragmentManager().beginTransaction().add(R.id.contentMainFragment, new MainFragment()).commit();        }
    }//main method

}//mainclass
