package com.leacuke.android.modernartui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;


public class MyDialogFragment extends DialogFragment {
    private static final String MOMA_LINK ="http://www.moma.org/learn/index" ;
    Context mContext;

    static MyDialogFragment newInstance() {
        MyDialogFragment mDialogFragment = new MyDialogFragment();
        //Set Arguments here if needed for dialog auto recreation on screen rotation
        mDialogFragment.setStyle(DialogFragment.STYLE_NO_TITLE, 0);
        return mDialogFragment;
    }

    public MyDialogFragment() {
        mContext = getActivity();
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new AlertDialog.Builder(getActivity())
                .setMessage(R.string.alert_message)
                .setNegativeButton(R.string.alert_cancel, null)
                .setPositiveButton(R.string.alert_visit_moma, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(MOMA_LINK));
                        startActivity(intent);
                    }
                })
                .create();
    }

}
