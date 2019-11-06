package com.example.myapplication000;

import androidx.appcompat.app.AppCompatActivity;

import com.microsoft.appcenter.AppCenter;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.Crashes;
import com.microsoft.appcenter.push.Push;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //添加按钮
        Button btn_click = (Button)findViewById(R.id.button_001);
        Button btn2_click = (Button)findViewById(R.id.button_002);

        //添加点击事件
        btn_click.setOnClickListener(new MyOnClickListenwe());
        btn2_click.setOnClickListener(new MyOnClickListenwe2());

        AppCenter.start(getApplication(), "a0fdc060-08d7-4920-aa90-f34913041780", Analytics.class, Crashes.class, Push.class);
    }
    private class MyOnClickListenwe implements View.OnClickListener{
        public void onClick(View v){
            if(v.getId() == R.id.button_001){
                Map<String, String> properties = new HashMap<>();
                properties.put("Category", "Music");
                properties.put("FileName", "favorite.avi");
                Analytics.trackEvent("Event Without properties clicked");
                Analytics.trackEvent("Event properties clicked", properties);
            }
        }
    }

    private class MyOnClickListenwe2 implements View.OnClickListener{
        public void onClick(View v){
            if(v.getId() == R.id.button_002){
                int x = 1/0;
                Crashes.generateTestCrash();
            }
        }
    }

}


