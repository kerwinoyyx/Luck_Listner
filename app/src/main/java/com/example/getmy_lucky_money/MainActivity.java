package com.example.getmy_lucky_money;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import static android.provider.Settings.ACTION_ACCESSIBILITY_SETTINGS;
import static android.provider.Settings.ACTION_VOICE_INPUT_SETTINGS;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        Button button=findViewById(R.id.bt1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(ACTION_ACCESSIBILITY_SETTINGS);
                //启动辅助设置
                startActivity(intent1);
            }
        });













    }


    public void onWindowFocusChanged(boolean hasWindowFocus) {
//如果当前的界面所有控件准备好之后(保证现在看到的是当前activty而不是其他的activity)，那么呼叫
        //onresume（控件准本好）也会触发
        //ativty停止不会呼叫

        if (hasWindowFocus==true) {
            Log.e("testt","on ready");



        }
    }











}
