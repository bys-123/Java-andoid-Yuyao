package com.example.myapplication000;

import androidx.appcompat.app.AppCompatActivity;

import com.microsoft.appcenter.AppCenter;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.Crashes;

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
        //添加点击事件
        btn_click.setOnClickListener(new MyOnClickListenwe());

        AppCenter.start(getApplication(), "686737c0-e7a9-4f8c-b65b-04d9bf681177", Analytics.class, Crashes.class);
    }
    private class MyOnClickListenwe implements View.OnClickListener{
        public void onClick(View v){
            if(v.getId() == R.id.button_001){
                Map<String, String> properties = new HashMap<>();
                properties.put("Category", "Music");
                properties.put("FileName", "favorite.avi");
                Analytics.trackEvent("Video clicked");
                Analytics.trackEvent("Video clicked", properties);
            }
        }
    }

}


