package com.duybui.appium;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.duybui.robolectric.R;

public class MainActivity extends AppCompatActivity {

    private TextView mTvText;

    private Button mBtnClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTvText = findViewById(R.id.tvText);
        mBtnClick = findViewById(R.id.btnClick);

        mBtnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTvText.setText("123");
            }
        });
    }
}
