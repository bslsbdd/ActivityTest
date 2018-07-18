package com.example.jerry.activitytest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ThirdActivity extends BaseActivity {
    private static final String TAG = "ThirdActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_layout);

        Log.d(TAG, "Task id is:" + getTaskId());

        Button finishAll = (Button) findViewById(R.id.button_1);
        finishAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityController.finishAll();
                android.os.Process.killProcess(android.os.Process.myPid());
            }
        });

    }
}
