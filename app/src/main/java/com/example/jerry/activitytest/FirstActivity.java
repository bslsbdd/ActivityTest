package com.example.jerry.activitytest;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends BaseActivity {
    private static final String TAG = "FirstActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);

        //Log.d(TAG, this.toString());
        Log.d(TAG, "Task id is:" + getTaskId());

        Button button1 = (Button) findViewById(R.id.button_1);
        Button button2 = (Button) findViewById(R.id.button_2);
        Button button3 = (Button) findViewById(R.id.button_3);
        Button button4 = (Button) findViewById(R.id.button_4);
        Button button5 = (Button) findViewById(R.id.button_5);
        Button button6 = (Button) findViewById(R.id.button_6);
        Button button7 = (Button) findViewById(R.id.button_7);
        Button button8 = (Button) findViewById(R.id.button_8);
        Button button9 = (Button) findViewById(R.id.button_9);
        Button standardActivity = (Button) findViewById(R.id.button_10);

        //测试Standard Activity
        standardActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // new Intent(启动活动时的上下文， 要启动的活动)
                Intent intent = new Intent(FirstActivity.this, FirstActivity.class);
                startActivity(intent);
            }
        });

        //Toast 短暂显示信息
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(FirstActivity.this, "You Clicked Button 1",
                        Toast.LENGTH_SHORT).show();
            }
        });

        //finish 结束活动
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //显示Intent
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // new Intent(启动活动时的上下文， 要启动的活动)
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        //隐式 Intent 启动Action类型为ACTION_STATR的活动
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("com.example.jerry.activitiytest.ACTION_START");
                startActivity(intent);
            }
        });

        //隐式 Intent 启动Action类型为ACTION_STATR， Category为MY_CATEGORY的活动
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("com.example.jerry.activitiytest.ACTION_START");
                intent.addCategory("com.example.jerry.activitiytest.MY_CATEGORY");
                startActivity(intent);
            }
        });

        //隐式 Inten 启动其他程序的活动
        //启动网页： Action_view, setData, Uri.parse
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);
            }
        });

        //隐式 Inten 启动其他程序的活动
        //打电话： Action_dial, setData, Uri.parse
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);
            }
        });

        //向新的活动传输信息
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data1 = "Hello SecondActivity";
                String data2 = "Better than before";
                SecondActivity.actionStart(FirstActivity.this, data1, data2);
            }
        });

        //从别的活动得到信息
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                startActivityForResult(intent,1);
            }
        });
    }
    //创建目录
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // inflate(the menu layout file, the menu object we add menu to)
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    // give items inside menu function
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this, "You clicked Add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "You clicked Remove", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }

    //处理得到的数据
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode){
            case 1:
                if (resultCode == RESULT_OK){
                    String returnedData = data.getStringExtra("data_return");
                    Log.d(TAG, returnedData);
                }
                break;
            default:
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }
}
