package com.example.wjk.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

public class MainActivity extends Activity implements View.OnClickListener {
    
    private LinearLayout mLayout;
    private Button mFirst;
    private Button mSecond;
    private Button mThird;
    PopupWindow mPopup;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mLayout = (LinearLayout) this.findViewById(R.id.mylayout);
        mFirst = (Button) this.findViewById(R.id.first);
        mSecond = (Button) this.findViewById(R.id.second);
        mThird = (Button) this.findViewById(R.id.third);
        
        mLayout.setOnClickListener(this);
        mFirst.setOnClickListener(this);
        mSecond.setOnClickListener(this);
        mThird.setOnClickListener(this);
        
    }
    
    
    @Override
    public void onClick(View v) {
    
    }
}