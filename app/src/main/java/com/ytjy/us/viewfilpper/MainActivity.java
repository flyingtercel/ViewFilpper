package com.ytjy.us.viewfilpper;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "TAG";
    private ViewFlipper mViewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
    }

    private void findView() {
        mViewFlipper = findViewById(R.id.viewFlipper);

        for(int i=0;i<10;i++){
            TextView tView = new TextView(this);
            tView.setId(i);
            tView.setLayoutParams(new RadioGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            tView.setGravity(Gravity.CENTER_VERTICAL);
            tView.setText("广告轮播卡拉胶看看垃圾堆里看风景爱丽丝的房间"+i);
             mViewFlipper.addView(tView);
             tView.setBackgroundColor(Color.parseColor("#ff9f9f"));
        }

        //设置动画切换的时间间隔
        mViewFlipper.setFlipInterval(2000);
        //设置进入的动画
        mViewFlipper.setInAnimation(this,R.anim.roll_in);
        //设置退出的动画
        mViewFlipper.setOutAnimation(this,R.anim.roll_out);
        //设置动画启动  如果是停止用stopFlipping();
        mViewFlipper.startFlipping();
        //设置监听事件
        mViewFlipper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = mViewFlipper.getCurrentView().getId();
                Log.d(TAG, "onClick: ====="+id);

            }
        });
        boolean flippingState = mViewFlipper.isFlipping();
    }
}
