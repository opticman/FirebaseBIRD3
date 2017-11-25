package com.nakarin.arsenalpc.firebasebird.utility;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import com.nakarin.arsenalpc.firebasebird.R;

/**
 * Created by Arsenal Pc on 25-Nov-17.
 */

public class MyAlertDialog {
    private Context context;

    public MyAlertDialog(Context context) {
        this.context = context;
    }

    public void myNormalDialog(String strTitle, String strMessage){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(false);
        builder.setIcon(R.drawable.ic_action_alert);
        builder.setTitle(strMessage);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }


}//Main class
