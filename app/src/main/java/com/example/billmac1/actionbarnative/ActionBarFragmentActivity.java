package com.example.billmac1.actionbarnative;

import android.app.Activity;
import android.os.Bundle;


public class ActionBarFragmentActivity extends Activity {


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getFragmentManager().findFragmentById(android.R.id.content) == null) {
            getFragmentManager().beginTransaction()
                    .add(android.R.id.content,
                            new ActionBarFragment()).commit();
        }
    }

}
